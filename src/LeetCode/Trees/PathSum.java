package LeetCode.Trees;

public class PathSum {
  public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) return false;
    return backTrack(root, sum, 0);
  }

  public boolean backTrack(TreeNode root, int sum, int curSum){
    if(root == null) return false;
    if(root.left == null && root.right == null) return curSum+root.val == sum;
    return backTrack(root.left, sum, curSum + root.val) || backTrack(root.right, sum, curSum+root.val);
  }
  public static void main(String[] args){
    TreeNode root = new TreeNode(1, new TreeNode(2), null);
    PathSum p = new PathSum();
    System.out.println(p.hasPathSum(root, 1));
  }
}
