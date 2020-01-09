package com.fyj.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author fanyongju
 * @Title: LRUCache
 * @date 2019/12/2 19:01
 */
public class LRUCache {
    Map<Integer, Integer> map;
    Stack<Integer> stack;
    int size;

    public LRUCache(int capacity) {
        stack = new Stack<>();
        map = new HashMap<>(capacity);
        size = capacity;
    }

    public int get(int key) {
        if (!stack.contains(key)) {
            return -1;
        }
        boolean flag = stack.remove(Integer.valueOf(key));
        stack.push(key);
        return map.get(key);
    }

    public void put(int key, int value) {
        if (stack.contains(key)) {
            stack.remove(Integer.valueOf(key));
        } else {
            if (stack.size() == size) {
                int count = stack.remove(0);
                map.remove(count);
            }
        }
        stack.push(key);
        map.put(key, value);
    }

    public static void main(String[] args) {

    }
}
