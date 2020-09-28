package LeetCode.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IsSameTree {
  public boolean isSameTree(TreeNode p, TreeNode q){
    //BFS with null value
    List<Integer> first = BFS(p);
    List<Integer> second = BFS(q);
    if(first.size() != second.size()) return false;
    for (int i = 0; i < first.size(); i++) {
      if(first.get(i) == null && second.get(i) == null) continue;
      else if (first.get(i) == null || second.get(i) == null) return false;
      else if(first.get(i).intValue() != second.get(i).intValue()) return false;
    }
    return true;
  }

  public List<Integer> BFS(TreeNode node){
    List<Integer> res = new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();
    q.add(node);

    while(!q.isEmpty()) {
      TreeNode n = q.poll();
      res.add(n != null ? n.val : null);

      if(n != null && (n.left != null || n.right != null)){
        q.add(n.left);
        q.add(n.right);
      }
    }
    return res;
  }

  // recursion
  public boolean isSameTreeII(TreeNode p, TreeNode q){
    if(p == null && q == null) return true;

    if(p == null || q == null) return false;

    if(p.val != q.val) return false;

    return isSameTreeII(p.left, q.left) && isSameTreeII(p.right, q.right);
  }

  public static void main(String[] args){
    TreeNode p = new TreeNode(1, new TreeNode(2), null);
    TreeNode q = new TreeNode(1, null, new TreeNode(2));
    IsSameTree i = new IsSameTree();
    System.out.println(i.isSameTree(p, q));
  }
}
