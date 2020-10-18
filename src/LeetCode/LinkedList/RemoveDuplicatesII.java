package LeetCode.LinkedList;

public class RemoveDuplicatesII {
  public ListNode deleteDuplicates(ListNode head) {
    ListNode prev = new ListNode(-1, head);
    ListNode dummy = prev, temp = head;

    while(temp != null) {
      while(temp.next != null && temp.next.val == temp.val) {
        temp = temp.next;
      }
      if(prev.next != temp) {
        prev.next = temp.next;
      }  else {
        prev = prev.next;
      }
      temp = temp.next;
    }
    return dummy.next;
  }

  //1-2-3-3-4-4-5

  public static void main(String[] args){
    ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
    ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7)))))));
    RemoveDuplicatesII r = new RemoveDuplicatesII();
    ListNode res = r.deleteDuplicates(head);
    while(res!=null) {
      System.out.print(res.val);
      System.out.print('\t');
      res = res.next;
    }
  }
}
