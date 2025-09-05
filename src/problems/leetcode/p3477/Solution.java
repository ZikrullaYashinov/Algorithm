package problems.leetcode.p3477;

class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int count = 0;
        for (int fruit : fruits) {
            for (int i = 0; i < n; i++) {
                if (fruit <= baskets[i]) {
                    baskets[i] = 0;
                    count++;
                    break;
                }
            }
        }
        return n - count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numOfUnplacedFruits(new int[]{4, 2, 5}, new int[]{3, 5, 4}));
    }
}