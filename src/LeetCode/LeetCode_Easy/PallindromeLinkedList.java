package LeetCode.LeetCode_Easy;

import ctci.LinkedList.List;

/**
 * Created by joetomjob on 6/21/18.
 */
public class PallindromeLinkedList {
    static ListNode a;
    static ListNode b;
    static ListNode c;
    static ListNode d;
    static ListNode e;

    public boolean isPalindrome(ListNode head) {
        ListNode revHead = reverseLinkedList(head);
        while (head != null){
            if(head.val != revHead.val)
                return false;
            revHead = revHead.next;
            head = head.next;
        }
        return true;
    }

    public ListNode reverseLinkedList(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null){
            ListNode temp = new ListNode(curr.val);
            temp.next = prev;
            prev = temp;
            curr = curr.next;
        }
        return prev;
    }

    public static void main(String[] args) {
        a = new ListNode(1);
        b = new ListNode(2);
        c = new ListNode(2);
        d = new ListNode(4);
        e = new ListNode(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        PallindromeLinkedList p = new PallindromeLinkedList();
        p.isPalindrome(a);

    }
}
