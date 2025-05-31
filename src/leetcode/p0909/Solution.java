package leetcode.p0909;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public int snakesAndLadders(int[][] board) {
        int n = board.length;

        int FINISH = n * n - 1;

        int[] arr = new int[n * n];
        int index = 0;

        for (int j = n - 1; j >= 0; j -= 2) {
            for (int i = 0; i < n; i++) {
                arr[index++] = board[j][i];
            }
            index += n;
        }

        index = n;
        for (int j = n - 2; j >= 0; j -= 2) {
            for (int i = 0; i < n; i++) {
                arr[index++] = board[j][n - 1 - i];
            }
            index += n;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        board[0][0] = -2;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int value = cur[0];
            int step = cur[1];

            if (value == FINISH) {
                return step;
            }

            for (int i = 1; i <= 6 && value + i <= FINISH; i++) {
                int newValue = arr[value + i];
                if (newValue != -2) {
                    arr[value + i] = -2;
                    if (newValue == -1) {
                        queue.add(new int[]{value + i, step + 1});
                    } else {
                        queue.add(new int[]{newValue - 1, step + 1});
                    }
                }

            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.snakesAndLadders(new int[][]{
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}}));
    }
}