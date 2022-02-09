package com.qingrong.leetcode;

public class Solution116 {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        connectInner(root.left, root.right);
        return root;
    }

    private void connectInner(Node left, Node right) {
        if (left == null) {
            return;
        }
        left.next = right;
        connectInner(left.left, left.right);
        connectInner(left.right, right.left);
        connectInner(right.left, right.right);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
