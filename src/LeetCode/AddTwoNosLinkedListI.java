package LeetCode;

import ctci.LinkedList.List;

/**
 * Created by joetomjob on 2/25/18.
 */
public class AddTwoNosLinkedListI {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode x = l1, y=l2,curr=result;
        int carry = 0;
        while (x!=null || y!=null){
            int a = (x!=null)?x.val:0;
            int b = (y!=null)?y.val:0;

            int sum = a+b+carry;
            int t = sum%10;
            carry = sum/10;

            curr.next = new ListNode(t);
            if(x!=null) x=x.next;
            if(y!=null) y=y.next;

            curr = curr.next;

        }

        if(carry>0){
            curr.next = new ListNode(carry);
        }
        return result.next;
    }

    public static void main(String[] args) {
        AddTwoNosLinkedListI a = new AddTwoNosLinkedListI();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        a.addTwoNumbers(l1,l2);
    }
}
