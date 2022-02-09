package com.qingrong.leetcode;

public class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int iLeft, int iRight, int[] postorder, int pLeft, int pRight) {
        if (iLeft > iRight || pLeft > pRight) {
            return null;
        }
        int rootValue = postorder[pRight];
        int rootIndex = -1;
        for (int i = iLeft; i <= iRight; i++) {
            if (inorder[i] == rootValue) {
                rootIndex = i;
                break;
            }
        }
        int leftLength = rootIndex - iLeft;
        TreeNode root = new TreeNode(rootValue);
        root.left = build(inorder, iLeft, rootIndex - 1, postorder, pLeft, pLeft + leftLength - 1);
        root.right = build(inorder, rootIndex + 1, iRight, postorder, pLeft + leftLength, pRight - 1);
        return root;
    }
}
