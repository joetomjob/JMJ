package LeetCode.Trees;

class ListNode {
  int val;
  ListNode next;
  ListNode(int x) {
    val = x;
    next = null;
  }
  ListNode(int x, ListNode next) {
    this.val = x;
    this.next = next;
  }
 }
public class intersectionOfLinkedList {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if(headA == null || headB == null) {
      return null;
    }
    ListNode t1 = headA;
    ListNode t2 = headB;
    while (t1.next != null) {
      t1 = t1.next;
    }
    while (t2.next != null) {
      t2 = t2.next;
    }
    if(t1 != t2) {
      return null;
    }

    ListNode p1 = headA;
    ListNode p2 = headB;
    while (p1!=p2){
      p1 = p1 == null ? headA : p1.next;
      p2 = p2 == null ? headB : p2.next;
    }
    return p1;
  }

  //best solution
  public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
    ListNode a = headA;
    ListNode b = headB;

    while (a != b) {
      a = a == null ? headB : a.next;
      b = b == null ? headA : b.next;
    }
    return a;
  }

  public static void main(String[] args) {
    ListNode n1 = new ListNode(8);
    ListNode n2 = new ListNode(4);
    ListNode n3 = new ListNode(5);
    n1.next = n2;
    n2.next = n3;
    ListNode l1 = new ListNode(2, new ListNode(6, new ListNode(4)));
    ListNode l2 = new ListNode(1, new ListNode(5));
    intersectionOfLinkedList i = new intersectionOfLinkedList();
    ListNode l = i.getIntersectionNode(l1, l2);
    if(l != null) {
      System.out.println(l.val);
    }

    ListNode res = i.getIntersectionNode2(l1, l2);
    if(l != null) {
      System.out.println(l.val);
    }
  }
}
