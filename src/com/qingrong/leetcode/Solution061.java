package com.qingrong.leetcode;

public class Solution061 {
    public ListNode rotateRight(ListNode head, int k) {
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        if (length == 0 || length == 1) {
            return head;
        }
        int r = k % length;
        if (r == 0) {
            return head;
        }
        int originLen = length - r;
        cur = head;
        for (int i = 1; i < originLen; i++) {
            cur = cur.next;
        }
        ListNode newHead = cur.next;
        cur.next = null;
        cur = newHead;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        Solution061 solution061 = new Solution061();
        System.out.println(solution061.rotateRight(Solution061.buildLink(), 2).val);
    }

    private static ListNode buildLink() {
        ListNode l5 = new ListNode(5, null);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        return new ListNode(1, l2);
    }
}
