package LeetCode.BloombergPractice;

public class AddTwoNos {
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if(l1 == null) return l2;
    if(l2 == null) return l1;

    l1 = revList(l1);
    l2 = revList(l1);
    ListNode res = new ListNode();
    ListNode dummy = res;
    int rem = 0, val;

    while (l1 != null || l2 != null) {
      int t = (l1 != null? l1.val : 0) + (l2 != null ? l2.val : 0) + rem;
      rem = t/10;
      val = t%10;

      res.next = new ListNode(val);
      res = res.next;

      l1 = l1 != null? l1.next: null;
      l2 = l2 != null? l2.next: null;
    }

    res = revList(dummy.next);
    return res;
  }

  public ListNode revList(ListNode l){
    ListNode prev = null;
    while (l != null) {
      ListNode temp = l.next;
      l.next = prev;
      prev = l;
      l = temp;
    }

    return prev;
  }
  public static void main(String[] args) {

  }
}
