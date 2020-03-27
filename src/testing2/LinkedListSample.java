package testing2;

/**
 * Created by joetomjob on 3/18/20.
 */
class Node {
    int data;
    Node next;

    Node(int a) {
        this.data = a;
    }
}
public class LinkedListSample {
    Node head;
    Node tail;

    public void addToLast(int a) {
        Node n = new Node(a);
        if(tail == null) {
            head = n;
            tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
    }

    public void addToFirst(int a) {
        Node n = new Node(a);
        if(tail == null) {
            head = n;
            tail = n;
        } else {
            n.next = head;
            head = n;
        }
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            System.out.print('\t');
            temp = temp.next;
        }
        System.out.print('\n');
    }

    public int removeFirstFromList() {
        if(head != null) {
            int res = head.data;
            head = head.next;
            return res;
        } else {
            return -1;
        }
    }

    public int removeFromList(int a) {
        Node temp = head;
        Node prev = head;
        while (temp != null) {
            if(temp.data == a) {
                prev.next = temp.next;
                return a;
            }
            prev = temp;
            temp = temp.next;
        }
        return -1;
    }

    public boolean isEmpty(){
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean insert(int a, int index) {
        Node temp = head;
        int x = 0;
        while (temp != null && x < index) {
            temp = temp.next;
            x++;
        }
        if(temp != null) {
            Node n = new Node(a);
            n.next = temp.next;
            temp.next = n;
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        LinkedListSample l = new LinkedListSample();
        System.out.println(l.isEmpty());
        l.addToLast(3);
        l.addToLast(10);
        l.addToLast(1);
        l.addToFirst(11);
        l.addToLast(902);
        l.addToLast(67);
        l.addToLast(21);
        l.printList();
        System.out.println(l.removeFirstFromList());
        l.printList();
        System.out.println(l.removeFromList(67));
        l.printList();
        System.out.println(l.isEmpty());
        System.out.println(l.insert(43, 2));
        l.printList();
        System.out.println(l.insert(101, 8));
    }
}
