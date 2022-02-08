package com.qingrong.leetcode;

import java.util.HashMap;

public class LRUCache {
    private int capacity;

    private LruLink link;

    private HashMap<Integer, LruNode> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.link = new LruLink();
        this.map = new HashMap<>();
    }

    public int get(int key) {
        LruNode node = this.map.get(key);
        if (node == null) {
            return -1;
        }
        this.link.removeNodeToTail(node);
        return node.value;
    }

    public void put(int key, int value) {
        LruNode node = this.map.get(key);
        if (node == null) {
            LruNode lruNode = new LruNode(key, value, null, null);
            if (this.link.size < this.capacity) {
                this.link.addNode(lruNode);
            } else {
                LruNode head = this.link.deleteHead();
                this.map.remove(head.key);
                this.link.addNode(lruNode);
            }
            this.map.put(key, lruNode);
        } else {
            node.value = value;
            this.link.removeNodeToTail(node);
        }

    }

    static class LruLink {
        private LruNode head;

        private LruNode tail;

        private int size;

        public LruLink() {
            this.size = 0;
            this.head = new LruNode(-1, -1, null, null);
            this.tail = new LruNode(-1, -1, null, null);
            this.head.next = this.tail;
            this.tail.prev = this.head;
        }

        public LruNode deleteHead() {
            if (this.head.next == this.tail) {
                return null;
            }
            LruNode temp = this.head.next;
            this.head.next = temp.next;
            this.head.next.prev = this.head;
            this.size--;
            return temp;
        }

        public void addNode(LruNode node) {
            node.next = this.tail;
            this.tail.prev.next = node;
            node.prev = this.tail.prev;
            this.tail.prev = node;
            this.size++;
        }

        public void removeNodeToTail(LruNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            this.size--;
            addNode(node);
        }
    }

    static class LruNode {
        private int key;

        private int value;

        private LruNode prev;

        private LruNode next;

        public LruNode(int key, int value, LruNode prev, LruNode next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
}
