class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();

        int[] arr = new int[n + 1];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums.get(i);
            arr[i + 1] = sum;
        }

        int min = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + l; j <= Math.min(i + r, n); j++) {
                int temp = arr[j] - arr[i];
                if (temp > 0 && (temp < min || min == 0))
                    min = temp;
            }
        }

        if (min == 0)
            return -1;

        return min;
    }
}