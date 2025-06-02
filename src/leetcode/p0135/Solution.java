package leetcode.p0135;

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int min = ratings[0];
        int minIndex = 0;

        for (int i = 1; i < n; i++) {
            if (ratings[i] < min) {
                min = ratings[i];
                minIndex = i;
            }
        }

        int[] candyCounts = new int[n];
        candyCounts[minIndex] = 1;

        right(ratings, candyCounts, minIndex, n);
        left(ratings, candyCounts, minIndex, n);

        int sum = 0;
        for (int candyCount : candyCounts) {
            sum += candyCount;
        }
        return sum;
    }

    private void right(int[] ratings, int[] candyCounts, int i, int n) {
        if (i > n - 2) return;

        int currCount = candyCounts[i];
        int nextCount = candyCounts[i + 1];

        int currRating = ratings[i];
        int nextRating = ratings[i + 1];

        if (currRating < nextRating) {
            if (currCount < nextCount) return;

            candyCounts[i + 1] = currCount + 1;
            right(ratings, candyCounts, i + 1, n);
        } else if (currRating > nextRating) {
            if (currCount > nextCount && nextCount != 0) return;

            if (nextCount == 0) {
                candyCounts[i + 1] = 1;

                if (currCount == 1)
                    left(ratings, candyCounts, i + 1, n);
            } else {
                left(ratings, candyCounts, i + 1, n);
            }

            right(ratings, candyCounts, i + 1, n);
        } else if (nextCount == 0) {
            candyCounts[i + 1] = 1;
            right(ratings, candyCounts, i + 1, n);
        }
    }

    private void left(int[] ratings, int[] candyCounts, int i, int n) {
        if (i < 1) return;

        int currCount = candyCounts[i];
        int previousCount = candyCounts[i - 1];

        int currRating = ratings[i];
        int previousRating = ratings[i - 1];

        if (currRating < previousRating) {
            if (currCount < previousCount) return;

            candyCounts[i - 1] = currCount + 1;
            left(ratings, candyCounts, i - 1, n);
        } else if (currRating > previousRating) {
            if (currCount > previousCount && previousCount != 0) return;

            if (previousCount == 0) {
                candyCounts[i - 1] = 1;

                if (currCount == 1)
                    right(ratings, candyCounts, i - 1, n);
            } else {
                right(ratings, candyCounts, i - 1, n);
            }

            left(ratings, candyCounts, i - 1, n);
        } else if (previousCount == 0) {
            candyCounts[i - 1] = 1;
            left(ratings, candyCounts, i - 1, n);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.candy(new int[]{1, 3, 4, 5, 2}));
        System.out.println(solution.candy(new int[]{1, 3, 2, 2, 1}));
        System.out.println(solution.candy(new int[]{1, 0, 2}));
        System.out.println(solution.candy(new int[]{1, 2, 2}));
    }
}