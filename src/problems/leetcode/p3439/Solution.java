package problems.leetcode.p3439;

class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int time = 0;
        int n = startTime.length;

        int[] arr = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int start = startTime[i];
            int end = endTime[i];

            int distance = start - time;
            time = end;

            arr[i] = distance;
        }

        arr[n] = eventTime - endTime[n - 1];

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int maxSum = 0;
        for (int i = k; i <= n; i++) {
            sum += arr[i];
            if (sum > maxSum) maxSum = sum;
            sum -= arr[i - k];
        }

        return maxSum;
    }
}