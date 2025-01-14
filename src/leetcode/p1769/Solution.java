package leetcode.p1769;

class Solution {
    public int[] minOperations(String boxes) {
        byte[] bytes = boxes.getBytes();
        int n = bytes.length;
        int[] sum = new int[n];
        int count = bytes[0] - '0';
        for (int i = 1; i < n; i++) {
            sum[i] += count + sum[i - 1];
            count += bytes[i] - '0';
        }
        count = bytes[n - 1] - '0';
        int[] rightSum = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            rightSum[i] += count + rightSum[i + 1];
            count += bytes[i] - '0';
            sum[i] += rightSum[i];
        }
        return sum;
    }
}