package problems.leetcode.p3333;

class Solution {
    public int possibleStringCount(String word, int k) {
        int n = word.length();
        int last = word.charAt(0);
        int count = 1, res = 0, min = n - k;

        for (int i = 1; i < n; i++) {
            char cur = word.charAt(i);

            if (cur == last) {
                count++;
            } else {
                last = cur;
                res += Math.min(min, count - 1);
                count = 1;
            }
        }
        if (count > 1)
            res += Math.min(min, count - 1);

        return res + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.possibleStringCount("aabbccdd", 7));
        System.out.println(solution.possibleStringCount("aabbccdd", 8));
        System.out.println(solution.possibleStringCount("aaabbb", 3));
    }
}