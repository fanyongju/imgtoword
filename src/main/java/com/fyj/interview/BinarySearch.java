package com.fyj.interview;

/**
 * @author fanyongju
 * @Title: BinarySearch
 * @date 2019/11/26 14:08
 */
public class BinarySearch {
    //二分查找
    public static int binarySearchByWhile(int[] arr, int start, int end, int target) {
        while (start < end) {
            int midIndex = start + (end - start) / 2;
            if (arr[midIndex] < target) {
                start = midIndex + 1;
            } else if (arr[midIndex] > target) {
                end = midIndex - 1;
            } else {
                return midIndex;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        int midIndex = start + (end - start) / 2;
        if (arr[midIndex] < target) {
            return binarySearch(arr, midIndex + 1, end, target);
        } else if (arr[midIndex] > target) {
            return binarySearch(arr, start, midIndex - 1, target);
        }
        return midIndex;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 6, 8, 9};
        System.out.println(binarySearchByWhile(arr, 0, arr.length - 1, 6));
        System.out.println(binarySearch(arr, 0, arr.length - 1, 6));
    }
}
