package problems.leetcode.p1161;


import java.util.Arrays;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    public int maxLevelSum(TreeNode root) {
        long[] levelSums = new long[100_001];

        int levelsCount = dfs(root, 1, levelSums);

        int resLevel = 1;
        long maxLevelSum = levelSums[resLevel];

        for (int i = 1; i < levelsCount; i++) {
            long levelSum = levelSums[i];
            if (levelSum > maxLevelSum) {
                maxLevelSum = levelSum;
                resLevel = i;
            }
        }

        return resLevel;
    }

    private int dfs(TreeNode root, int level, long[] levelSums) {
        if (root == null) return level;

        levelSums[level] += root.val;

        return Math.max(
                dfs(root.left, level + 1, levelSums),
                dfs(root.right, level + 1, levelSums)
        );
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root2 = new TreeNode(1,
                new TreeNode(7,
                        new TreeNode(7),
                        new TreeNode(-8)),
                new TreeNode(0));
        TreeNode root = new TreeNode(-100,
                new TreeNode(-10,
                        new TreeNode(7),
                        new TreeNode(-8)),
                new TreeNode(-10));
        System.out.println(solution.maxLevelSum(root));
    }
}