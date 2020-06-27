package LeetCode.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Zigzag_order {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    if (root == null) return new ArrayList<List<Integer>>();

    List<List<Integer>> res= new ArrayList<List<Integer>>();
    LinkedList<TreeNode> queue = new LinkedList<>();
    LinkedList<Integer> levelRes = new LinkedList<>();

    queue.addLast(root);
    queue.addLast(null);
    boolean isLtoR = true;
    while (queue.size() > 0) {
      TreeNode node = queue.pollFirst();
      if(node != null) {
        if(isLtoR) {
          levelRes.addLast(node.val);
        } else {
          levelRes.addFirst(node.val);
        }

        if(node.left != null) {
          queue.addLast(node.left);
        }
        if(node.right != null) {
          queue.addLast(node.right);
        }
      } else {
        res.add(levelRes);
        levelRes = new LinkedList<>();
        if(queue.size() > 0) {
          queue.addLast(null);
        }
        isLtoR = !isLtoR;
      }
    }
    return res;
  }
  public static void main(String[] args) {
    TreeNode root = new TreeNode(2,
        new TreeNode(1),
        new TreeNode(33,
            new TreeNode(25,
                new TreeNode(11,
                    new TreeNode(7),
                    new TreeNode(12,
                        null,
                        new TreeNode(13))),
                null),
            new TreeNode(40,
                new TreeNode(34,
                    null,
                    new TreeNode( 36)),
                null)));

    Zigzag_order z = new Zigzag_order();
    List<List<Integer>> res =  z.zigzagLevelOrder(root);
    for (int i = 0; i < res.size(); i++) {
      for (int j = 0; j < res.get(i).size(); j++) {
        System.out.print(res.get(i).get(j));
        System.out.print('\t');
      }
      System.out.print('\n');
    }
  }
}
