package problems.leetcode.p3372;

import java.util.*;

class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length;
        int m = edges2.length;

        List<Integer>[] list1 = new ArrayList[n + 1];
        List<Integer>[] list2 = new ArrayList[m + 1];

        for (int i = 0; i < n + 1; i++) list1[i] = new ArrayList<>();
        for (int i = 0; i < m + 1; i++) list2[i] = new ArrayList<>();

        for (int[] edge : edges1) {
            list1[edge[0]].add(edge[1]);
            list1[edge[1]].add(edge[0]);
        }

        for (int[] edge : edges2) {
            list2[edge[0]].add(edge[1]);
            list2[edge[1]].add(edge[0]);
        }

        int maxCount = 0;
        for (int i = 0; i < m + 1; i++) {
            int count = dfsCount(list2, i, k - 1, 0, new boolean[m + 1]);
            if (count > maxCount) maxCount = count;
        }

        int[] result = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            int count = dfsCount(list1, i, k, 0, new boolean[n + 1]);
            result[i] = count + maxCount;
        }

        return result;
    }

    private int dfsCount(List<Integer>[] list, int i, int k, int step, boolean[] visited) {
        if (visited[i] || step == k + 1) return 0;
        visited[i] = true;
        int count = 1;

        List<Integer> neighbors = list[i];

        for (Integer neighbor : neighbors)
            count += dfsCount(list, neighbor, k, step + 1, visited);

        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.maxTargetNodes(new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}},
                new int[][]{{0, 1}, {0, 2}, {0, 3}, {2, 7}, {1, 4}, {4, 5}, {4, 6}}, 2)));
    }
} 