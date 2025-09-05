package problems.leetcode.p2683;

class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        return valid(derived, n);
    }

    private boolean valid(int[] target, int n) {
        int temp = 0;
        for (int i = 0; i < n - 1; i++)
            temp ^= target[i];
        return temp == target[n - 1];
    }
}
