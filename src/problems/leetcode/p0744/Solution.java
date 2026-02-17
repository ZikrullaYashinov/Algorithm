package problems.leetcode.p0744;

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char res = '*';
        for (char letter : letters) {
            if (letter > target && (res == '*' || res > letter)) {
                res = letter;
            }
        }
        if (res == '*') return letters[0];
        return res;
    }
}