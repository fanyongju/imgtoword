package com.fyj.interview;

import javax.validation.constraints.Max;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author fanyongju
 * @Title: MaxSubArray
 * @date 2019/11/27 15:14
 */
public class MaxSubArray {
    //输入: [-2,1,-3,4,-1,2,1,-5,4],
    //输出: 6
    //解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
    public static int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(sum, ans);
        }
        return ans;
    }

    //输入: "abcabcbb"
    //输出: 3
    //解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static String valueOfLongestSubstring(String s) {
        String result = null;
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            if (ans < (j - i + 1)) {
                ans = j - i + 1;
                result = s.substring(i, j + 1);
            }
            map.put(s.charAt(j), j + 1);
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(maxSubArray(new int[]{4, -1, -2, 1}));
        System.out.println(lengthOfLongestSubstring("pwwkew"));//3
        System.out.println(lengthOfLongestSubstring("bbbbb"));//1
        System.out.println(lengthOfLongestSubstring("aab"));//2
        System.out.println(lengthOfLongestSubstring(" "));//1
        System.out.println(lengthOfLongestSubstring("a"));//1

        System.out.println(valueOfLongestSubstring("pwwkew"));//3
        System.out.println(valueOfLongestSubstring("bbbbb"));//1
        System.out.println(valueOfLongestSubstring("aab"));//2
        System.out.println(valueOfLongestSubstring(" "));//1
        System.out.println(valueOfLongestSubstring("a"));//1
    }
}
