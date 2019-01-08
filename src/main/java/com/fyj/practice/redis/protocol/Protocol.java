package com.fyj.practice.redis.protocol;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 * @author fanyongju
 * @Title: Protocol 协议层
 * @date 2019/1/7 19:14
 */
public class Protocol {
    public static final String DOLLAR_BYTE = "$";
    public static final String ASTERISK_BYTE = "*";
    public static final String BLANK_STRING = "\r\n";

    public static void sendCommand(OutputStream outputStream, Command command, byte[]... args) {
        StringBuffer sb = new StringBuffer();
        sb.append(ASTERISK_BYTE).append(args.length + 1).append(BLANK_STRING);
        sb.append(DOLLAR_BYTE).append(command.name().length()).append(BLANK_STRING);
        sb.append(command.name()).append(BLANK_STRING);
        for (byte[] arg : args) {
            sb.append(DOLLAR_BYTE).append(arg.length).append(BLANK_STRING);
            sb.append(new String(arg)).append(BLANK_STRING);
        }
        try {
            outputStream.write(sb.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static enum Command {
        SET, GET
    }
}
