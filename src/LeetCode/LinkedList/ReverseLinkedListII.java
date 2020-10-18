package LeetCode.LinkedList;

public class ReverseLinkedListII {

  public ListNode reverseBetween(ListNode head, int m, int n) {
    ListNode dummy = new ListNode(-1, head);
    ListNode prev = dummy;
    int count = 1;

    while(count < m) {
      prev = head;
      head = head.next;
      count++;
    }

    ListNode temp = head;
    ListNode prev2 = null;

    while (count <= n) {
      ListNode x = head.next;
      head.next = prev2;
      prev2 = head;
      head = x;
      count++;
    }

    temp.next = head;
    prev.next = prev2;

    return dummy.next;
  }

  public static void main(String[] args){

  }
}
