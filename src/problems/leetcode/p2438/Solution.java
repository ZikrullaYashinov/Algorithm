package problems.leetcode.p2438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] productQueries(int n, int[][] queries) {
        List<Integer> powers = findPowers(n);
        int[] res = new int[queries.length];

        for (int j = 0; j < queries.length; j++) {
            long num = 1;
            for (int i = queries[j][0]; i <= queries[j][1]; i++) {
                num *= powers.get(i);
                num %= 1_000_000_007;
            }
            res[j] = (int) num;
        }

        return res;
    }

    private List<Integer> findPowers(int n) {
        List<Integer> res = new ArrayList<>();
        while (n > 0) {
            int maxDegree = (int) (Math.log(n) / Math.log(2));
            int num = 1 << maxDegree;
            n -= num;
            res.add(0, num);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.productQueries(15, new int[][]{{0, 1}, {2, 2}, {0, 3}})));
    }
}