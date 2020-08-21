package LeetCode.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
  public List<List<Integer>> levelOrder(TreeNode root){
    List<List<Integer>> res = new ArrayList<>();
    if(root == null) return res;
    Queue<TreeNode> q = new LinkedList();
    q.add(root);
    q.add(null);
    List<Integer> temp = new ArrayList<>();
    while (!q.isEmpty()){
      TreeNode node = q.poll();
      if(node != null) {
        temp.add(node.val);
        if (node.left != null)
          q.add(node.left);
        if (node.right != null)
          q.add(node.right);
      } else {
        res.add(temp);
        temp = new ArrayList<>();
        if(!q.isEmpty())
          q.add(null);
      }
    }
    return res;
  }

  public static void main(String[] args){
    TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
    LevelOrderTraversal l = new LevelOrderTraversal();
    List<List<Integer>> res = l.levelOrder(root);
    for(List<Integer> list : res) {
      System.out.print('[');
      for(Integer i : list) {
        System.out.print(i);
        System.out.print(',');
      }
      System.out.print(']');
      System.out.println();
    }
  }
}
