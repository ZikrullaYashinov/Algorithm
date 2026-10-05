package problems.leetcode.p0856;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int scoreOfParentheses(String s) {
        List<Integer> stack = new ArrayList<>();
        int depth = 0;
        boolean open = true;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                depth++;
                open = true;
            } else {
                depth--;
                if (open) {
                    stack.add(depth);
                    open = false;
                }
            }
        }
        int sum = 0;
        for (Integer d : stack) {
            sum += 1 << d;
        }
        return sum;
    }

    static void main() {
        System.out.println(new Solution().scoreOfParentheses("(()())"));
        System.out.println(new Solution().scoreOfParentheses("()((()()))"));
    }
}