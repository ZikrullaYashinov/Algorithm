package problems.leetcode.p0802;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] notTerminals = new boolean[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!notTerminals[i])
                dfs(graph, notTerminals, visited, i);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (notTerminals[i])
                res.add(i);

        return res;
    }

    private boolean dfs(int[][] graph, boolean[] notTerminals, boolean[] visited, int i) {
        if (visited[i] || notTerminals[i])
            return notTerminals[i];
        visited[i] = true;

        int[] paths = graph[i];

        boolean valid = true;
        for (int path : paths)
            valid = valid && dfs(graph, notTerminals, visited, path);

        notTerminals[i] = valid;
        return valid;
    }
    public static void main(String[] args) {
        System.out.println(new Solution().eventualSafeNodes(new int[][]{{1, 2, 3, 4}, {1, 2}, {3, 4}, {0, 4}, {}}));
        System.out.println(new Solution().eventualSafeNodes(new int[][]{{}, {0, 2, 3, 4}, {3}, {4}, {}}));
    }
}