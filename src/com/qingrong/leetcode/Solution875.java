package com.qingrong.leetcode;

public class Solution875 {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        int left = 1;
        int right = max;
        int result = Integer.MAX_VALUE;
        while (left <= right) {
            int temp = left + (right - left) / 2;
            int total = 0;
            for (int pile : piles) {
                int t = pile % temp == 0 ? pile / temp : pile / temp + 1;
                total += t;
                if (total > h) {
                    break;
                }
            }
            if (total > h) {
                left = temp + 1;
            } else {
                result = Math.min(result, temp);
                right = temp - 1;
            }
        }
        return result;
    }
}
