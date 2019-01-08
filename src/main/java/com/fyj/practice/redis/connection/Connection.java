package com.fyj.practice.redis.connection;

import com.fyj.practice.redis.protocol.Protocol;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author fanyongju
 * @Title: Connection 数据链接层
 * @date 2019/1/7 18:00
 */
public class Connection {
    private Socket socket;
    private String host;
    private Integer port;
    private InputStream inputStream;
    private OutputStream outputStream;

    public Connection(String host, Integer port) {
        this.host = host;
        this.port = port;
    }

    public Connection connection() {
        if (!isConnected()) {
            try {
                socket = new Socket(host, port);
                inputStream = socket.getInputStream();
                outputStream = socket.getOutputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public Connection sendCommand(Protocol.Command command, byte[]... args) {
        connection();
        Protocol.sendCommand(outputStream, command, args);
        return this;
    }

    public String getStatusCodeReply() {
        byte[] bytes = new byte[1024];
        try {
            socket.getInputStream().read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(bytes);
    }

    public boolean isConnected() {
        return socket != null && socket.isBound() && !socket.isClosed() && socket.isConnected()
                && !socket.isInputShutdown() && !socket.isOutputShutdown();
    }
}
