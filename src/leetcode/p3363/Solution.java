package leetcode.p3363;

class Solution {
    public int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length;
        boolean[][] visited = new boolean[n][n];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            visited[i][i] = true;
            sum += fruits[i][i];
        }

        visited[0][n - 1] = true;
        int max = fruits[0][n - 1];
        for (int i = 1; i < n - 1; i++) {
            int j = n - 1;
            int temp = max;
            while (!visited[i][j] && (visited[i - 1][j] || j + 1 < n && visited[i - 1][j + 1])) {
                visited[i][j] = true;
                fruits[i][j] += temp;
                if (fruits[i][j] > max)
                    max = fruits[i][j];
                j--;
            }
        }
        sum += fruits[n - 2][n - 1];

        visited[n - 1][0] = true;
        max = fruits[n - 1][0];
        for (int i = 1; i < n - 1; i++) {
            int j = n - 1;
            int temp = max;
            while (!visited[j][i] && (visited[j][i - 1] || j + 1 < n && visited[j + 1][i - 1])) {
                visited[j][i] = true;
                fruits[j][i] += temp;
                if (fruits[j][i] > max)
                    max = fruits[j][i];
                j--;
            }
        }
        sum += fruits[n - 1][n - 2];

        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxCollectedFruits(new int[][]{{1, 2, 3, 4}, {5, 6, 8, 7}, {9, 10, 11, 12}, {13, 14, 15, 16}}));
    }
}