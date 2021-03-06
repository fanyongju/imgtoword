package com.fyj.imgtoword;

import net.jodah.expiringmap.ExpirationPolicy;
import net.jodah.expiringmap.ExpiringMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ImgtowordApplicationTests {
    public static ExpiringMap<String, String> map = ExpiringMap.builder().expiration(5000, TimeUnit.MILLISECONDS)
            .expirationPolicy(ExpirationPolicy.CREATED)
            .build();
    private static ExecutorService threadPool = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            threadPool.execute(() -> process());
        }
    }

    public static void process() {
        //我在修复bug
        System.out.println(map.hashCode());
        map.put("key", "value");
        System.out.println(Thread.currentThread().getName() + " key:" + map.get("key"));
        //等待5秒
        try {
            Thread.sleep(4001);
            System.out.println(Thread.currentThread().getName() + map.get("key"));
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + map.get("key"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
