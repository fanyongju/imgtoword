package com.fyj.practice.test;

import java.util.BitSet;

/**
 * @author fanyongju
 * @Title: BitSetDemo
 * @date 2019/2/13 16:53
 */
public class BitSetDemo {
    public static void main(String[] args) {

        // create 2 bitsets
        BitSet bitset1 = new BitSet(8);
        BitSet bitset2 = new BitSet(8);

        // assign values to bitset1
        bitset1.set(0);
        bitset1.set(1);
        bitset1.set(2);
        bitset1.set(3);
        bitset1.set(4);
        bitset1.set(5);

        // assign values to bitset2
        bitset2.set(2);
        bitset2.set(4);
        bitset2.set(6);
        bitset2.set(8);
        bitset2.set(10);

        // print the sets
        System.out.println("Bitset1:" + bitset1);
        System.out.println("Bitset2:" + bitset2);

        // print the first set bit of bitset1
        System.out.println("" + bitset1.nextSetBit(0));

        // print the first set bit of bitset2 after index 5
        System.out.println("" + bitset2.nextSetBit(0));
    }
}
