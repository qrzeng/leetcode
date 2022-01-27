package com.qingrong.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            int biggerValue = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums2[i]);
            map.put(nums2[i], biggerValue);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }
        return result;

    }
}
