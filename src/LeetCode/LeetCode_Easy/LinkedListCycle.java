package LeetCode.LeetCode_Easy;

/**
 * Created by joetomjob on 6/21/18.
 */
public class LinkedListCycle {
    static ListNode a;
    static ListNode b;
    static ListNode c;
    static ListNode d;
    static ListNode e;

    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }

        ListNode f = head;
        ListNode s = head;
        while (f.next != null && f.next.next != null){
            f = f.next.next;
            s = s.next;
            if(s.val == f.val){
                return true;
            }
        }
        return false;
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
