package testing2;

/**
 * Created by joetomjob on 3/19/20.
 */
public class Queue {
    Node head;
    Node tail;

    public void enqueue(int a) {
        Node n = new Node(a);
        if(head == null) {
            head = n;
            tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
    }

    public int dequeue() {
        if(head == null) {
            return -1;
        } else {
            int res = head.data;
            head = head.next;
            return res;
        }
    }

    public boolean isEmpty() {
        if(head == null) {
            return true;
        }
        return false;
    }

    public void printQueue() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            System.out.print('\t');
            temp = temp.next;
        }
        System.out.print('\n');
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        System.out.println(q.isEmpty());
        q.enqueue(4);
        q.enqueue(14);
        q.enqueue(42);
        q.enqueue(234);
        q.enqueue(443);
        q.enqueue(1);
        q.printQueue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.printQueue();
        System.out.println(q.isEmpty());
    }
}
