package com.fyj.interview;

/**
 * @author fanyongju
 * @Title: MaxDrawdown
 * @date 2019/11/27 11:34
 */
public class MaxDrawdown {
    /*有一个数组，求其中两个数x,y，满足x的索引小于y的索引，使得 x-y 最大。
    arr = [3,7,9,6,4,1,2,8,5]， 最大回撤是6，对应的x=7,y=1*/
    public static void maxDrawdown(int[] arr) {
        int x = arr[0];
        int y = arr[1];
        int maxValue = x;
        int maxDiff = x - y;
        for (int i = 2; i < arr.length; i++) {
            if (arr[i - 1] > maxValue) {
                maxValue = arr[i - 1];
            }
            if (maxValue - arr[i] > maxDiff) {
                maxDiff = maxValue - arr[i];
                x = maxValue;
                y = arr[i];
            }
        }
        System.out.println("x=" + x + ", y=" + y);
    }

    public static void main(String[] args) {
        maxDrawdown(new int[]{3,7,9,6,4,1,2,8,5});
    }
}
