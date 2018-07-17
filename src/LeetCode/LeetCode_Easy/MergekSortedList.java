package LeetCode.LeetCode_Easy;

import ctci.LinkedList.List;

/**
 * Created by joetomjob on 7/17/18.
 */
public class MergekSortedList {
    public ListNode mergeList(ListNode[] lists){
        if(lists.length == 0)
            return null;
        if(lists.length == 1)
            return lists[0];
        int amount = lists.length;
        int interval = 1;
        while (interval < amount) {
            for (int i = 0; i < amount - interval; i = interval*2) {
                lists[i] = mergetwoList(lists[i], lists[i + interval]);
            }
            interval = interval * 2;
        }
        return lists[0];
    }

    public ListNode mergetwoList(ListNode l1, ListNode l2){
        ListNode head = new ListNode(0);
        ListNode pointer = head;

        while (l1 != null && l2 != null){
            if(l1.val < l2.val) {
                pointer.next = l1;
                l1 = l1.next;
            }
            else{
                pointer.next = l2;
                l2 = l2.next;
            }
            pointer = pointer.next;
        }

        if(l1 != null){
            pointer.next = l1;
        }
        if(l2 != null){
            pointer.next = l2;
        }
        return head.next;
    }

    public static void main(String[] args) {
        int[] x = {1,2,3,4,5,6};

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(5);
        ListNode d = new ListNode(2);
        ListNode e = new ListNode(3);
        ListNode f = new ListNode(4);
        ListNode g = new ListNode(4);
        ListNode h = new ListNode(5);
        ListNode i = new ListNode(6);

        a.next = b;
        b.next = c;
        d.next = e;
        e.next = f;
        g.next = h;
        h.next = i;

        MergekSortedList m = new MergekSortedList();
        ListNode[] l = {a, d, g};
        ListNode res = m.mergeList(l);
        System.out.print(res.val);

    }
}
