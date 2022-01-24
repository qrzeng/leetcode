package com.qingrong.leetcode;

public class Solution024 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            ListNode temp = head.next;
            head.next.next = head;
            head.next = null;
            return temp;
        }
        ListNode last = swapPairs(head.next.next);
        ListNode temp = head.next;
        head.next = last;
        temp.next = head;
        return temp;
    }

    public ListNode swapPairsFor(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        ListNode c = head.next;
        ListNode d = null;
        while (p != null && c != null) {
            if (d == null) {
                head = c;
            } else {
                d.next = c;
            }
            ListNode temp = c.next;
            c.next = p;
            p.next = temp;
            d = p;
            p = temp;
            c = temp == null ? null : temp.next;
        }
        return head;
    }
}
