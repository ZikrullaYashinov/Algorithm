package leetcode.p3304;

class Solution {
    public char kthCharacter(int k) {
        int step = find(k);
        return (char) ('a' + step % 26);
    }

    private int find(int k) {
        if (k == 1) return 0;
        int degree = (int) (Math.log(k) / Math.log(2));
        int valDegree = (int) Math.pow(2, degree);
        if (k == valDegree) valDegree /= 2;
        return find(k - valDegree) + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.kthCharacter(1));
        System.out.println(solution.kthCharacter(2));
        System.out.println(solution.kthCharacter(3));
        System.out.println(solution.kthCharacter(4));
        System.out.println(solution.kthCharacter(5));
        System.out.println(solution.kthCharacter(10));
    }
}