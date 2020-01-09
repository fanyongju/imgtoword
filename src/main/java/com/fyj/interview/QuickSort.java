package com.fyj.interview;

import java.util.Arrays;

/**
 * @author fanyongju
 * @Title: QuickSort
 * @date 2019/11/26 11:11
 */
public class QuickSort {
    //快速排序
    public static void quickSort(int[] arr, int head, int tail) {
        if (head >= tail || arr == null || arr.length <= 1) {
            return;
        }
        int left = head;
        int right = tail;
        int mid = arr[(head + tail) / 2];
        while (left <= right) {
            while (arr[left] < mid) {
                left++;
            }
            while (arr[right] > mid) {
                right--;
            }
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            } else if (left == right) {
                left++;
            }
        }
        quickSort(arr, head, right);
        quickSort(arr, left, tail);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6, 1, 2, 7, 9, 3, 4, 5, 10, 8, 56};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
