package problems.leetcode.p1910;

class Solution {
    public String removeOccurrences(String s, String part) {
        int n = part.length();
        StringBuilder sb = new StringBuilder(s);
        int i = sb.indexOf(part);
        while (i != -1) {
            sb.delete(i, i + n);
            i = sb.indexOf(part);
        }
        return sb.toString();
    }
}