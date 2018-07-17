package LeetCode.LeetCode_Easy;

import java.util.HashMap;

/**
 * Created by joetomjob on 7/17/18.
 */
public class IntersectionLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode,Integer> map = new HashMap<ListNode,Integer>();
        ListNode first = headA;
        ListNode second = headB;
        while(first != null){
            map.put(first,1);
            first = first.next;
        }
        while(second != null){
            if(map.containsKey(second))
                return second;
            second = second.next;
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);

        a.next = b;
        c.next = d;
        b.next = e;
        d.next = e;

        IntersectionLinkedList p = new IntersectionLinkedList();
        p.getIntersectionNode(a,c);
    }
}
