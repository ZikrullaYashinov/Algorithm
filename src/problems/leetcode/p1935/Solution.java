package problems.leetcode.p1935;

class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] arr = text.split(" ");
        int count = arr.length;
        for (String s : arr) {
            for (char c : brokenLetters.toCharArray()) {
                if (s.contains(String.valueOf(c))) {
                    count--;
                    break;
                }
            }
        }
        return count;
    }
}