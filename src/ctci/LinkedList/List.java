package ctci.LinkedList;

/**
 * Created by joetomjob on 7/15/17.
 */

class Node {
    int a;
    Node next;
    Node prev;

    Node(int a) {
        this.a = a;
    }
}

public class List {
    Node head;
    Node tail;

    public void addLast(Node a) {
        if (head == null) {
            head = a;
            tail = a;
        } else {
            tail.next = a;
            tail = a;
        }
    }

    public void addFirst(Node a) {
        if (head == null) {
            head = a;
            tail = a;
        } else {
            a.next = head;
            head = a;
        }
    }

    public void removeFirst() {
        head = head.next;
    }

    public void insert(Node a, int k) {
        Node n = head;
        for (int i = 0; i < k; i++) {
            n = n.next;
        }
        a.next = n.next;
        n.next = a;
    }

    public void printList() {
        Node n = head;
        while (n != null) {
            System.out.print(n.a);
            System.out.print('\t');
            n = n.next;
        }
    }

    public void deleteNode(int a) {
        Node n = head;
        if (n.a == a) {
            head = n.next;
        } else {
            while(n.next!=null){
                if(n.next.a == a){
                    n.next = n.next.next;
                }
                n = n.next;
            }
        }
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
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
        newList.deleteNode(3);
        System.out.print('\n');
        newList.printList();
        System.out.print('\n');
        newList.deleteNode(6);
        newList.printList();
    }
}
