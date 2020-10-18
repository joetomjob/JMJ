package LeetCode.LinkedList;

public class RemoveDuplicates {
  public ListNode deleteDuplicates(ListNode head) {
    ListNode temp = head;

    while(temp != null) {
      if(temp.next != null && temp.next.val == temp.val) {
        temp.next = temp.next.next;
      } else {
        temp = temp.next;
      }
    }
    return head;
  }

  public static void main(String[] args){
    ListNode head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
    RemoveDuplicates r = new RemoveDuplicates();
    ListNode res = r.deleteDuplicates(head);
    while (res != null){
      System.out.print(res.val);
      System.out.print('\t');
      res = res.next;
    }
  }
}
