package ctci.LinkedList;

/**
 * Created by joetomjob on 6/2/18.
 */
public class Pallindrome {

    private boolean pallindrome(List newList){
        Node rev = reverseListandCopy(newList);
        int sz = sz(newList);

        Node a = newList.head;
        Node b = rev;
        for (int i = 0; i < sz/2; i++) {
            if(a.a != b.a){
                return false;
            }
            a = a.next;
            b = b.next;
        }
        return true;
    }

    private int sz(List newList){
        Node a = newList.head;
        int cnt = 0;
        while (a != null){
            cnt++;
            a = a.next;
        }
        return cnt;
    }
    private Node reverseListandCopy(List newList){
        Node a;

        Node pre = null;
        Node b = newList.head;

        while (b!=null){
            Node n = new Node(b.a);
            a = n;
            a.next = pre;
            pre = a;

            b = b.next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Node a = new Node(6);
        Node b = new Node(1);
        Node c = new Node(7);
        Node d = new Node(7);
        Node e = new Node(1);
        Node f = new Node(6);


        List newList = new List();
        newList.addLast(a);
        newList.addLast(b);
        newList.addLast(c);
        newList.addLast(d);
        newList.addLast(e);
        newList.addLast(f);

        newList.printList();
        System.out.print('\n');

        Pallindrome r = new Pallindrome();
        System.out.print(r.pallindrome(newList));
    }
}
