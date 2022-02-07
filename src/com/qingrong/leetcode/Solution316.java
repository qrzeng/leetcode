package com.qingrong.leetcode;

import java.util.Stack;

public class Solution316 {
    public String removeDuplicateLetters(String s) {
        Stack<Character> characterStack = new Stack<>();
        boolean[] inStack = new boolean[256];
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c]--;
            if (inStack[c]) {
                continue;
            }
            while (!characterStack.isEmpty() && count[characterStack.peek()] > 0 && characterStack.peek() >= c) {
                char top = characterStack.pop();
                inStack[top] = false;
            }
            characterStack.add(c);
            inStack[c] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!characterStack.isEmpty()) {
            sb.append(characterStack.pop());
        }
        return sb.reverse().toString();
    }
}
