package LeetCode.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleII {
  public ListNode detectCycle(ListNode head){
    Set<ListNode> set = new HashSet<ListNode>();
    while (head.next != null){
      if(set.contains(head.next)) return head;
      set.add(head);
      head = head.next;
    }
    return null;
  }
  public static void main(String[] args){
    ListNode n1 = new ListNode(3);
    ListNode n2 = new ListNode(2);
    ListNode n3 = new ListNode(0);
    ListNode n4 = new ListNode(4);

    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n2;

    LinkedListCycleII l= new LinkedListCycleII();
    System.out.println(l.detectCycle(n1).val);
    System.out.println(l.detectCycle(n1).next.val);
  }
}
