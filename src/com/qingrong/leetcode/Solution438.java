package com.qingrong.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> windowMap = new HashMap<>();
        Map<Character, Integer> needMap = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            needMap.put(c, needMap.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        while (right < s.length()) {
            char item = s.charAt(right);
            right += 1;
            if (needMap.containsKey(item)) {
                windowMap.put(item, windowMap.getOrDefault(item, 0) + 1);
                if (needMap.get(item) >= windowMap.get(item)) {
                    valid++;
                }
            }
            while (right - left >= p.length()) {
                if (valid == p.length()) {
                    result.add(left);
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
        return result;
    }

    public static void main(String[] args) {
        String s = "abab";
        String t = "ab";
        System.out.println(new Solution438().findAnagrams(s,t));
    }
}
