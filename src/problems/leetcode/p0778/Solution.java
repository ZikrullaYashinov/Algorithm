package problems.leetcode.p0778;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        if (n == 1) return grid[0][0];
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return o1[2] - o2[2];
                    }
                }
        );
        pq.offer(new int[]{0, 0, grid[0][0]});
        visited[0][0] = true;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int i = cur[0];
            int j = cur[1];
            int max = cur[2];

            int[] directions = {-1, 0, 1, 0, -1};

            for (int k = 0; k < 4; k++) {
                int kx = directions[k] + i;
                int ky = directions[k + 1] + j;

                if (kx >= 0 && kx < n && ky >= 0 && ky < n && !visited[kx][ky]) {
                    if (!(kx == n - 1 && ky == n - 1)) {
                        pq.offer(new int[]{kx, ky, Math.max(max, grid[kx][ky])});
                        visited[kx][ky] = true;
                    } else {
                        return Math.max(max, grid[kx][ky]);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.swimInWater(new int[][]{
                {0, 1, 2, 3, 4}, {24, 23, 22, 21, 5}, {12, 13, 14, 15, 16}, {11, 17, 18, 19, 20},
                {10, 9, 8, 7, 6}}));
    }
}