package LeetCode.Trees;

public class HouseRobberIII {
  public int rob(TreeNode root){
    int[] ans = robHelper(root);
    return Math.max(ans[0], ans[1]);
  }

  public int[] robHelper(TreeNode root) {
    if(root == null){
      return new int[2];
    }

    int[] left = robHelper(root.left);
    int[] right = robHelper(root.right);

    int[] ans = new int[2];
    ans[0] = root.val + left[1] + right[1];
    ans[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

    return ans;
  }

  public static void main(String[] args){
    HouseRobberIII h = new HouseRobberIII();
    TreeNode root = new TreeNode(3, new TreeNode(12, new TreeNode(1), new TreeNode(2)), new TreeNode(4, new TreeNode(2), new TreeNode(17)));
    System.out.print(h.rob(root));
  }
}
