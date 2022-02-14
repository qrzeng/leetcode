package com.qingrong.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution255 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pList = traserve(root, p);
        List<TreeNode> qList = traserve(root, q);
        int pCur = pList.size() - 1;
        int qCur = qList.size() - 1;
        while (pCur >= 0 && qCur >= 0) {
            if (pList.get(pCur) != qList.get(qCur)) {
                return pList.get(pCur + 1);
            } else {
                pCur--;
                qCur--;
            }
        }
        return pCur<0?pList.get(0):qList.get(0);
    }

    private List<TreeNode> traserve(TreeNode root, TreeNode target) {
        List<TreeNode> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        if (root.val < target.val) {
            res.addAll(traserve(root.right, target));
        } else if (root.val > target.val) {
            res.addAll(traserve(root.left, target));
        }
        res.add(root);
        return res;
    }

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static String treeNodeToString(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        String output = "";
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (node == null) {
                output += "null, ";
                continue;
            }

            output += String.valueOf(node.val) + ", ";
            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
        }
        return "[" + output.substring(0, output.length() - 2) + "]";
    }

    private static TreeNode find(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        if (root.val == target) {
            return root;
        } else if (root.val < target) {
            return find(root.right, target);
        } else {
            return find(root.left, target);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);
            line = in.readLine();
            int p = Integer.parseInt(line);
            line = in.readLine();
            int q = Integer.parseInt(line);
            TreeNode pNode = find(root,p);
            TreeNode qNode = find(root, q);

            TreeNode ret = new Solution255().lowestCommonAncestor(root, pNode, qNode);

            String out = treeNodeToString(ret);

            System.out.print(out);
        }
    }
}
