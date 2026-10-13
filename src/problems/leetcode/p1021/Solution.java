package problems.leetcode.p1021;

class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();

        int depth = 0;
        for (byte b : s.getBytes()) {
            if (b == '(') {
                if (depth > 0) {
                    sb.append('(');
                }
                depth++;
            } else {
                depth--;
                if (depth > 0) {
                    sb.append(')');
                }
            }
        }
        return sb.toString();
    }

    static void main() {
        System.out.println(new Solution().removeOuterParentheses("(()())(())"));
    }
}