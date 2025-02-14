package leetcode.p3066;

import java.util.PriorityQueue;

class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        for (int i : nums) {
            queue.offer(Long.valueOf(i));
        }

        int count = 0;

        long minNum1 = queue.poll();
        long minNum2;
        while (minNum1 < k) {
            minNum2 = queue.poll();
            queue.offer(minNum1 * 2 + minNum2);
            minNum1 = queue.poll();
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minOperations(new int[]{999999999, 999999999, 999999999}, 1000000000));
    }
}