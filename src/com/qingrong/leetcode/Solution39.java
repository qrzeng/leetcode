package com.qingrong.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Solution39 {
    private List<List<Integer>> res = new ArrayList<>();
    private Set<List<Integer>> set = new HashSet<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        traverse(candidates, target, new LinkedList<>());
        return res;
    }

    private void traverse(int[] candidates, int target, LinkedList<Integer> path) {
        List<Integer> sortedPath = path.stream().sorted().collect(Collectors.toList());
        if (target == 0 && !set.contains(sortedPath)) {
            res.add(new ArrayList<>(path));
            set.add(sortedPath);
            return;
        }
        for (int candidate : candidates) {
            if (target - candidate < 0) {
                continue;
            }
            path.addLast(candidate);
            traverse(candidates, target - candidate, path);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution39().combinationSum(new int[]{2,7,6,3,5,1}, 9));
    }
}
