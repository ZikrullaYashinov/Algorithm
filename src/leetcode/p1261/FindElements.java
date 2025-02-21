package leetcode.p1261;


import java.util.BitSet;

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

public class FindElements {
    BitSet bitSet = new BitSet();

    public FindElements(TreeNode root) {
        root.val = 0;
        initTree(root);
    }

    private void initTree(TreeNode root) {
        if (root == null) return;
        bitSet.set(root.val);
        if (root.left != null) {
            root.left.val = root.val * 2 + 1;
            initTree(root.left);
        }
        if (root.right != null) {
            root.right.val = root.val * 2 + 2;
            initTree(root.right);
        }
    }

    public boolean find(int target) {
        return bitSet.get(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */