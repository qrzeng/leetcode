package com.qingrong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution138 {
    public Node copyRandomList(Node head) {
        Map<Node, Node> nodeMap = new HashMap<>();
        Node cur = head;
        Node newResult = new Node(-1);
        Node newCur = newResult;
        while (cur != null) {
            Node temp = new Node(cur.val);
            newCur.next = temp;
            nodeMap.put(cur, temp);
            cur = cur.next;
            newCur = newCur.next;
        }
        cur = head;
        newCur = newResult.next;
        while (cur != null) {
            newCur.random = cur.random == null ? null : nodeMap.get(cur.random);
            cur = cur.next;
            newCur = newCur.next;
        }
        return newResult.next;
    }
}
