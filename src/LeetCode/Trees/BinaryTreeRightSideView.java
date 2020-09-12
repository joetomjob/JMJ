package LeetCode.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

  public List<Integer> rightSideView(TreeNode root){
    List<Integer> res = new ArrayList<>();
    if(root == null) return res;
    Queue<TreeNode> q = new LinkedList<>();
    List<TreeNode> list = new LinkedList<>();
    q.add(root);
    q.add(null);

    while(!q.isEmpty()){
      TreeNode node = q.poll();
      if(node != null){
        list.add(node);
        if(node.left != null) q.add(node.left);
        if(node.right != null) q.add(node.right);
      } else {
        list.add(node);
        if(!q.isEmpty()) q.add(null);
      }
    }
    int n = list.size();
    for(int i = 1; i < n; i++){
      if(list.get(i) == null) res.add(list.get(i-1).val);
    }
    return res;
  }

  public static void main(String[] args){
    TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3, new TreeNode(4), null));
    BinaryTreeRightSideView b = new BinaryTreeRightSideView();
    List<Integer> res = b.rightSideView(root);
  }
}
