package com.qingrong.leetcode;

public class Solution019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummp = new ListNode(-1, head);
        ListNode fast = dummp;
        ListNode slow = dummp;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        for (; fast != null; fast = fast.next) {
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummp.next;
    }

}
