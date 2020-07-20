package LeetCode.ArraysAndStrings;

import LeetCode.LeetCode_Easy.MergekSortedList;

import java.util.PriorityQueue;

class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) {
    this.val = val;
  }
  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}
public class MergekSortedLists {
  public ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<Integer> p = new PriorityQueue<>();
    for(ListNode l : lists) {
      while (l!=null){
        p.add(l.val);
        l = l.next;
      }
    }

    ListNode d = new ListNode(-1);
    ListNode n = d;

    while (!p.isEmpty()) {
      n.next = new ListNode(p.remove());
      n = n.next;
    }

    return d.next;
  }

  // better solution as space complexity is O(1)
  public ListNode mergeKLists2(ListNode[] lists) {
    if(lists.length == 0)
      return null;

    int interval = 1;
    while(interval < lists.length){
      for (int i = 0; i < lists.length - interval; i += 2*interval) {
        merge(lists, i, i+interval);
      }
      interval = interval*2;
    }

    return lists[0];
  }

  public void merge(ListNode[] lists, int index1, int index2) {
    ListNode dummy = new ListNode(-1);
    ListNode ans = dummy;

    ListNode l1 = lists[index1];
    ListNode l2 = lists[index2];

    while (l1 != null && l2 != null){
      if (l1.val < l2.val) {
        ans.next = l1;
        l1 = l1.next;
      } else {
        ans.next = l2;
        l2 = l2.next;
      }
      ans = ans.next;
    }
    if (l2 != null) {
      ans.next = l2;
    }
    if (l1 != null) {
      ans.next = l1;
    }
    lists[index1] = dummy.next;
  }
  public static void main(String[] args){
    MergekSortedLists m = new MergekSortedLists();
    ListNode a = new ListNode(1, new ListNode(4, new ListNode(5)));
    ListNode b = new ListNode(1, new ListNode(3, new ListNode(4)));
    ListNode c = new ListNode(2, new ListNode(6));
    ListNode[] l = {a, b, c};
    ListNode res = m.mergeKLists2(l);
    while (res!=null) {
      System.out.print(res.val);
      System.out.print("->");
      res = res.next;
    }
  }
}
