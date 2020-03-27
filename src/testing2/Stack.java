package testing2;

/**
 * Created by joetomjob on 3/19/20.
 */

public class Stack {
    Node top;

    public void push(int a) {
        Node n = new Node(a);
        if(top == null) {
            top = n;
        } else {
            n.next = top;
            top = n;
        }
    }

    public int pop() {
        if(top != null) {
            int res = top.data;
            top = top.next;
            return res;
        }
        return -1;
    }

    public void printStack(){
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.data);
            System.out.print('\t');
            temp = temp.next;
        }
        System.out.print('\n');
    }

    public boolean isEmpty() {
        if(top != null) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        System.out.println(s.isEmpty());
        s.push(10);
        s.push(13);
        s.push(40);
        s.push(510);
        s.push(14);
        s.push(12);
        s.push(54);
        s.push(89);
        s.printStack();
        s.pop();
        s.pop();
        s.pop();
        s.pop();
        s.printStack();
        System.out.println(s.isEmpty());

    }
}
