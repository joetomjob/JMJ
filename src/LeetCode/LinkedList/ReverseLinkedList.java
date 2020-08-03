package LeetCode.LinkedList;

public class ReverseLinkedList {
  public ListNode reverseList(ListNode head){
    ListNode prev = null;
    while (head != null){
      ListNode temp = head.next;
      head.next = prev;
      prev = head;
      head = temp;
    }
    return prev;
  }


  public static void main(String[] args){
    ReverseLinkedList r = new ReverseLinkedList();
    ListNode l = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    ListNode rev = r.reverseList(l);
    while (rev != null) {
      System.out.print(rev.val);
      System.out.print('\t');
      rev = rev.next;
    }
  }
}
