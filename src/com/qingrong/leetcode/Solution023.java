package com.qingrong.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution023 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode item : lists) {
            if (item != null) {
                queue.add(item);
            }
        }
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            if (cur.next.next != null) {
                queue.add(cur.next.next);
            }
            cur = cur.next;
        }
        return head.next;
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
