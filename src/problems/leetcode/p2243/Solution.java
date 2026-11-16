package problems.leetcode.p2243;

class Solution {
    public String digitSum(String s, int k) {
        int n = s.length();
        if (n <= k)
            return s;

        StringBuilder sb = new StringBuilder();

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += s.charAt(i) - '0';
            if ((i + 1) % k == 0 || i == n - 1) {
                sb.append(sum);
                sum = 0;
            }
        }

        return digitSum(sb.toString(), k);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().digitSum("11111222223", 3));
    }
}