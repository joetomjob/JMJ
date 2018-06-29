package LeetCode.LeetCode_Easy;

/**
 * Created by joetomjob on 6/21/18.
 */
public class RemoveNthNode {
    static ListNode a;
    static ListNode b;
    static ListNode c;
    static ListNode d;
    static ListNode e;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode f = dummy;
        ListNode s = dummy;

        for (int i = 0; i <= n; i++)
            f = f.next;
        while (f != null){
            f = f.next;
            s = s.next;
        }
        s.next = s.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        a = new ListNode(1);
        b = new ListNode(2);
        c = new ListNode(3);
        d = new ListNode(4);
        e = new ListNode(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        RemoveNthNode r = new RemoveNthNode();
        System.out.println(r.removeNthFromEnd(a, 2).val);
    }
}
