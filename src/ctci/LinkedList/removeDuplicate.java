package ctci.LinkedList;

import java.util.HashSet;

/**
 * Created by joetomjob on 7/15/17.
 */
public class removeDuplicate {

    public void removeDuplicate(List newList) {
        HashSet<Integer> h = new HashSet<>();
        Node n = newList.head;
        Node prev = n;
        while (n != null) {
            if (h.contains(n.a)) {
                prev.next = n.next;
            }
            h.add(n.a);
            prev = n;
            n = n.next;
        }
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(2);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(1);
        Node g = new Node(7);
        Node h = new Node(8);
        Node i = new Node(9);

        List newList = new List();
        newList.addFirst(a);
        newList.addFirst(b);
        newList.addFirst(c);
        newList.addLast(d);
        newList.addLast(e);
        newList.insert(f, 2);

        newList.printList();
        System.out.print('\n');
        removeDuplicate r = new removeDuplicate();
        r.removeDuplicate(newList);
        newList.printList();

    }
}
