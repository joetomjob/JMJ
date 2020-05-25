package LeetCode.Trees;

public class FlattenBinaryTree {
    public TreeNode flatten(TreeNode root) {
        return flattenTree(root);
    }

    public TreeNode flattenTree(TreeNode node) {
        if(node == null) {
            return null;
        }

        if(node.left == null && node.right == null) {
            return node;
        }

        TreeNode leftTail = flattenTree(node.left);
        TreeNode rightTail = flattenTree(node.right);

        if(leftTail != null) {
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }

        return rightTail != null ? rightTail : leftTail;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, null, new TreeNode(6)));
        FlattenBinaryTree fb = new FlattenBinaryTree();
        fb.flatten(root);

        while (root != null) {
            System.out.print(root.val);
            System.out.print('\t');
            root = root.right;
        }
    }
}
