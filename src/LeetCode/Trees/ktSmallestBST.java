package LeetCode.Trees;

import java.util.ArrayList;
import java.util.Stack;

// inorder traversal of BST is an array sorted i ascending order.
public class ktSmallestBST {
  public ArrayList<Integer> inOrderRec(TreeNode root, ArrayList<Integer> res) {
    if (root == null) return res;
    inOrderRec(root.left, res);
    res.add(root.val);
    inOrderRec(root.right, res);
    return res;
  }

  public int kthSmallestRec(TreeNode root, int k) {
    ArrayList<Integer> res = inOrderRec(root, new ArrayList<Integer>());
    return res.get(k - 1);
  }

  public int kthSmallestIte(TreeNode root, int k) {
    Stack<TreeNode> s = new Stack<>();
    while (!s.empty() || root != null) {
      while (root != null) {
        s.add(root);
        root = root.left;
      }
      root = s.pop();
      if(--k == 0) return root.val;
      root = root.right;
    }
    return -1;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(
        5,
        new TreeNode(
            3,
            new TreeNode(2),
            new TreeNode(4)),
        new TreeNode(
            6,
            null,
            new TreeNode(7)));


    ktSmallestBST k = new ktSmallestBST();
    System.out.print(k.kthSmallestRec(root, 2));
    System.out.print(k.kthSmallestIte(root, 2));
  }
}
