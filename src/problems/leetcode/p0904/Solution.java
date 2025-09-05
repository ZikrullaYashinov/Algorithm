package problems.leetcode.p0904;

class Solution {
    public int totalFruit(int[] fruits) {
        int[] fruitsCount = new int[100_001];
        int countOfTypes = 0;
        int count = 0;
        int res = 0;

        int left = 0, right = 0;
        while (right < fruits.length) {
            int fruit = fruits[right];
            if (fruitsCount[fruit] > 0) {
                fruitsCount[fruit]++;
                count++;
                right++;
                if (count > res) res = count;
            } else if (countOfTypes == 2) {
                fruitsCount[fruits[left]]--;
                if (fruitsCount[fruits[left]] == 0)
                    countOfTypes--;
                left++;
                count--;
            } else {
                countOfTypes++;
                fruitsCount[fruit]++;
                count++;
                right++;
                if (count > res) res = count;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));
        System.out.println(solution.totalFruit(new int[]{1, 2, 3, 2, 2}));
        System.out.println(solution.totalFruit(new int[]{0, 1, 2, 2}));
    }
}