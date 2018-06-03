package ctci.LinkedList;

/**
 * Created by joetomjob on 6/2/18.
 */
public class intersection {
    private boolean checkIntersection(List l1, List l2){
        Node a = l1.head;
        Node b = l2.head;

        while (a.next != null)
            a = a.next;

        while (b.next != null)
            b = b.next;

        if (a == b)
            return true;

        return false;
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
        newList.addLast(e) ;
        newList.addLast(f);

        List newList1 = new List();
        newList1.addLast(d);
        newList1.addLast(e);
        newList1.addLast(f);

        newList.printList();
        System.out.print('\n');
        newList1.printList();
        System.out.print('\n');

        intersection r = new intersection();
        System.out.print(r.checkIntersection(newList, newList1));
    }
}
