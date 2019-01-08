package com.fyj.practice.redis.hack;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author fanyongju
 * @Title: Hack
 * @date 2019/1/7 19:03
 */
public class Hack {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(7001);
        Socket socket = serverSocket.accept();
        byte[] bytes = new byte[1024];
        socket.getInputStream().read(bytes);
        System.out.println(new String(bytes));
    }
}
