package LeetCode.BloombergPractice;

import java.util.Stack;

public class FlattenMultilevel {
  class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    Node(int val, Node prev, Node next, Node child){
      this.val = val;
      this.prev = prev;
      this.next = next;
      this.child = child;
    }
  };

  public Node flatten(Node head) {
    Node dummy = new Node(0, null, head, null);
    Node prev = dummy,curr;

    Stack<Node> s = new Stack<>();
    s.push(head);
    while(!s.isEmpty()){
      curr = s.pop();
      curr.prev = prev;
      prev.next = curr;

      if(curr.next != null)
        s.push(curr.next);
      if(curr.child != null) {
        s.push(curr.child);
        curr.child = null;
      }

      prev = curr;
    }
    dummy.next.prev = null;
    return dummy.next;
  }
  public static void main(String[] args) {

  }
}
