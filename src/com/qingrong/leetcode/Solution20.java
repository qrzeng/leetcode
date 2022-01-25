package com.qingrong.leetcode;

import java.util.Stack;

public class Solution20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (c == ']' && top != '[') {
                    return false;
                } else if (c == ')' && top != '(') {
                    return false;
                } else if (c == '}' && top != '{') {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
