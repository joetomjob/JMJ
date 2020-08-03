package LeetCode.LinkedList;

public class AddTwoNumbers {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2){
      if(l1 == null) return l2;
      if(l2 == null) return l1;

      l1 = revList(l1);
      l2 = revList(l2);

      int sum = 0, rem = 0;

      ListNode dummy = new ListNode(-1);
      ListNode temp = dummy;
      while (l1 != null || l2 != null) {
        sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + rem;
        int nodeval = sum % 10;
        rem = sum/10;

        temp.next = new ListNode(nodeval);
        temp = temp.next;

        l1 = l1 != null ? l1.next : null;
        l2 = l2 != null ? l2.next : null;
      }

      if(rem > 0){
        temp.next = new ListNode(rem);
      }

      dummy = revList(dummy.next);
      return dummy;
  }

  public ListNode revList(ListNode node){
    ListNode prev = null;
    while(node != null){
      ListNode temp = node.next;
      node.next = prev;
      prev = node;
      node = temp;
    }
    return prev;
  }

  public static void main(String[] args){
//    ListNode l1 = new ListNode(7, new ListNode(2, new ListNode(4, new ListNode(3))));
//    ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

    ListNode l1 = new ListNode(5);
    ListNode l2 = new ListNode(5);

    AddTwoNumbers a = new AddTwoNumbers();
    ListNode res = a.addTwoNumbers(l1, l2);
    while (res != null) {
      System.out.print(res.val);
      System.out.print("->");
      res = res.next;
    }
  }
}
