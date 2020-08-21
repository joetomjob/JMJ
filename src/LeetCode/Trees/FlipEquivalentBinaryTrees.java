package LeetCode.Trees;

public class FlipEquivalentBinaryTrees {
  public boolean flipEqiv(TreeNode root1, TreeNode root2 ){
    if(root1 == null && root2 == null)
      return true;
    if(root1 == null || root2 == null || root1.val != root2.val)
      return false;

    return ((flipEqiv(root1.right, root2.right) && flipEqiv(root1.left, root2.left))
        || (flipEqiv(root1.left, root2.right) && flipEqiv(root1.right, root2.left)));
  }

  public static void main(String[] args){
    TreeNode root1 = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5, new TreeNode(7), new TreeNode(8))), new TreeNode(3, new TreeNode(6), null));
    TreeNode root2 = new TreeNode(1, new TreeNode(3, null, new TreeNode(6)), new TreeNode(2, new TreeNode(4), new TreeNode(5, new TreeNode(8), new TreeNode(7))));
    FlipEquivalentBinaryTrees b = new FlipEquivalentBinaryTrees();
    System.out.print(b.flipEqiv(root1, root2));
  }
}
