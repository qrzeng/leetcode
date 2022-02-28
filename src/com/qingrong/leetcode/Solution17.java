package com.qingrong.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution17 {
    private List<char[]> numbers = new ArrayList<>();

    private List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        for (int i = 0; i <= 9; i++) {
            if (i == 0 || i == 1) {
                numbers.add(new char[0]);
            } else if (i == 2) {
                numbers.add(new char[]{'a', 'b', 'c'});
            } else if (i == 3) {
                numbers.add(new char[]{'d', 'e', 'f'});
            } else if (i == 4) {
                numbers.add(new char[]{'g', 'h', 'i'});
            } else if (i == 5) {
                numbers.add(new char[]{'j', 'k', 'l'});
            } else if (i == 6) {
                numbers.add(new char[]{'m', 'n', 'o'});
            } else if (i == 7) {
                numbers.add(new char[]{'p', 'q', 'r', 's'});
            } else if (i == 8) {
                numbers.add(new char[]{'t', 'u', 'v'});
            } else if (i == 9) {
                numbers.add(new char[]{'w', 'x', 'y', 'z'});
            }
        }
        traverse(digits, 0, new LinkedList<>());
        return res;
    }

    private void traverse(String digits, int index, LinkedList<Character> path) {
        if (index == digits.length()) {
            res.add(build(path));
            return;
        }
        int cur = digits.charAt(index)-'0';
        char[] charArray = numbers.get(cur);
        for (char temp : charArray) {
            path.addLast(temp);
            traverse(digits, index + 1, path);
            path.removeLast();
        }
    }

    private String build(LinkedList<Character> path) {
        StringBuilder sb = new StringBuilder();
        for (Character c : path) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution17().letterCombinations(""));
    }

}
