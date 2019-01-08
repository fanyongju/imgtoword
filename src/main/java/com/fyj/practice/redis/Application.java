package com.fyj.practice.redis;

import com.fyj.practice.redis.client.Client;
import redis.clients.jedis.Jedis;

/**
 * @author fanyongju
 * @Title: Application
 * @date 2019/1/7 16:46
 */
public class Application {
    /*public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost",7001);
        jedis.set("fyj","2020");
        System.out.println(jedis.get("fyj"));
    }*/

    public static void main(String[] args) {
        Client client = new Client("172.16.10.29",7001);
        client.set("fyj","2022");
        System.out.println(client.get("fyj"));
        Jedis jedis = new Jedis("localhost",7001);
        jedis.set("fyj","2020");
        System.out.println(jedis.get("fyj"));
    }
}
