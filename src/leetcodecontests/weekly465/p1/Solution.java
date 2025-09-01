package leetcodecontests.weekly465.p1;

import java.util.Arrays;

class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        int[] res = new int[friends.length];
        int index = 0;
        for (int orderId : order) {
            int i = Arrays.binarySearch(friends, orderId);
            if (i >= 0) {
                res[index++] = orderId;
                if (index == friends.length)
                    return res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                new Solution().recoverOrder(new int[]{3, 1, 2, 5, 4}, new int[]{1, 3, 4})));
    }
}