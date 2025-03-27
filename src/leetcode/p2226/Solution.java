package leetcode.p2226;

class Solution {
    public int maximumCandies(int[] candies, long k) {
        int n = candies.length;

        long max = 0, min = 0;

        for (int candy : candies) {
            max += candy;
        }

        if (max < k) return 0;

        max /= k;

        int med;
        long count;

        while (min <= max) {
            med = (int) ((min + max) / 2);
            count = count(candies, med);

            if (count < k) {
                max = med - 1;
            } else {
                min = med + 1;
            }
        }

        return (int) (min - 1);
    }

    long count(int[] candies, int med) {
        long count = 0;
        if (med == 0) med = 1;
        for (int candy : candies) {
            count += candy / med;
        }
        return count;
    }
}