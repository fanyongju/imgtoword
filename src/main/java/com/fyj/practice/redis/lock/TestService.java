package com.fyj.practice.redis.lock;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author fanyongju
 * @Title: TestService
 * @date 2019/11/13 14:42
 */
@Service
public class TestService {
    @Autowired
    private RedisLockService redisLockService;

    private static Logger logger = LoggerFactory.getLogger(TestService.class);

    @PostConstruct
    public void init() throws InterruptedException {
        Thread t1 = new Thread(this::test);
        t1.setName("t1");
        t1.start();
        Thread t2 = new Thread(this::test);
        t2.setName("t2");
        t2.start();
    }

    public void test() {
        //集群环境 定时任务加锁，保证执行一次 异常情况6个小时 释放锁
        String lock = redisLockService.acquireDistributedLockWithTimeout("redisTestLock", 10, 10);//锁要求10毫秒加好
        //判断是否获得锁
        if (StringUtils.isNotBlank(lock)) {
            logger.info("{} 定时任务 开始执行: {}",Thread.currentThread().getName(), lock);
            try {
                logger.info("{}干活了",Thread.currentThread().getName());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                //释放锁
                redisLockService.releaseDistributedLock("incomeStatistics", lock);
                logger.info("{}定时任务执行完成",Thread.currentThread().getName());
            }
        }
    }
}
