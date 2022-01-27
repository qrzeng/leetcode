package com.qingrong.leetcode;

import java.util.Stack;

public class Solution1541 {
    public int minInsertions(String s) {
        int count = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    char top = stack.peek();
                    if (top == '(') {
                        stack.push(c);
                    } else {
                        count++;
                        stack.pop();
                        stack.pop();
                        stack.push(c);
                    }

                }
            } else {
                if (stack.isEmpty()) {
                    count++;
                    stack.push('(');
                    stack.push(')');
                } else {
                    char top = stack.peek();
                    if (top == ')') {
                        stack.pop();
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            char top = stack.pop();
            if (top == '(') {
                count += 2;
            } else {
                if (stack.isEmpty()) {
                    count += 2;
                } else {
                    count++;
                    stack.pop();
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1541().minInsertions("(((((("));
    }
}
