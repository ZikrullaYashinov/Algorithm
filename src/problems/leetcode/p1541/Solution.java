package problems.leetcode.p1541;

class Solution {
    public int minInsertions(String s) {
        int balance = 0;
        int result = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (balance < 0) {
                    int temp = (-1 * balance + 1) / 2;
                    result += 3 * temp + balance;
                    balance = 0;
                } else if (balance == 1) {
                    result += balance;
                    balance = 0;
                }
                balance += 2;
            } else {
                balance--;
            }
        }

        if (balance < 0) {
            int temp = (-1 * balance + 1) / 2;
            result += 3 * temp;
        }

        return result + balance;
    }

    static void main() {
        System.out.println(new Solution().minInsertions("(()))(()))()())))"));
        System.out.println(new Solution().minInsertions("))())("));
        System.out.println(new Solution().minInsertions("(()))"));
        System.out.println(new Solution().minInsertions("())"));
    }
}