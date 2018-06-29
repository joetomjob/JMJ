package LeetCode.LeetCode_Easy;

import ctci.LinkedList.List;

/**
 * Created by joetomjob on 6/21/18.
 */
public class MergeTwoSortedLists {
    static ListNode a;
    static ListNode b;
    static ListNode c;
    static ListNode d;
    static ListNode e;

    static ListNode f;
    static ListNode g;
    static ListNode h;
    static ListNode i;
    static ListNode j;

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode dummy = head;
        ListNode f = l1;
        ListNode s = l2;

        while (f != null && s != null){
            if(f.val < s.val){
                dummy.next = f;
                dummy = f;
                f = f.next;
            }
            else {
                dummy.next = s;
                dummy = s;
                s = s.next;
            }
        }
        while (f != null){
            dummy.next = f;
            dummy = f;
            f = f.next;
        }
        while (s != null){
            dummy.next = s;
            dummy = s;
            s = s.next;
        }
        return head.next;
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

        f = new ListNode(2);
        g = new ListNode(3);
        h = new ListNode(3);
        i = new ListNode(7);
        j = new ListNode(8);

        f.next = g;
        g.next = h;
        h.next = i;
        i.next = j;

        MergeTwoSortedLists m = new MergeTwoSortedLists();
        ListNode l = m.mergeTwoLists(a,f);
        System.out.println(l.val);

    }
}
