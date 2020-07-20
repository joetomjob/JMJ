package LeetCode.Trees;

public class CountCompleteNodes {
  // easy method
  public int countNodes(TreeNode root) {
    if(root == null)
      return 0;
    return countNodes(root.left) + countNodes(root.right) + 1;
  }

  public int countNodes2(TreeNode root) {
    if(root == null)
      return 0;

    int l = 0, r=0;
    TreeNode left = root, right = root;
    while(left != null){
      left = left.left;
      l++;
    }

    while(right != null){
      right = right.right;
      r++;
    }
    if(r==l)
      return (int) Math.pow(2, l) - 1;
    return 1 + countNodes2(root.right) + countNodes2(root.left);
  }
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1, new TreeNode (2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null));
    CountCompleteNodes c = new CountCompleteNodes();
    System.out.println(c.countNodes(root));
    System.out.println(c.countNodes2(root));
  }
}
