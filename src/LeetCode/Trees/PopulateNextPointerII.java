package LeetCode.Trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PopulateNextPointerII {
  public Node1 connect(Node1 root){
    Queue<Node1> q = new LinkedList<>();
    q.add(root);
    q.add(null);

    List<Node1> list = new LinkedList<>();
    if(root == null) return root;
    while (!q.isEmpty()){
      Node1 node = q.poll();
      if(node != null){
        list.add(node);
        if(node.left != null)
          q.add(node.left);
        if(node.right != null)
          q.add(node.right);
      }
      else {
        list.add(null);
        if(!q.isEmpty())
          q.add(null);
      }
    }

    for(int i = 1; i < list.size(); i++)
      if(list.get(i-1) != null)
        list.get(i-1).next = list.get(i);

    return root;
  }
  public static void main(String[] args){
    Node1 root = new Node1(1, new Node1(2, new Node1(4), new Node1(5), null), new Node1(3, null, new Node1(7), null), null);
    PopulateNextPointerII p = new PopulateNextPointerII();
    Node1 res = p.connect(root);
  }
}
