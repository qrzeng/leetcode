package com.qingrong.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution652 {
    private Map<String, Integer> map = new HashMap<>();
    private List<TreeNode> res = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        inverse(root);
        return res;
    }

    private String inverse(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String left = inverse(root.left);
        String right = inverse(root.right);
        String str = root.val + "," + left + "," + right;
        int count = map.getOrDefault(str, 0);
        map.put(str, count + 1);
        if (count == 1) {
            res.add(root);
        }
        return str;
    }
}
