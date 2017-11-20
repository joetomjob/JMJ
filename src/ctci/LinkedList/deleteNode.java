package ctci.LinkedList;

/**
 * Created by joetomjob on 7/16/17.
 */
public class deleteNode {

    public void deleteNode(Node n){
        Node temp = n.next;
        n.a = temp.a;
        n.next = temp.next;

    }
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(6);
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
        deleteNode r = new deleteNode();
        r.deleteNode(a);
        newList.printList();

    }
}
