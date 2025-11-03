package problems.leetcode.p1578;

class Solution {
    public int minCost(String colors, int[] neededTime) {
        int sum = 0;

        char[] chars = colors.toCharArray();
        char last = chars[0];
        int subMin = neededTime[0];
        int subSum = subMin;
        for (int i = 1; i < chars.length; i++) {

            if (chars[i] == last) {
                subSum += neededTime[i];
                if (neededTime[i] > subMin) {
                    subMin = neededTime[i];
                }
            } else {
                sum += subSum - subMin;

                subMin = neededTime[i];
                subSum = subMin;

                last = chars[i];
            }
        }

        sum += subSum - subMin;

        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minCost("abaac", new int[]{1, 2, 3, 4, 5}));
    }
}