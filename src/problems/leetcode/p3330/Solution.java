package problems.leetcode.p3330;

class Solution {
    public int possibleStringCount(String word) {
        int res = 1;
        int count = 0;
        char last = word.charAt(0);
        for (int i = 1; i < word.length(); i++) {
            count++;
            char cur = word.charAt(i);
            if (last != cur && count > 0) {
                res += count - 1;
                count = 0;
            }
            last = cur;
        }
        res += count;
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.possibleStringCount("abbcccc"));
        System.out.println(solution.possibleStringCount("abcd"));
        System.out.println(solution.possibleStringCount("aaaa"));
    }
}