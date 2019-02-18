package com.fyj.practice.test;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author fanyongju
 * @Title: BidDecimalTest
 * @date 2019/1/15 16:42
 */
public class BidDecimalTest implements Serializable {
    private static final long serialVersionUID = -916450277570089890L;

    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("42670975231878779878");
        System.out.println(a.add(new BigDecimal("9548125312923112434")).toString());
    }
}
