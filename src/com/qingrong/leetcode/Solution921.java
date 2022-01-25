package com.qingrong.leetcode;

import java.util.Stack;

public class Solution921 {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    count++;
                } else {
                    stack.pop();
                }
            }
        }
        return count + stack.size();
    }

    public static void main(String[] args) {
        String s = "()))((";
        System.out.println(new Solution921().minAddToMakeValid(s));
    }
}
