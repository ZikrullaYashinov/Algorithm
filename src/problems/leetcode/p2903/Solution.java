package problems.leetcode.p2903;

import java.util.List;

class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int[] arr = new int[101];
            int count = 0;

            for (int j = i; j < n; j++) {
                int num = nums.get(j);
                if (arr[num] == 0)
                    count++;
                arr[num]++;

                sum += count * count;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().sumCounts(List.of(1, 2, 1)));
        System.out.println(new Solution().sumCounts(List.of(1, 1)));
    }
}