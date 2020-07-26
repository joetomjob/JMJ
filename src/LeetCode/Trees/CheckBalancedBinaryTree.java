package LeetCode.Trees;

import java.util.Map;

public class CheckBalancedBinaryTree {
  public boolean isBalanced(TreeNode root) {
    if (root == null)
      return true;

    return Math.abs(calculateHeight(root.left) - calculateHeight(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right);
  }

  public int calculateHeight(TreeNode root){
    if(root == null)
      return 0;

    return Math.max(calculateHeight(root.left), calculateHeight(root.right)) + 1;
  }

  // bottom up recursion
  public boolean isBalanced1(TreeNode root) {
    return isBalancedHelper(root) != null;
  }

  public Integer isBalancedHelper(TreeNode root){
    if (root == null)
      return 0;

    Integer left = isBalancedHelper(root.left);
    Integer right = isBalancedHelper(root.right);

    if(left == null || right == null)
      return null;
    if(Math.abs(left - right) > 1)
      return null;
    return Math.max(left, right) + 1;
  }

  public static void main(String[] args) {
    CheckBalancedBinaryTree ch = new CheckBalancedBinaryTree();
    TreeNode root = new TreeNode(3, new TreeNode(9, null, null), new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null)));
    TreeNode root1 = new TreeNode(1, new TreeNode(2, new TreeNode(3,  new TreeNode(4, null, null),  new TreeNode(4, null, null)), new TreeNode(3, null, null)), new TreeNode(2, null, null));
    System.out.println(ch.isBalanced(root));
    System.out.println(ch.isBalanced(root));
  }
}
