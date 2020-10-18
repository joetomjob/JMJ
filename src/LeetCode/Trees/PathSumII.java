package LeetCode.Trees;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
  List<List<Integer>> res;
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    res = new ArrayList<>();
    backTrack(root, 0, new ArrayList<>(), sum);
    return res;
  }

  public void backTrack(TreeNode node, int curSum, List<Integer> curList, int sum) {
    if(node == null) return;

    if(curSum+node.val == sum && node.left == null && node.right == null) {
      curList.add(node.val);
      res.add(new ArrayList<>(curList));
      curList.remove(curList.size() - 1);
      return;
    }
    curList.add(node.val);
    backTrack(node.left, curSum + node.val, curList, sum);
    curList.remove(curList.size() - 1);

    curList.add(node.val);
    backTrack(node.right, curSum + node.val, curList, sum);
    curList.remove(curList.size() - 1);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null), new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1))));
    PathSumII p = new PathSumII();
    List<List<Integer>> res = p.pathSum(root, 22);
    for(List<Integer> l : res) {
      for(Integer i : l) {
        System.out.print(i);
        System.out.print('\t');
      }
      System.out.print('\n');
    }
  }
}
