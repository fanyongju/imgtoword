package com.fyj.interview;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Arrays;

/**
 * @author fanyongju
 * @Title: Merge
 * @date 2019/11/27 12:00
 */
public class Merge {
    //给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        // two get pointers for nums1 and nums2
        int p1 = m - 1;
        int p2 = n - 1;
        // set pointer for nums1
        int p = m + n - 1;

        // while there are still elements to compare
        while ((p1 >= 0) && (p2 >= 0))
            // compare two elements from nums1 and nums2
            // and add the largest one in nums1
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

        // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        return nums1;
    }

    public static void main(String[] args) {
        //nums1 = [1,2,3,0,0,0], m = 3
        //nums2 = [2,5,6],       n = 3
        System.out.println(Arrays.toString(merge(new int[]{2,5,6,0,0,0},3,new int[]{1,2,3},3)));
    }

}
