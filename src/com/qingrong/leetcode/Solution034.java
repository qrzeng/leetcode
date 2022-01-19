package com.qingrong.leetcode;

public class Solution034 {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = findLeftRound(nums, target);
        int right = findRightRound(nums, target);
        return new int[]{left, right};
    }

    private int findLeftRound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return (left < 0 || left >= nums.length || nums[left] != target) ? -1 : left;
    }

    private int findRightRound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return (right < 0 || right >= nums.length || nums[right] != target) ? -1 : right;
    }
}
