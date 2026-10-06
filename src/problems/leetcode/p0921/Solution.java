package problems.leetcode.p0921;

class Solution {
    public int minAddToMakeValid(String s) {
        int sum = 0;
        int cur = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (cur < 0) {
                    sum += -1 * cur;
                    cur = 1;
                } else {
                    cur++;
                }
            } else {
                cur--;
            }
        }
        return sum + Math.abs(cur);
    }
}