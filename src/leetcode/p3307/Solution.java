package leetcode.p3307;

class Solution {
    public char kthCharacter(long k, int[] operations) {
        int step = find(k, operations);
        return (char) ('a' + step % 26);
    }

    private int find(long k, int[] operations) {
        if (k == 1) return 0;
        int degree = (int) (Math.log(k) / Math.log(2));
        long valDegree = (long) Math.pow(2, degree);
        if (k == valDegree) {
            valDegree /= 2;
            degree--;
        }

        return find(k - valDegree, operations) + operations[degree];
    }

    public static void main(String[] args) {
        SolutionKotlin solution = new SolutionKotlin();
        System.out.println(solution.kthCharacter(10, new int[]{0, 1, 0, 1}));
        System.out.println(solution.kthCharacter(5, new int[]{0, 0, 0}));
        System.out.println(solution.kthCharacter(12145134613L, new int[]{0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1}));
    }
}