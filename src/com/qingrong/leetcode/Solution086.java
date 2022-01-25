package com.qingrong.leetcode;

public class Solution086 {
    public ListNode partition(ListNode head, int x) {
        ListNode l1 = new ListNode(-1, null);
        ListNode l1Head = l1;
        ListNode l2 = new ListNode(-1, null);
        ListNode l2Head = l2;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            if (cur.val < x) {
                l1.next = cur;
                l1 = l1.next;
            } else {
                l2.next = cur;
                l2 = l2.next;
            }
            cur = temp;
        }
        l1.next = l2Head.next;
        l2.next = null;
        return l1Head.next;
    }
}
