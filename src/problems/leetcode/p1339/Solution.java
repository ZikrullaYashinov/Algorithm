package problems.leetcode.p1339;

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

    private long maxProduct = 0;

    public int maxProduct(TreeNode root) {
        int totalSum = sum(root);

        productDfs(root, totalSum);

        return (int) (maxProduct % 1_000_000_007);
    }

    private long productDfs(TreeNode root, int totalSum) {
        if (root == null) return 0;

        long left = productDfs(root.left, totalSum);
        long right = productDfs(root.right, totalSum);

        long product = left * (totalSum - left);
        if (product > maxProduct)
            maxProduct = product;


        product = right * (totalSum - right);
        if (product > maxProduct)
            maxProduct = product;

        return root.val;
    }

    private int sum(TreeNode root) {
        if (root == null) return 0;

        int leftSum = sum(root.left);
        int rightSum = sum(root.right);

        root.val += leftSum + rightSum;

        return root.val;
    }

    static void main() {
//        TreeNode root = new TreeNode(1,
//                new TreeNode(2,
//                        new TreeNode(4),
//                        new TreeNode(5)),
//                new TreeNode(3,
//                        new TreeNode(6),
//                        null));
//        1,null,2,3,4,null,null,5,6
        TreeNode root = new TreeNode(1,
                null,
                new TreeNode(2,
                        new TreeNode(3,
                                new TreeNode(4,
                                        new TreeNode(5,
                                                new TreeNode(6),
                                                null),
                                        null),
                                null),
                        null));
        System.out.println(new Solution().maxProduct(root));
    }
}