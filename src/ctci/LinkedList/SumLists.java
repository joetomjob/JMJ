package ctci.LinkedList;

/**
 * Created by joetomjob on 6/2/18.
 */
public class SumLists {

    private void addLists(List newList, List newList1){
        List sumList = new List();
        Node sm = null;

        reverseList(newList);
        reverseList(newList1);

        int carry = 0;

        Node a = newList.head;
        Node b = newList1.head;
        int s = 0;

        while (a != null || b != null){
            s = 0;
            if (a != null){
                s += a.a;
                a = a.next;
            }
            if (b != null){
                s += b.a;
                b = b.next;
            }

            s+=carry;
            if(s > 9){
                carry = s/10;
                s = s%10;
            }
            else
                carry = 0;

            Node n = new Node(s);
            if(sm != null)
                sm.next = n;
            else
                sumList.head = n;
            sm = n;
        }
        if(carry > 0){
            Node k = new Node(carry);
            sm.next = k;
            sm = k;
        }

        reverseList(sumList);
        sumList.printList();
    }

    private void reverseList(List newList){
        Node a = newList.head;
        Node pre = null;

        while (a!=null){
            Node n = a.next;
            a.next = pre;
            pre = a;
            a = n;
        }

        newList.head = pre;
    }

    public static void main(String[] args) {
        Node a = new Node(6);
        Node b = new Node(1);
        Node c = new Node(7);
        Node d = new Node(2);
        Node e = new Node(9);
        Node f = new Node(5);


        List newList = new List();
        newList.addLast(a);
        newList.addLast(b);
        newList.addLast(c);

        List newList1 = new List();
        newList1.addLast(d);
        newList1.addLast(e);
        newList1.addLast(f);

        newList.printList();
        System.out.print('\n');
        newList1.printList();
        System.out.print('\n');

        SumLists r = new SumLists();
        r.addLists(newList, newList1);
    }
}
