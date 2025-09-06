package problems.leetcode.p3495;

class Solution {
    public long minOperations(int[][] queries) {
        long res = 0;
        for (int[] query : queries) {
            res += operateCount(query[0], query[1]);
        }
        return res;
    }

    private long operateCount(int left, int right) {
        long count = 1;
        long i = 1;
        while (4 * i < left) {
            count++;
            i *= 4;
        }

        long res = 0;
        if (i < left)
            res -= count * (left - i);

        if (i > left)
            if (i > right)
                res += count * (right - left + 1);
            else
                res += count * (i - left);

        while (i <= right) {
            if (4 * i <= right)
                res += count * 3 * i;
            else
                res += count * (right - i + 1);
            count++;
            i *= 4;
        }

        return (res + 1) / 2;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minOperations(new int[][]{{1, 2}, {2, 4}}));
        System.out.println(solution.minOperations(new int[][]{{2, 6}}));
    }
}