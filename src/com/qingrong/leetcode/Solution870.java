package com.qingrong.leetcode;

import java.util.*;

public class Solution870 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            int v1 = o1[1];
            int v2 = o2[1];
            return v2 - v1;
        });
        for (int i = 0; i < nums2.length; i++) {
            queue.add(new int[]{i, nums2[i]});
        }
        int left = 0;
        int right = nums1.length - 1;
        int[] result = new int[nums2.length];
        while (!queue.isEmpty()) {
            int[] item = queue.poll();
            int index = item[0];
            int value = item[1];
            if (nums1[right] > value) {
                result[index] = nums1[right];
                right--;
            } else {
                result[index] = nums1[left];
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{12, 24, 8, 32};
        int[] nums2 = new int[]{13, 25, 32, 11};
        System.out.println(Arrays.toString(new Solution870().advantageCount(nums1, nums2)));
    }
}
