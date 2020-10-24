package LeetCode.LinkedList;

public class MiddleOfLinkedList {
  public ListNode middleNode(ListNode head) {
    ListNode tmp1 = head, tmp2 = head;
    while (tmp2 != null && tmp2.next != null) {
      tmp1 = tmp1.next;
      tmp2 = tmp2.next.next;
    }
    return tmp1;
  }

  public static void main(String[] args) {
    ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
    ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

    MiddleOfLinkedList m = new MiddleOfLinkedList();
    System.out.println(m.middleNode(head1).val);
    System.out.println(m.middleNode(head2).val);
  }
}
