package com.fyj.practice.copy;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

/**
 * @author fanyongju
 * @Title: CopyUtil
 * @date 2018/12/27 17:33
 */
public class CopyUtil {
    public static void main(String[] args) {
        setSysClipboardText("复制的内容\n第二行");
    }
    /**
     * 将字符串复制到剪切板。
     */
    public static void setSysClipboardText(String writeMe) {
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable tText = new StringSelection(writeMe);
        clip.setContents(tText, null);
    }
}
