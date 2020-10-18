package LeetCode.Trees;

import java.util.*;

public class BinaryTreeLvlTraversalII {
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();

    if(root == null) return res;
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    q.add(null);

    List<Integer> temp = new ArrayList<>();
    while (!q.isEmpty()) {
      TreeNode node = q.poll();
      if(node != null) {
        temp.add(node.val);

        if (node.left != null) q.add(node.left);
        if (node.right != null) q.add(node.right);
      } else {
        res.add(new ArrayList<>(temp));
        temp = new ArrayList<>();

        if(!q.isEmpty()) q.add(null);
      }
    }
    Collections.reverse(res);
    return res;
  }

  public static void main(String[] args){

  }
}
