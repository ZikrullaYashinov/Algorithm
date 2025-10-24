 package problems.leetcode.p3003;

class Solution {
    public int maxPartitionsAfterOperations(String s, int k) {
        char[] chars = s.toCharArray();
        char last = chars[0];
        int count = 0;
        int maxLength = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != last) {
                count++;
                last = chars[i];
                maxLength = 1;
            } else {
                maxLength++;
            }

            if (maxLength > k) {
                count++;
                maxLength = 1;
            }
        }
        return (count + k - 1) / k;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxPartitionsAfterOperations("accca", 2));
    }
}