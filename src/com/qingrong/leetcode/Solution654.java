package com.qingrong.leetcode;

public class Solution654 {
//    public TreeNode constructMaximumBinaryTree(int[] nums) {
//        if (nums.length == 0) {
//            return null;
//        }
//        int maxIndex = -1;
//        for (int i = 0; i < nums.length; i++) {
//            if (maxIndex == -1 || nums[maxIndex] < nums[i]) {
//                maxIndex = i;
//            }
//        }
//        int[] left = new int[maxIndex];
//        int[] right = new int[nums.length - maxIndex - 1];
//        int index = 0;
//        for (; index < maxIndex; index++) {
//            left[index] = nums[index];
//        }
//        index++;
//        for (; index < nums.length; index++) {
//            right[index - maxIndex - 1] = nums[index];
//        }
//
//        TreeNode root = new TreeNode(nums[maxIndex]);
//        root.left = constructMaximumBinaryTree(left);
//        root.right = constructMaximumBinaryTree(right);
//        return root;
//    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildBinaryTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildBinaryTree(int[] nums, int left, int right) {
        if (left >= right) {
            return null;
        }
        int maxIndex = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = buildBinaryTree(nums, left, maxIndex - 1);
        root.right = buildBinaryTree(nums, maxIndex + 1, right);
        return root;
    }
}
