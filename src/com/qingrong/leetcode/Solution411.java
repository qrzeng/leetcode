package com.qingrong.leetcode;

public class Solution411 {
    public int splitArray(int[] nums, int m) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        int left = max;
        int right = sum;
        int result = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int index = 0;
            int parMax = 0;
            int total = 1;
            while (index < nums.length) {
                if (parMax + nums[index] <= mid) {
                    parMax += nums[index++];
                } else {
                    total++;
                    parMax = nums[index++];
                }
            }
            if (total <= m) {
                if (mid < result) {
                    result = mid;
                    right = mid - 1;
                } else {
                    break;
                }
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
}
