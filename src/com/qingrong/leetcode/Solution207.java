package com.qingrong.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution207 {
    private boolean[] visited;

    private boolean[] onPath;

    private boolean hasCycle = false;

    private List<List<Integer>> path = new ArrayList<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = buildGraph(numCourses, prerequisites);
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i, new LinkedList<>());
        }
        for (List<Integer> integers : path) {
            for (Integer integer : integers) {
                System.out.print(integer+"\t");
            }
            System.out.println();
        }
        return !hasCycle;
    }

    private List<List<Integer>> buildGraph(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[0];
            int to = prerequisite[1];
            graph.get(from).add(to);
        }
        return graph;
    }

    private void traverse(List<List<Integer>> graph, int s, LinkedList<Integer> path) {
        if (onPath[s]) {
            hasCycle = true;
        }
        if (visited[s]||hasCycle) {
            return;
        }
        path.add(s);
        visited[s] = true;
        onPath[s] = true;
        List<Integer> nears = graph.get(s);
        for (int near : nears) {
            traverse(graph, near, path);
        }
        this.path.add(new ArrayList<>(path));
        path.removeLast();
        onPath[s] = false;
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{{1,0},{0,1}};
        new Solution207().canFinish(2,graph);
    }
}
