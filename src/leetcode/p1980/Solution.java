package leetcode.p1980;

import java.util.Arrays;

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        int i = 0;
        for (String num : nums) {
            arr[i++] = Integer.parseInt(num, 2);
        }
        Arrays.sort(arr);

        int k = (1 << n) - 1;
        for (int j = arr.length - 1; j >= 0; j--) {
            if (arr[j] != k) {
                return f(Integer.toBinaryString(k), n);
            }
            k--;
        }
        return f(Integer.toBinaryString(k), n);
    }

    private String f(String binaryString, int n) {
        int length = binaryString.length();
        if (length == n) {
            return binaryString;
        }
        StringBuilder binaryStringBuilder = new StringBuilder(binaryString);
        for (int i = n - length - 1; i >= 0; i--) {
            binaryStringBuilder.insert(0, "0");
        }
        return binaryStringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findDifferentBinaryString(new String[]{"00", "01"}));
        System.out.println(solution.findDifferentBinaryString(new String[]{"01", "10"}));
        System.out.println(solution.findDifferentBinaryString(new String[]{"1"}));
    }
}