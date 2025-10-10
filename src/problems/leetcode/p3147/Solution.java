package problems.leetcode.p3147;

class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;

        int max = Integer.MIN_VALUE;
        for (int i = n - 1; i >= n - k; i--) {
            if (max < energy[i]) {
                max = energy[i];
            }
        }


        for (int i = n - 1; i >= 0; i--) {
            if (i - k >= 0) {
                energy[i - k] += energy[i];
                if (energy[i - k] > max) {
                    max = energy[i - k];
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumEnergy(new int[]{5, 2, -10, -5, 1}, 3));
    }
}