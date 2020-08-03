package LeetCode.Trees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesReturnForest {
  public List<TreeNode> delNodes(TreeNode root, int[] to_delete){
    List<TreeNode> res = new ArrayList<>();
    Set<Integer> del_set = new HashSet<>();
    for (int i : to_delete) {
      del_set.add(i);
    }
    delNodes_helper(root, res, del_set);
    if(!del_set.contains(root.val))
      res.add(root);
    return res;
  }

  public TreeNode delNodes_helper(TreeNode node, List<TreeNode> res, Set<Integer> del_set){
    if(node == null) return null;

    node.left = delNodes_helper(node.left, res, del_set);
    node.right = delNodes_helper(node.right, res, del_set);

    if (del_set.contains(node.val)) {
      if (node.left != null)
        res.add(node.left);
      if (node.right != null)
        res.add(node.right);
      return null;
    }

    return node;
  }

  public static void main(String[] args){
    TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)), new TreeNode(3, new TreeNode(6, null, null), new TreeNode(7, null, null)));
    DeleteNodesReturnForest d = new DeleteNodesReturnForest();
    List<TreeNode> res = d.delNodes(root, new int[] {3,5});
    System.out.println("new");
  }
}
