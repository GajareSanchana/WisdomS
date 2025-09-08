class Solution {
    private TreeNode prev = null;

    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }

    private boolean inorder(TreeNode node) {
        if (node == null) return true;

        // Left subtree
        if (!inorder(node.left)) return false;

        // Check current node with previous
        if (prev != null && node.val <= prev.val) {
            return false;
        }
        prev = node;

        // Right subtree
        return inorder(node.right);
    }
}
