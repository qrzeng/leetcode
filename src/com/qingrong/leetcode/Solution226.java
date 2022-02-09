package com.qingrong.leetcode;

public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = invertTree(left);
        root.left = invertTree(right);
        return root;

    }
}
