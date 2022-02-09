package com.qingrong.leetcode;

public class Solution114 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode tempLeft = root.left;
        TreeNode tempRight = root.right;
        root.left = null;
        root.right = tempLeft;
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = tempRight;
    }


}
