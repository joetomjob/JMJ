package LeetCode.LinkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CopyListRandomPointer {
  static class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }

  public Node copyRandomList(Node head){
    if(head == null) return null;

    Node temp = head;
    Map<Node, Node> map = new HashMap<>();

    while (temp != null){
      Node newNode = new Node(temp.val);
      map.put(temp, newNode);
      temp = temp.next;
    }

    temp = head;
    while (temp != null){
      map.get(temp).next = temp.next != null ? map.get(temp.next) : null;
      map.get(temp).random = temp.random != null ? map.get(temp.random) : null;
      temp = temp.next;
    }

    return map.get(head);
  }

  public static void main(String[] args){
    Node n1 = new Node(7);
    Node n2 = new Node(13);
    Node n3 = new Node(11);
    Node n4 = new Node(10);
    Node n5 = new Node(1);

    n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n5.next = null;
    n1.random = null; n2.random = n1; n3.random = n5; n4.random = n3; n5.random = n1;

    CopyListRandomPointer c = new CopyListRandomPointer();
    Node res = c.copyRandomList(n1);int a = 0;

  }
}
