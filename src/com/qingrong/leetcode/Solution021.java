package com.qingrong.leetcode;

public class Solution021 {
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 != null) {
            cur.next = list1;
        }
        if (list2 != null) {
            cur.next = list2;
        }
        return head.next;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null;
        ListNode cur = null;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                if (cur == null) {
                    head = list1;
                    cur = list1;
                } else {
                    cur.next = list1;
                    cur = cur.next;
                }
                list1 = list1.next;
            } else {
                if (cur == null) {
                    head = list2;
                    cur = list2;
                } else {
                    cur.next = list2;
                    cur = cur.next;
                }
                list2 = list2.next;
            }
        }
        while (list1 != null) {
            if (cur == null) {
                head = list1;
                cur = list1;
            } else {
                cur.next = list1;
                cur = cur.next;
            }
            list1 = list1.next;
        }
        while (list2 != null) {
            if (cur == null) {
                head = list2;
                cur = list2;
            } else {
                cur.next = list2;
                cur = cur.next;
            }
            list2 = list2.next;
        }
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



