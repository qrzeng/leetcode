package com.qingrong.leetcode;

public class Solution876 {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            if (fast.next == null) {
                return slow;
            } else if (fast.next.next == null) {
                return slow.next;
            } else {
                fast = fast.next.next;
                slow = slow.next;
            }
        }
    }
}
