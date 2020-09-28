package LeetCode.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
  // O(n) time and O(n) space
  public boolean hasCycle(ListNode head){
    Set<ListNode> set = new HashSet<>();
    ListNode temp = head;
    while (temp != null) {
      if(set.contains(temp)) return true;
      set.add(temp);
      temp = temp.next;
    }
    return false;
  }

  // slow and fast pointer approach
  public boolean hasCycleII(ListNode head){
    if(head == null || head.next == null) return false;
    ListNode first = head;
    ListNode second = head.next;
    while (first != null && second != null && second.next != null){
      if(first == second) return true;
      first = first.next;
      second = second.next.next;
    }
    return false;
  }

  public static void main(String[] args){

  }
}
