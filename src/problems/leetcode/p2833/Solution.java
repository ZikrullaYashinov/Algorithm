package problems.leetcode.p2833;

class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int sum = 0;
        int variables = 0;

        for (char c : moves.toCharArray()) {
            if (c == 'L')
                sum--;
            else if (c == 'R')
                sum++;
            else variables++;
        }

        return variables + Math.abs(sum);
    }
}