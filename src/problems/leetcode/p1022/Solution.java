package problems.leetcode.p1022;

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
    public int sumRootToLeaf(TreeNode root) {
        if (root == null) return 0;
        return sumNode(root, 0);
    }

    private int sumNode(TreeNode root, int sum) {
        if (root == null) return sum;
        int val = (sum << 1) + root.val;
        if (root.left == null && root.right == null) return val;
        sum = 0;
        if (root.left != null) sum += sumNode(root.left, val);
        if (root.right != null) sum += sumNode(root.right, val);
        return sum;
    }

    static void main() {
        Solution solution = new Solution();
        System.out.println(solution.sumRootToLeaf(new TreeNode(1,
                new TreeNode(0, new TreeNode(0), new TreeNode(1)),
                new TreeNode(1, new TreeNode(0), new TreeNode(1)))));
    }
}