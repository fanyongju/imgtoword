package com.fyj.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fanyongju
 * @Title: TwoSum
 * @date 2019/11/27 11:12
 */
public class TwoSum {
    //寻找列表中满足两数之和等于目标值的元素的下标。
    //例如：arr = [2,7,4,9]，target = 6  则返回 [0,2]，若不存在，返回空列表[]。
    public static int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(target - arr[i])) {
                return new int[]{map.get(target - arr[i]), i};
            } else {
                map.put(arr[i], i);
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
