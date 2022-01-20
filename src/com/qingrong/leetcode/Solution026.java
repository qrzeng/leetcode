package com.qingrong.leetcode;

public class Solution026 {
    public int removeDuplicates(int[] nums) {
        int left = 0;
        int right = 1;
        if (nums.length <= 1) {
            return nums.length;
        }
        for (; right < nums.length; right++) {
            if (nums[left] != nums[right]) {
                left++;
                nums[left] = nums[right];
            }
        }
        return left + 1;
    }
}
