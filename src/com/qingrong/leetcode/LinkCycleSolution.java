package com.qingrong.leetcode;

public class LinkCycleSolution {

    private boolean hasCycle(ListNode list) {
        ListNode fast = list;
        ListNode slow = list;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public ListNode findCycleHead(ListNode list) {
        ListNode fast = list;
        ListNode slow = list;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = list;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        LinkCycleSolution linkCycleSolution = new LinkCycleSolution();
        System.out.println(linkCycleSolution.hasCycle(linkCycleSolution.buildLink()));
        System.out.println(linkCycleSolution.hasCycle(linkCycleSolution.buildCycleLink()));
        System.out.println(linkCycleSolution.findCycleHead(linkCycleSolution.buildCycleLink()).val);

    }

    private ListNode buildLink() {
        ListNode tail = new ListNode(3, null);
        ListNode mid = new ListNode(2, tail);
        return new ListNode(1, mid);
    }

    private ListNode buildCycleLink() {
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        return new ListNode(1, node2);
    }
}
