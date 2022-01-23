package com.qingrong.leetcode;

public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tailA = headA;
        while (tailA.next != null) {
            tailA = tailA.next;
        }
        tailA.next = headB;
        ListNode fast = headA;
        ListNode slow = headA;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            tailA.next = null;
            return null;
        }
        slow = headA;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        tailA.next = null;
        return slow;
    }
}
