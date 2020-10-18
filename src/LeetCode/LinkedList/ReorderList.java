package LeetCode.LinkedList;

import ctci.LinkedList.List;

import java.util.ArrayList;

public class ReorderList {
  public void reorderList(ListNode head) {
    if(head == null || head.next == null) return;
    ListNode temp = head;
    ArrayList<ListNode> list = new ArrayList();
    while(temp != null){
      list.add(temp);
      temp = temp.next;
    }
    int cnt = 0, listLen = list.size();
    temp = head;
    while (cnt < listLen/2){
      cnt++;
      temp.next = list.get(listLen-cnt);
      temp = temp.next;
      if(cnt != listLen-cnt) {
        temp.next = list.get(cnt);
        temp = temp.next;
      }
    }
    temp.next = null;
  }

  public static void main(String[] args){
    ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    ReorderList r = new ReorderList();
    r.reorderList(head);
  }
}
