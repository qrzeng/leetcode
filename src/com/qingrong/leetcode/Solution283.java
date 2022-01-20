package com.qingrong.leetcode;

public class Solution283 {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        for (; right < nums.length; right++) {
            if (nums[right] != 0) {
                nums[left] = nums[right];
                left++;
            }
        }
        for (; left < nums.length; left++) {
            nums[left] = 0;
        }
    }
}
