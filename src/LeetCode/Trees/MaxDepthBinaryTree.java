package LeetCode.Trees;

public class MaxDepthBinaryTree {

  public int maxDepth(TreeNode root){
    if(root == null) return 0;
    return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
  }

  public static void main(String[] args){
    TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
    MaxDepthBinaryTree m = new MaxDepthBinaryTree();
    System.out.println(m.maxDepth(root));
  }
}
