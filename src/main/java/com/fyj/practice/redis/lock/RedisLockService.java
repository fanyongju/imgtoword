package com.fyj.practice.redis.lock;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author fanyongju
 * @Title: RedisLockService
 * @date 2019/11/13 14:40
 */
@Service
public class RedisLockService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private static Logger logger = LoggerFactory.getLogger(RedisLockService.class);

    public String acquireDistributedLockWithTimeout(String lockName, long acquireTimeout, int lockTimeout) {
        String lockValue = UUID.randomUUID().toString();
        String lockKey = "lock:" + lockName;
        long acquireTime = System.currentTimeMillis() + acquireTimeout;
        while (acquireTime > System.currentTimeMillis()) {
            boolean locked = redisTemplate.opsForValue().setIfAbsent(lockKey, lockValue);
            logger.info(Thread.currentThread().getName() + "fyj" + lockValue + "...." + locked);
            if (locked) {
                redisTemplate.expire(lockKey, (long) lockTimeout, TimeUnit.SECONDS);
                return lockValue;
            }
            try {
                TimeUnit.MILLISECONDS.sleep(1L);//线程睡1毫秒，防止在加锁过程中重复争抢
            } catch (InterruptedException var12) {
                Thread.currentThread().interrupt();
            }
        }

        return null;
    }

    public boolean releaseDistributedLock(String lockName, String lockValue) {
        String lockKey = "lock:" + lockName;
        List<Object> result = null;
        do {
            System.out.println("进去了");
            redisTemplate.watch(lockKey);
            if (!lockValue.equals(redisTemplate.opsForValue().get(lockKey))) {
                break;
            }
            redisTemplate.delete(lockKey);
        } while (result == null);
        System.out.println("出来了");
        redisTemplate.unwatch();
        return true;
    }
}
