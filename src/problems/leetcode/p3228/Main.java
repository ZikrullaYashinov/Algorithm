package problems.leetcode.p3228;

class Solution {
    public int maxOperations(String s) {
        int sum = 0;
        int count = 0;
        boolean flag = true;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                count++;
                flag = true;
            } else if (flag) {
                sum += count;
                flag = false;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxOperations("1001101"));
    }
}