package problems.leetcode.p2197;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        int index = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            int gcd = gcd(nums[i], nums[index]);
            if (gcd != 1) {
                nums[index] = (int) lcm(nums[i], nums[index], gcd);
            } else {
                ans.add(nums[index]);
                index = i;
            }
        }
        ans.add(nums[index]);
        index = nums.length - 1;
        nums = new int[ans.size()];
        int j = 0;
        for (Integer an : ans) {
            nums[j++] = an;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = --j; i >= 0; i--) {
            int gcd = gcd(nums[i], nums[j]);
            if (gcd != 1) {
                nums[j] = (int) lcm(nums[i], nums[j], gcd);
            } else {
                res.add(0, nums[j]);
                j = i;
            }
        }
        res.add(0, nums[j]);
        return res;
    }

    private long lcm(int a, int b, int gcd) {
        return (long) a * b / gcd;
    }

    private int gcd(int a, int b) {
        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.replaceNonCoprimes(new int[]{6, 4, 3, 2, 7, 6, 2}));
        System.out.println(solution.replaceNonCoprimes(new int[]{287, 41, 49, 287, 899, 23, 23, 20677, 5, 825}));
        System.out.println(solution.replaceNonCoprimes(new int[]{31, 97561, 97561, 97561, 97561, 97561, 97561, 97561, 97561}));
        System.out.println(solution.replaceNonCoprimes(new int[]{2, 2, 1, 1, 3, 3, 3}));
    }
}