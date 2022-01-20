package com.qingrong.leetcode;

public class Solution027 {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = 0;
        for (; right < nums.length; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }
}
