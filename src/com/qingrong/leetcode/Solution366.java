package com.qingrong.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution366 {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> findLeaves(TreeNode root) {
        maxDepath(root);
        return res;
    }

    private int maxDepath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepath(root.left);
        int right = maxDepath(root.right);
        int height = 1 + Math.max(left, right);
        List<Integer> temp;
        if (res.size() < height) {
            temp = res.get(height - 1);
        } else {
            temp = new ArrayList<>();
            res.set(height, temp);
        }
        temp.add(root.val);
        return height;
    }
}
