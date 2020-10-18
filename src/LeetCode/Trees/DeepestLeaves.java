package LeetCode.Trees;

public class DeepestLeaves {
  int sum = 0, deepest = 0;
  public int deepestLeaves(TreeNode root) {
    dfs(root, 0);
    return sum;
  }

  public void dfs(TreeNode node, int depth) {
    if(node == null) return;

    if(node.left == null && node.right == null) {
      if(depth > deepest) {
        sum = node.val;
        deepest = depth;
      }
      else if (depth == deepest) sum += node.val;
      return;
    }

    dfs(node.left, depth+1);
    dfs(node.right, depth+1);
  }
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4, new TreeNode(7), null), new TreeNode(5)), new TreeNode(3, null, new TreeNode(6, null, new TreeNode(8))));
    DeepestLeaves d = new DeepestLeaves();
    System.out.println(d.deepestLeaves(root));
  }
}
