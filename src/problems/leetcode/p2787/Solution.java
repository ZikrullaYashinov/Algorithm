package problems.leetcode.p2787;

class Solution {
    public int numberOfWays(int n, int x) {
        int[] dp = new int[301];

        int i = 1;
        boolean[] unique = new boolean[301];
        int degreeVal = (int) Math.pow(i, x) % 1_000_000_007;
        while (degreeVal <= 300) {
            unique[degreeVal] = true;
            dp[degreeVal] = 1;
            i++;
            degreeVal = (int) Math.pow(i, x) % 1_000_000_007;
        }

//        for (int j = 1; j <= 300; j++) {
//            if (dp[j] != 0) {
//                for (int k = j + 1; j + k <= 300; k++) {
//                    if (unique[k]) {
//                        dp[k + j] = dp[j] + dp[k];
//                    }
//                }
//            }
//            for (int k = 1; k < 301; k++) {
//                if (temp[k] != 0) {
//                    dp[k] += temp[k];
//                }
//            }
//        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOfWays(6, 1));
        System.out.println(solution.numberOfWays(4, 1));
        System.out.println(solution.numberOfWays(10, 2));
    }
}