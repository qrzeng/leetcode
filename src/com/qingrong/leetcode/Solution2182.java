package com.qingrong.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution2182 {
    public String repeatLimitedString(String s, int repeatLimit) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            queue.add(new int[]{entry.getKey() - 'a', entry.getValue()});
        }
        StringBuilder res = new StringBuilder();
        int repeatCount = 1;
        Character pre = null;
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            if (pre == null) {
                res.append((char) ('a' + temp[0]));
                repeatCount = 1;
                pre = (char) ('a' + temp[0]);
                if (temp[1] > 1) {
                    queue.add(new int[]{temp[0], temp[1] - 1});
                }
            } else {
                if (temp[0] + 'a' == pre) {
                    if (repeatLimit == repeatCount) {
                        if (queue.isEmpty()) {
                            break;
                        }
                        int[] temp1 = queue.poll();
                        res.append((char) ('a' + temp1[0]));
                        repeatCount = 1;
                        pre = (char) ('a' + temp1[0]);
                        queue.add(new int[]{temp[0], temp[1]});
                        if (temp1[1] > 1) {
                            queue.add(new int[]{temp1[0], temp1[1] - 1});
                        }
                    } else {
                        res.append((char) ('a' + temp[0]));
                        pre = (char) ('a' + temp[0]);
                        repeatCount++;
                        if (temp[1] > 1) {
                            queue.add(new int[]{temp[0], temp[1] - 1});
                        }
                    }
                } else {
                    res.append((char) ('a' + temp[0]));
                    repeatCount = 1;
                    pre = (char) ('a' + temp[0]);
                    if (temp[1] > 1) {
                        queue.add(new int[]{temp[0], temp[1] - 1});
                    }
                }
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution2182().repeatLimitedString("ggggggggggggggggcccccccccccccccccc", 1));
    }
}
