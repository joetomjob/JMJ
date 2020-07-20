package LeetCode.LinkedList;

public class RemoveNthNodeFromEnd {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    int length = lengthLinkedList(head);
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode temp = dummy;

    int k = 0;
    while (k < length-n) {
      temp = temp.next;
      k++;
    }
    temp.next = temp.next != null ? temp.next.next : null;
    return dummy.next;
  }
  // one pass method.
  public ListNode removeNthNode(ListNode head, int n) {
    ListNode res = new ListNode(-1);
    res.next =  head;
    ListNode fast = res, slow = res;

    for(int i=1; i <= n+1; i++) {
      fast = fast.next;
    }

    while (fast != null) {
      fast = fast.next;
      slow = slow.next;
    }
    slow.next = slow.next.next;
    return res.next;
  }

  public int lengthLinkedList(ListNode head){
    int n = 0;
    while(head != null){
      head = head.next;
      n++;
    }
    return n;
  }
  public static void main(String[] args) {
    ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
//    ListNode head = new ListNode(1);
    RemoveNthNodeFromEnd r = new RemoveNthNodeFromEnd();
//    ListNode res = r.removeNthFromEnd(head, 2);
    ListNode res = r.removeNthNode(head, 2);
    while (res != null) {
     System.out.print(res.val);
     System.out.print('\t');
     res = res.next;
    }
  }
}
