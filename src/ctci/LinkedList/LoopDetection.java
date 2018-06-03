package ctci.LinkedList;

/**
 * Created by joetomjob on 6/2/18.
 */
public class LoopDetection {

    private boolean detectLoop(List l){
        Node a = l.head;

        Node s = a;
        Node f = a;
        while (f !=null && f.next != null){
            s = s.next;
            f = f.next.next;

            if(s == f){
                return true;
            }
        }
        return false;
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
        newList.addLast(a);
        newList.addLast(b);
        newList.addLast(c);
        newList.addLast(d);
        newList.addLast(e);
        newList.addLast(f);


//        newList.printList();
//        System.out.print('\n');
        LoopDetection r = new LoopDetection();
        System.out.print(r.detectLoop(newList));
    }
}
