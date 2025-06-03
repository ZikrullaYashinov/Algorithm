package leetcode.p1298;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    static int NULL = 0;
    static int HAS_KEY = 1;
    static int HAS_BOX = 2;
    static int HAS_BOTH = 3;

    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i : initialBoxes) {
            if (status[i] == HAS_KEY) {
                queue.add(i);
            } else {
                status[i] = HAS_BOX;
            }
        }

        int sumCaries = 0;

        while (!queue.isEmpty()) {
            Integer i = queue.poll();

            int[] containedBox = containedBoxes[i];
            int[] keyList = keys[i];

            sumCaries += candies[i];

            for (int box : containedBox) {
                if (status[box] == HAS_KEY) {
                    status[box] = HAS_BOTH;
                    queue.add(box);
                } else if (status[box] == NULL) {
                    status[box] = HAS_BOX;
                }
            }

            for (int key : keyList) {
                if (status[key] == HAS_BOX) {
                    status[key] = HAS_BOTH;
                    queue.add(key);
                } else if (status[key] == NULL) {
                    status[key] = HAS_KEY;
                }
            }
        }

        return sumCaries;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxCandies(
                new int[]{1, 0, 1, 0},
                new int[]{7, 5, 4, 100},
                new int[][]{new int[]{}, new int[]{}, new int[]{1}, new int[]{}},
                new int[][]{new int[]{1, 2}, new int[]{3}, new int[]{1}, new int[]{}},
                new int[]{0}
        ));
    }
}