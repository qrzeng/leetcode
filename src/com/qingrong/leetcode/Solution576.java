package com.qingrong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution576 {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> windowMap = new HashMap<>();
        Map<Character, Integer> needMap = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            needMap.put(c, needMap.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        while (right < s2.length()) {
            char item = s2.charAt(right);
            right += 1;
            if (needMap.containsKey(item)) {
                windowMap.put(item, windowMap.getOrDefault(item, 0) + 1);
                if (needMap.get(item) >= windowMap.get(item)) {
                    valid++;
                }
            }
            while (right - left >= s1.length()) {
                if (valid == s1.length()) {
                    return true;
                }
                item = s2.charAt(left);
                left++;
                if (needMap.containsKey(item)) {
                    windowMap.put(item, windowMap.get(item) - 1);
                    if (needMap.get(item) > (windowMap.get(item))) {
                        valid--;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "adc";
        String t = "dcda";
        System.out.println(new Solution576().checkInclusion(s, t));
    }
}
