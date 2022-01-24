package com.qingrong.leetcode;

public class Solution096 {
    private ListNode successor;

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return this.reverseN(head, right);
        }
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    private ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            this.successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = this.successor;
        return last;
    }

    private ListNode reverseFor(ListNode head, int left, int right) {
        ListNode outHead = null;
        ListNode outTail = null;
        ListNode innerHead = null;
        ListNode innerTail = null;
        ListNode cur = head;
        ListNode pre = null;
        int i = 1;
        for (; i < left; i++) {
            pre = cur;
            cur = cur.next;
        }
        outHead = pre;
        innerTail = cur;
        for (; i <= right; i++) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        outTail = cur;
        innerHead = pre;
        if (outHead == null) {
            head = innerHead;
        } else {
            outHead.next = innerHead;
        }
        innerTail.next = outTail;
        return head;
    }
}
