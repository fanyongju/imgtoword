package com.fyj.interview;

import java.util.HashSet;
import java.util.Set;

/**
 * @author fanyongju
 * @Title: Solution217
 * @date 2020/1/9 16:23
 */
public class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if(set.contains(nums[i])){
                return true;
            }else{

            }
        }
        return false;
    }
}
