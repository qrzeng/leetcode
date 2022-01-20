package com.qingrong.leetcode;

public class Solution083 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode left = head;
        ListNode right = head.next;
        while (right != null) {
            if (left.val != right.val) {
                left.next = right;
                left = left.next;
            }
            right = right.next;
        }
        left.next = null;
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
