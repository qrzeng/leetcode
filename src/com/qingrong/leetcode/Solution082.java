package com.qingrong.leetcode;

public class Solution082 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummp = new ListNode(-101, head);
        ListNode p0 = dummp;
        ListNode p1 = dummp.next;
        ListNode p2 = dummp.next.next;
        while (p2 != null) {
            int v1 = p1.val;
            int v2 = p2.val;
            if (v1 == v2) {
                p2 = p2.next;
            } else {
                if (p1.next == p2) {
                    p0 = p1;
                    p1 = p2;
                    p2 = p2.next;
                } else {
                    p0.next = p2;
                    p1 = p2;
                    p2 = p2.next;
                }
            }
        }
        if (p1.next != null) {
            p0.next = null;
        }
        return dummp.next;
    }
}
