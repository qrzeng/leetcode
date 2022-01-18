package com.qingrong.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution003 {
    public int lengthOfLongestSubstring(String s) {
        int result = Integer.MIN_VALUE;
        Set<Character> charSet = new HashSet<>();
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char item = s.charAt(right);
            right += 1;
            if (!charSet.contains(item)) {
                charSet.add(item);
            } else {
                while (charSet.contains(item)) {
                    int len = right - left - 1;
                    if (len > result) {
                        result = len;
                    }
                    char temp = s.charAt(left);
                    charSet.remove(temp);
                    left++;
                }
                charSet.add(item);
            }
        }
        return Math.max(result, right - left);
    }

    public static void main(String[] args) {
        System.out.println(new Solution003().lengthOfLongestSubstring("aaaa"));
    }
}
