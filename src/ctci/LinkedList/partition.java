package ctci.LinkedList;

public class partition {
    public void partition(List newList, int k){
        List l1 = new List();
        List l2 = new List();

        Node n = newList.head;
        while(n != null){
            Node r = new Node(n.a);
            if(n.a < k){
                l1.addLast(r);
            }
            else{
                l2.addLast(r);
            }
            n= n.next;
        }
        l1.tail.next = l2.head;
        l1.printList();
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
        newList.addFirst(d);
        newList.addFirst(e);
        newList.addFirst(f);
        newList.addLast(a);
        newList.addLast(b);
        newList.insert(c, 2);

        newList.printList();
        System.out.print('\n');
        partition r = new partition();
        r.partition(newList,4);
        int[] z = {1,2,3};
        
    }
}
