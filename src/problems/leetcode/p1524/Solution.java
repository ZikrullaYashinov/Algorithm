package problems.leetcode.p1524;

class Solution {
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int sum = 0;
        long countOdd = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            countOdd += sum % 2;
        }

        return (int) ((countOdd * (n - countOdd + 1)) % 1_000_000_007L);
    }
}