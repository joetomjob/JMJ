package LeetCode.Trees;
//           3
//         /   \
//        5     1
//       / \   / \
//      6   2 0   8
//         / \
//        7   4
//
// inorder : 6, 5, 7, 2, 4, 3, 0, 1, 8

public class LowestCommonAncestorBST {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
    return dfs(root, p, q);
  }

  public TreeNode dfs(TreeNode root, TreeNode p, TreeNode q){
    if(root == null) return null;

    if(root == p || root == q) return root;

    TreeNode l = dfs(root.left, p, q);
    TreeNode r = dfs(root.right, p ,q);

    if(l != null && r != null) return root;
    return l != null ? l : r;
  }
  public static void main(String[] args){
    TreeNode n1 = new TreeNode(3);
    TreeNode n2 = new TreeNode(5);
    TreeNode n3 = new TreeNode(1);
    TreeNode n4 = new TreeNode(6);
    TreeNode n5 = new TreeNode(2);
    TreeNode n6 = new TreeNode(0);
    TreeNode n7 = new TreeNode(8);
    TreeNode n8 = new TreeNode(7);
    TreeNode n9 = new TreeNode(4);

    n1.left = n2;
    n1.right = n3;

    n2. left = n4;
    n2.right = n5;

    n3.left = n6;
    n3.right = n7;

    n5.left = n8;
    n5.right = n9;

    LowestCommonAncestorBST l = new LowestCommonAncestorBST();
    System.out.println(l.lowestCommonAncestor(n1, n2, n9).val);
  }
}
