package LeetCode.Trees;

import java.util.ArrayList;
import java.util.LinkedList;

class Node1 {
  public int val;
  public Node1 left;
  public Node1 right;
  public Node1 next;

  public Node1() {}

  public Node1(int _val) {
    val = _val;
  }

  public Node1(int _val, Node1 _left, Node1 _right, Node1 _next) {
    val = _val;
    left = _left;
    right = _right;
    next = _next;
  }
};
public class PopulateNextPointer {
  public static Node1 BFS(Node1 root){
    if(root == null) return null;
    ArrayList<Node1>res = new ArrayList<>();
    LinkedList<Node1> queue = new LinkedList<>();

    queue.addLast(root);
    queue.addLast(null);

    while (!queue.isEmpty()) {
      Node1 n = queue.pollFirst();
      if(n != null) {
        res.add(n);
        if(n.left != null) {
          queue.addLast(n.left);
        }
        if(n.right != null) {
          queue.addLast(n.right);
        }
      } else {
        res.add(n);
        if(!queue.isEmpty()) {
          queue.addLast(null);
        }
      }
    }

    for (int i = 0; i < res.size(); i++) {
      if(res.get(i) != null){
        res.get(i).next = res.get(i+1);
      }
    }
    return root;
  }
  public static void main(String[] args) {
    Node1 n1 = new Node1(1,
        new Node1(2,
            new Node1(4, null, null, null),
            new Node1(5, null, null, null),
            null),
        new Node1(3,
            new Node1(6, null, null, null),
            new Node1(7, null, null, null),
            null),
        null);

    BFS(n1);
  }
}
