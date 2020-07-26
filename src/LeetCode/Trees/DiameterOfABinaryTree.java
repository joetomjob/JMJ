package LeetCode.Trees;

public class DiameterOfABinaryTree {
  int ans;
  public int diameterOfBinaryTree(TreeNode root){
    if(root == null) return 0;
    ans = 1;
    depthTree(root);
    return ans-1;
  }

  public int depthTree(TreeNode root){
    if(root == null) return 0;
    int L = depthTree(root.left);
    int R = depthTree(root.right);

    ans = Math.max(ans, L+R+1);
    return Math.max(L, R) + 1;
  }
  public static void main(String[] args) {
    DiameterOfABinaryTree d = new DiameterOfABinaryTree();
    TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)), new TreeNode(3, null, null));
    System.out.println(d.diameterOfBinaryTree(root));
  }
}
