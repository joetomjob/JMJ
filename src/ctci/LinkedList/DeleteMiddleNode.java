package ctci.LinkedList;

/**
 * Created by joetomjob on 6/2/18.
 */
public class DeleteMiddleNode {

    private void deleteMidNode(List newList){
        int sze = sizeofList(newList);
        int md;
        if(sze%2 == 0)
            md = sze/2-1;
        else
            md = sze/2;
        Node a = newList.head;
        Node pr = a;
        for(int i = 0; i< md; i++){
            pr = a;
            a = a.next;
        }
        pr.next = a.next;
    }

    private int sizeofList(List newList){
        Node a = newList.head;
        int cnt = 0;
        while (a != null){
            cnt++;
            a = a.next;
        }
        return cnt;

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
        DeleteMiddleNode r = new DeleteMiddleNode();
        r.deleteMidNode(newList);
        newList.printList();

    }
}
