package com.qingrong.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution785 {
    private boolean isBipartiteFlag = true;

    private boolean[] visited;

    private boolean[] colors;

    public static void main(String[] args) {
        int[][] graph = new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        new Solution785().isBipartite(graph);
    }

    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        visited = new boolean[len];
        colors = new boolean[len];
        for (int i = 0; i < len; i++) {
            traverseBfs(graph, i);
        }
        return isBipartiteFlag;
    }

    private void traverseBfs(int[][] graph, int s) {
        if (visited[s] || !isBipartiteFlag) {
            return;
        }
        visited[s] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        while (!queue.isEmpty() && isBipartiteFlag) {
            int temp = queue.poll();
            int[] nears = graph[temp];
            for (int near : nears) {
                if (!visited[near]) {
                    colors[near] = !colors[temp];
                    visited[near] = true;
                    queue.offer(near);
                } else {
                    if (colors[near] == colors[temp]) {
                        isBipartiteFlag = false;
                        break;
                    }
                }
            }
        }
    }

    private void traverse(int[][] graph, int s) {
        if (visited[s] || !isBipartiteFlag) {
            return;
        }
        visited[s] = true;
        for (int near : graph[s]) {
            if (!visited[near]) {
                colors[near] = !colors[s];
                traverse(graph, near);
            } else {
                if (colors[near] == colors[s]) {
                    isBipartiteFlag = false;
                }
            }
        }
    }
}
