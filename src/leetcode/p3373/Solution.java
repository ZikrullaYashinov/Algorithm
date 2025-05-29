package leetcode.p3373;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
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

        boolean[] oddList1 = new boolean[n + 1];
        boolean[] oddList2 = new boolean[m + 1];

        oddList1[0] = true;
        oddList2[0] = true;

        dfsCount(list1, 0, true, oddList1, new boolean[n + 1]);
        dfsCount(list2, 0, true, oddList2, new boolean[m + 1]);

        int oddCount = count(oddList1);
        int evenCount = oddList1.length - oddCount;

        int count = count(oddList2);
        int maxCount = Math.max(count, oddList2.length - count);

        int[] result = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            result[i] = (oddList1[i] ? oddCount : evenCount) + maxCount;
        }

        return result;
    }

    private int count(boolean[] list) {
        int count = 0;
        for (boolean b : list)
            count += b ? 1 : 0;
        return count;
    }

    private void dfsCount(List<Integer>[] list, int i, boolean odd, boolean[] oddList, boolean[] visited) {
        if (visited[i]) return;
        visited[i] = true;
        oddList[i] = odd;

        List<Integer> neighbors = list[i];

        for (Integer neighbor : neighbors) {
            dfsCount(list, neighbor, !odd, oddList, visited);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.maxTargetNodes(new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}},
                new int[][]{{0, 1}, {0, 2}, {0, 3}, {2, 7}, {1, 4}, {4, 5}, {4, 6}})));
    }
}