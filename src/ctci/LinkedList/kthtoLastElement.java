package ctci.LinkedList;

import java.util.ArrayList;

/**
 * Created by joetomjob on 7/15/17.
 */
public class kthtoLastElement {
    public int kthtoLastElement(List newList, int k) {
        int counter =0;
        counter = sizeofList(newList);
        Node n = newList.head;
        for (int i = 0; i < counter - k; i++) {
            n = n.next;
        }
        return n.a;
    }

    public int sizeofList(List newList){
        int counter = 0;
        Node n = newList.head;
        while (n != null){
            n = n.next;
            counter++;
        }
        return counter;
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(2);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(3);
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
        kthtoLastElement r = new kthtoLastElement();
        int siz = r.sizeofList(newList);
        System.out.println(siz);
        int res = r.kthtoLastElement(newList, 3);
        System.out.println(res);

    }
}
