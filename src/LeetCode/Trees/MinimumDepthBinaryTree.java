package LeetCode.Trees;

public class MinimumDepthBinaryTree {
  int min;
  public int minDepth(TreeNode root) {
    min = Integer.MAX_VALUE;
    if(root == null) return 0;
    helper(root, 1);
    return min;
  }

  public void helper(TreeNode node, int curH) {
    if(node == null) return;

    if(node.left == null && node.right == null) {
      min = Math.min(min, curH);
      return;
    }

    if(min > curH) helper(node.left, curH+1);
    if(min > curH) helper(node.right,curH+1);
  }
  public static void main(String[] args){

  }
}
