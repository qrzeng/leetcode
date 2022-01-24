package com.qingrong.leetcode;

public class ReverseLink {
    private ListNode successor = null;

    public ListNode reverseN(ListNode head, int n) {
        if (n == 0) {
            return null;
        } else if (n == 1) {
            this.successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = this.successor;
        return last;
    }

    public static void main(String[] args) {
        ReverseLink reverseLink = new ReverseLink();
        reverseLink.reverseN(null, 0);
    }

}
