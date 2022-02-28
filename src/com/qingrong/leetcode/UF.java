package com.qingrong.leetcode;

public class UF {

    private int count;

    private int[] parent;

    private int[] size;

    public UF(int n) {
        this.count = n;
        this.parent = new int[n];
        this.size = new int[n];
        for (int i = 0; i < n; i++) {
            this.parent[i] = i;
            this.size[i] = 1;
        }
    }

    public void union(int p, int q) {
        int pParent = find(p);
        int qParent = find(q);
        if (pParent == qParent) {
            return;
        }
        if (this.size[this.parent[pParent]] > this.size[this.parent[qParent]]) {
            this.parent[qParent] = pParent;
            this.size[this.parent[pParent]] += this.size[this.parent[qParent]];
        } else {
            this.parent[pParent] = qParent;
            this.size[this.parent[qParent]] += this.size[this.parent[pParent]];
        }
        this.count--;
    }

    public boolean connected(int p, int q) {
        int pParent = find(p);
        int qParent = find(q);
        return pParent == qParent;
    }

    private int find(int x) {
        while (x != this.parent[x]) {
            this.parent[x] = this.parent[this.parent[x]];
            x = this.parent[x];
        }
        return x;
    }

    public int count() {
        return this.count;
    }
}
