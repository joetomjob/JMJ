package LeetCode;

/**
 * Created by joetomjob on 2/26/18.
 */
public class AddTwoNosII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = this.reverseLinkedLst(l1);
        l2 = this.reverseLinkedLst(l2);

        ListNode res = new ListNode(0);
        int carry = 0;
        ListNode x = l1, y=l2, curr = res;
        while(x!=null || y!=null){
            int a = x!=null?x.val:0;
            int b = y!=null?y.val:0;

            int t = a+b+carry;
            carry = t/10;
            t = t%10;

            curr.next = new ListNode(t);
            curr = curr.next;

            if(x!=null) x = x.next;
            if(y!=null) y = y.next;
        }

        if(carry !=0){
            curr.next = new ListNode(carry);
        }

        res = this.reverseLinkedLst(res.next);
        return res;

    }

    public ListNode reverseLinkedLst(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        AddTwoNosII a = new AddTwoNosII();
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode k = a.addTwoNumbers(l1,l2);
        System.out.println(k);
    }

}
