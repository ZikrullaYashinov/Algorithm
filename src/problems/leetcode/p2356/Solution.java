package problems.leetcode.p2356;

class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;

        int[] visitedCount1 = new int[n];
        int[] visitedCount2 = new int[n];

        for (int i = 0; i < n; i++) {
            visitedCount1[i] = -1;
            visitedCount2[i] = -1;
        }

        dfs(edges, node1, visitedCount1, new boolean[n], 0);
        dfs(edges, node2, visitedCount2, new boolean[n], 0);

        int result = -1;
        int resultValue = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int count1 = visitedCount1[i];
            int count2 = visitedCount2[i];
            int max = Math.max(count1, count2);

            if (count1 != -1 && count2 != -1 && max < resultValue) {
                result = i;
                resultValue = max;
            }
        }

        return result;
    }

    private void dfs(int[] edges, int i, int[] visitedCount, boolean[] visited, int step) {
        if (i == -1 || visited[i]) return;
        visited[i] = true;

        if (step > visitedCount[i])
            visitedCount[i] = step;

        dfs(edges, edges[i], visitedCount, visited, step + 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.closestMeetingNode(new int[]{2, 2, 3, -1}, 0, 1));
        System.out.println(solution.closestMeetingNode(new int[]{1, 2, -1}, 0, 2));
        System.out.println(solution.closestMeetingNode(new int[]{5, 3, 1, 0, 2, 4, 5}, 3, 2));
    }
}