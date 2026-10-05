package problems.leetcode.p0022;

import java.util.ArrayList;
import java.util.List;

interface Generator {


    String generate(boolean[] arr);

}

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            f(res, i, generate(i));
        }

        f(res, n, "");

        return res;
    }

    private void f(List<String> res, int n, String s) {
        if (n == 0) {
            res.add(s);
            return;
        }
        for (int i = 1; i <= n; i++) {
            f(res, n - i, s + generate(i));
        }
    }

    private String generate(int n) {
        return "(".repeat(n) + ")".repeat(n);
    }

}