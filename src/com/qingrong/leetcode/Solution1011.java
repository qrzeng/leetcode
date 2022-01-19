package com.qingrong.leetcode;

public class Solution1011 {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int weight : weights) {
            sum += weight;
            max = Math.max(max, weight);
        }
        int left = max;
        int right = sum;
        int result = sum;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int index = 0;
            int total = 1;
            int parWeight = 0;
            while (index < weights.length) {
                if (parWeight + weights[index] <= mid) {
                    parWeight += weights[index++];
                } else {
                    total++;
                    parWeight = weights[index++];
                }
            }

            if (total <= days) {
                if (result < mid) {
                    left = mid + 1;
                } else {
                    result = mid;
                    right = mid - 1;
                }
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 2, 4, 1, 4};
        int days = 3;
        System.out.println(new Solution1011().shipWithinDays(nums, days));
    }
}
