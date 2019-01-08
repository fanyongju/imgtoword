package com.fyj.practice.redis.client;

import com.fyj.practice.redis.connection.Connection;
import com.fyj.practice.redis.protocol.Protocol;

/**
 * @author fanyongju
 * @Title: Client Api层(提供给用户包装好的接口)
 * @date 2019/1/8 11:33
 */
public class Client {
    Connection connection;

    public Client(String host, Integer port) {
        this.connection = new Connection(host, port);
    }

    public String set(String key, String value) {
        connection.sendCommand(Protocol.Command.SET, key.getBytes(), value.getBytes());
        return connection.getStatusCodeReply();
    }

    public String get(String key) {
        connection.sendCommand(Protocol.Command.GET, key.getBytes());
        return connection.getStatusCodeReply();
    }
}
