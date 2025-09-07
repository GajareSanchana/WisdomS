public class Main {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }

    static class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == p || root == q) return root;

            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);

            if (left != null && right != null) return root;
            return (left != null) ? left : right;
        }
    }

    public static void main(String[] args) {
        // Build example tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode p = root.left;              // 5
        TreeNode q = root.left.right.right;  // 4

        Solution sol = new Solution();
        TreeNode lca = sol.lowestCommonAncestor(root, p, q);

        if (lca != null)
            System.out.println("LCA of " + p.val + " and " + q.val + " is: " + lca.val);
        else
            System.out.println("LCA not found");
    }
}
