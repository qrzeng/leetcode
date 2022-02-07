package com.qingrong.leetcode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        MaxQueue queue = new MaxQueue();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                queue.push(nums[i]);
            } else {
                queue.push(nums[i]);
                res[index++] = queue.max();
                queue.pop(nums[i - k + 1]);

            }
        }
        return res;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        PriorityQueue<int[]> maxQueue = new PriorityQueue<>((o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o2[0] - o1[0]);
        for (int i = 0; i < k; i++) {
            maxQueue.add(new int[]{nums[i], i});
        }
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        res[index++] = maxQueue.peek()[0];
        for (int i = k; i < nums.length; i++) {
            maxQueue.add(new int[]{nums[i], i});
            while (maxQueue.peek()[1] <= i - k) {
                maxQueue.poll();
            }
            res[index++] = maxQueue.peek()[0];
        }
        return res;
    }


    class MaxQueue {
        private LinkedList<Integer> queue = new LinkedList<>();

        public void push(int value) {
            while (!queue.isEmpty() && queue.getLast() <= value) {
                queue.pollLast();
            }
            queue.push(value);
        }

        public int max() {
            return queue.getFirst();
        }

        public void pop(int value) {
            if (value == queue.getFirst()) {
                queue.pollFirst();
            }
        }
    }
}
