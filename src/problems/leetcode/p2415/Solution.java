package problems.leetcode.p2415;

class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        TreeNode reversedTree = reverse(root);
        setEvenNode(root, reversedTree, 1);
        return reversedTree;
    }

    private void setEvenNode(TreeNode node, TreeNode reversedNode, int step) {
        if (node == null)
            return;
        if (step++ % 2 == 1)
            reversedNode.val = node.val;
        setEvenNode(node.left, reversedNode.left, step);
        setEvenNode(node.right, reversedNode.right, step);
    }

    private TreeNode reverse(TreeNode node) {
        if (node == null)
            return null;
        TreeNode left = reverse(node.right);
        TreeNode right = reverse(node.left);
        return new TreeNode(node.val, left, right);
    }
}