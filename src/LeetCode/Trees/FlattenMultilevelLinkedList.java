package LeetCode.Trees;

import java.util.LinkedList;

class Node2 {
  public int val;
  public Node2 prev;
  public Node2 next;
  public Node2 child;

  public Node2() {}

  public Node2(int _val,Node2 _prev,Node2 _next,Node2 _child) {
    val = _val;
    prev = _prev;
    next = _next;
    child = _child;
  }
}

public class FlattenMultilevelLinkedList {
  public Node2 flatten(Node2 head){
    if(head == null) return head;

    Node2 psuedoNode = new Node2(0, null, head, null);
    flattenHelper(psuedoNode, head);

    psuedoNode.next.prev = null;
    return psuedoNode.next;

  }

  public Node2 flattenHelper(Node2 prev, Node2 curr){
    if (curr == null) return prev;

    prev.next = curr;
    curr.prev = prev;

    Node2 tempNode = curr.next;

    Node2 tail = flattenHelper(curr, curr.child);
    curr.child = null;

    return flattenHelper(tail, tempNode);
  }

  public Node2 fattenIterative(Node2 head){
    if(head == null) return head;

    Node2 psuedoNode = new Node2(0, null, head, null);
    Node2 curr, prev = psuedoNode;
    LinkedList<Node2> stack = new LinkedList<>();
    stack.push(head);

    while (!stack.isEmpty()){
      curr = stack.pollLast();

      prev.next = curr;
      curr.prev = prev;

      if(curr.next != null)
        stack.addLast(curr.next);

      if(curr.child != null){
        stack.addLast(curr.child);
        curr.child = null;
      }
      prev = curr;
    }
    psuedoNode.next.prev = null;
    return psuedoNode.next;
  }

  public static void main(String[] args){
    Node2 a = new Node2(1, null, null, null);
    Node2 b = new Node2(2, null, null, null);
    Node2 c = new Node2(3, null, null, null);
    Node2 d = new Node2(4, null, null, null);
    Node2 e = new Node2(5, null, null, null);
    Node2 f = new Node2(6, null, null, null);
    Node2 g = new Node2(7, null, null, null);
    Node2 h = new Node2(8, null, null, null);
    Node2 i = new Node2(9, null, null, null);
    Node2 j = new Node2(10, null, null, null);
    Node2 k = new Node2(11, null, null, null);
    Node2 l = new Node2(12, null, null, null);

    a.next = b; b.prev = a;
    b.next = c; c.prev = b;
    c.next = d; d.prev = c;
    d.next = e; e.prev = d;
    e.next = f; f.prev = e;

    g.next = h; h.prev = g;
    h.next = i; i.prev = h;
    i.next = j; j.prev = i;

    k.next = l; l.prev = k;

    c.child = g;
    h.child = k;

    FlattenMultilevelLinkedList flattenObject = new FlattenMultilevelLinkedList();
    Node2 res = flattenObject.flatten(a);
  }
}
