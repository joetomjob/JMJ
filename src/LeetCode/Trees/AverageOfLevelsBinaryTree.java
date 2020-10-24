package LeetCode.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsBinaryTree {
  public List<Double> averageOfLevels(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    List<Integer> temp = new ArrayList<>();
    List<Double> res = new ArrayList<>();

    q.add(root);
    q.add(null);

    while (!q.isEmpty()) {
      TreeNode node = q.poll();
      if(node != null) {
        temp.add(node.val);
        if(node.left != null) q.add(node.left);
        if(node.right != null) q.add(node.right);
      } else {
        Double s = 0.0;
        for(Integer i : temp) {
          s += i;
        }
        if(temp.size() > 0) res.add(s/((double)temp.size()));
        temp = new ArrayList<>();
        if(!q.isEmpty()) q.add(null);
      }
    }
    return res;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
    AverageOfLevelsBinaryTree a = new AverageOfLevelsBinaryTree();
    List<Double> res = a.averageOfLevels(root);
    for(Double i : res) {
      System.out.print(i);
      System.out.print('\t');
    }
  }
}
