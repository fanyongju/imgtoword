package com.fyj.interview;

/**
 * @author fanyongju
 * @Title: ClimbStairs
 * @date 2019/11/26 16:41
 */
public class ClimbStairs {
    //有一个楼梯，总共有10级台阶，每次只能走一级或者两级台阶，全部走完，有多少种走法？
    public static int climbStairs(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static int climbStairsLess(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return n;
        }
        int[] result = new int[n];
        result[0] = 1;
        result[1] = 2;
        for (int i = 2; i < n; i++) {
            result[i] = result[i-1] + result[i-2];
        }
        return result[n-1];
    }

    public static void main(String[] args) {
        System.out.println(climbStairsLess(3));
    }
}
