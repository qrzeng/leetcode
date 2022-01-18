package com.qingrong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution076 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> windowMap = new HashMap<>();
        Map<Character, Integer> needMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            needMap.put(c, needMap.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        while (right < s.length()) {
            char item = s.charAt(right);
            right += 1;
            if (needMap.containsKey(item)) {
                windowMap.put(item, windowMap.getOrDefault(item, 0) + 1);
                if (needMap.get(item) >= windowMap.get(item)) {
                    valid++;
                }
            }
            while (valid == t.length()) {
                int len = right - left;
                if (len < min) {
                    end = right;
                    start = left;
                    min = len;
                }
                item = s.charAt(left);
                left++;
                if (needMap.containsKey(item)) {
                    windowMap.put(item, windowMap.get(item) - 1);
                    if (needMap.get(item) > (windowMap.get(item))) {
                        valid--;
                    }
                }
            }
        }
        if (min == Integer.MAX_VALUE) {
            return "";
        } else {
            return s.substring(start, end);
        }
    }

    public static void main(String[] args) {
        String s = "aa";
        String t = "aa";
        System.out.println(new Solution076().minWindow(s, t));
    }
}
