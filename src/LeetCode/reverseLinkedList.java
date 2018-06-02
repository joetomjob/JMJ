package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joetomjob on 2/25/18.
 */

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

public class reverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode previous = null;

        while(current != null){
            ListNode temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }

        return current;
    }

    public static void main(String[] args) {
        reverseLinkedList r = new reverseLinkedList();
        ListNode l = new ListNode(1);
//        l.next = new ListNode(2);
//        l.next.next = new ListNode(3);
//        l.next.next.next = new ListNode(4);

        r.reverseList(l);

    }


}
