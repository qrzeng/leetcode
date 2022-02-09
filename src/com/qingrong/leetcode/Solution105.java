package com.qingrong.leetcode;

public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int pLeft, int pRight, int[] inorder, int iLeft, int iRight) {
        if (pLeft > pRight || iLeft > iRight) {
            return null;
        }
        int rootValue = preorder[pLeft];
        int iRootIndex = -1;
        for (int i = iLeft; i <= iRight; i++) {
            if (rootValue == inorder[i]) {
                iRootIndex = i;
                break;
            }
        }
        int leftLength = iRootIndex - iLeft;
        TreeNode root = new TreeNode(rootValue);
        root.left = build(preorder, pLeft + 1, pLeft + leftLength, inorder, iLeft, iRootIndex - 1);
        root.right = build(preorder, pLeft + leftLength + 1, pRight, inorder, iRootIndex + 1, iRight);
        return root;
    }

    public static void main(String[] args) {
        new Solution105().buildTree(new int[]{1, 2, 3}, new int[]{3, 2, 1});
    }
}
