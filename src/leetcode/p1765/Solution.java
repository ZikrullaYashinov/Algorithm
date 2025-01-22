package leetcode.p1765;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length;
        int m = isWater[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isWater[i][j] == 1) {
                    bfs(isWater, res, i, j, n, m);
                }
            }
        }
        return res;
    }

    int[] directions = {0, 1, 0, -1, 0};

    private void bfs(int[][] isWater, int[][] res, int x, int y, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        boolean[][] visited = new boolean[n][m];
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int i = poll[0], j = poll[1];
            for (int k = 0; k < 4; k++) {
                int newX = i + directions[k];
                int newY = j + directions[k + 1];
                if (newX >= 0 && newY >= 0
                        && newX < n && newY < m
                        && isWater[newX][newY] == 0
                        && !visited[newX][newY]
                        && res[newX][newY] > res[x][y] + 1) {
                    res[newX][newY] = res[i][j] + 1;
                    queue.offer(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] isWater = new int[][]{{0, 1}, {0, 0}};
        System.out.println(Arrays.deepToString(new Solution().highestPeak(isWater)));
    }
}