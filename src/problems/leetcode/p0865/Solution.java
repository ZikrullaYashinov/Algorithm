package problems.leetcode.p0865;

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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int[] nodes = new int[501];

        int deepCount = deepCount(root, 1, nodes);

        return findSmallestSubtree(root, deepCount, nodes);
    }

    private TreeNode findSmallestSubtree(TreeNode root, int deepCount, int[] nodes) {
        if (root == null) return null;

        if (nodes[root.val] == deepCount) {
            TreeNode left = findSmallestSubtree(root.left, deepCount, nodes);
            TreeNode right = findSmallestSubtree(root.right, deepCount, nodes);
            if (left != null && right != null) return root;
            if (left != null) return left;
            if (right != null) return right;
            return root;
        }

        return null;
    }

    private int deepCount(TreeNode root, int i, int[] nodes) {
        if (root == null) return i;
        int left = deepCount(root.left, i + 1, nodes);
        int right = deepCount(root.right, i + 1, nodes);
        nodes[root.val] = Math.max(left, right);
        return nodes[root.val];
    }

    static void main() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        Solution solution = new Solution();
        TreeNode result = solution.subtreeWithAllDeepest(root);

    }
}