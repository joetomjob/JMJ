package LeetCode.Trees;

public class IsSubTree {
  public boolean isSubtree(TreeNode s, TreeNode t) {
    if(s == null) return false;
    else if(isSameTree(s, t)) return true;
    else return isSubtree(s.left, t) || isSubtree(s.right, t);
  }

  public boolean isSameTree(TreeNode n1, TreeNode n2) {
    if(n1 == null && n2 == null) return true;
    if(n1 == null || n2 == null) return false;

    if(n1.val == n2.val) {
      return isSameTree(n1.left, n2.left) && isSameTree(n1.right, n2.right);
    } else return false;
  }

  public static void main(String[] args) {
    TreeNode s = new TreeNode(3, new TreeNode(4, new TreeNode(1, new TreeNode(0), null), new TreeNode(2)), new TreeNode(5));
    TreeNode t = new TreeNode(4, new TreeNode(1), new TreeNode(2));

    TreeNode s1 = new TreeNode(1, new TreeNode(1), null);
    TreeNode t1 = new TreeNode(1);

    IsSubTree i = new IsSubTree();
//    System.out.println(i.isSubtree(s, t));
    System.out.println(i.isSubtree(s1, t1));
  }
}
