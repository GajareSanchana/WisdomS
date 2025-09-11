public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Case 1: [1,2,2,3,4,4,3]
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(3);
        System.out.println(sol.isSymmetric(root1)); // true

        // Case 2: [1,2,2,null,3,null,3]
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.right = new TreeNode(3);
        root2.right.right = new TreeNode(3);
        System.out.println(sol.isSymmetric(root2)); // false

        // Case 3: [1]
        TreeNode root3 = new TreeNode(1);
        System.out.println(sol.isSymmetric(root3)); // true

        // Case 4: []
        System.out.println(sol.isSymmetric(null)); // true
    }
}
