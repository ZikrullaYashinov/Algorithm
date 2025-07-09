package leetcode.p1353;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int maxEvents(int[][] events) {
        int max = 0;
        for (int[] event : events) {
            max = Math.max(event[1], max);
        }

        int[] arr = new int[max + 2];
        for (int i = 1; i <= max + 1; i++) {
            arr[i] = i;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int i1 = find(arr, o1[0]);
                int i2 = find(arr, o2[0]);
                if (i1 == i2) return o1[1] - o2[1];
                return i1 - i2;
            }
        });

        pq.addAll(Arrays.asList(events));

        int str = 0;
        int count = 0;
        while (!pq.isEmpty()) {
            int[] next = pq.poll();
            int start = next[0];
            int end = next[1];
            int lastStr = str;
            if (start > str) {
                count++;
                str = start;
            } else if (end > str) {
                count++;
                str++;
            }
            for (int i = lastStr; i <= str; i++) {
                set(arr, i, str + 1);
            }
        }

        return count;
    }

    private int find(int[] arr, int value) {
        if (arr[value] == value) return value;
        return find(arr, arr[value]);
    }

    private void set(int[] arr, int value, int newValue) {
        if (arr[value] == value) {
            arr[value] = newValue;
            return;
        }
        set(arr, arr[value], newValue);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxEvents(new int[][]{{1, 4}, {4, 4}, {2, 2}, {3, 4}, {1, 1}}));
        System.out.println(solution.maxEvents(new int[][]{{1, 2}, {1, 2}, {3, 3}, {1, 5}, {1, 5}}));
        System.out.println(solution.maxEvents(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 2}}));
    }
}