package com.qingrong.leetcode;

import java.util.*;

public class Solution46 {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> tracks = new LinkedList<>();
        backTrack(nums, tracks);
        return res;
    }

    private void backTrack(int[] nums, LinkedList<Integer> tracks) {
        if (nums.length == tracks.size()) {
            res.add(new ArrayList<>(tracks));
            return;
        }
        for (int num : nums) {
            if (tracks.contains(num)) {
                continue;
            }
            tracks.addLast(num);
            backTrack(nums, tracks);
            tracks.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution46().permute(new int[]{1,2,3}));
    }


}
