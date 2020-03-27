package ctci.StackQueue;

import java.util.Stack;

/**
 * Created by joetomjob on 8/3/19.
 */
public class MyQueue {
    Stack<Integer> stackNew, stackOld;

    MyQueue(){
        stackNew = new Stack<Integer>();
        stackOld = new Stack<Integer>();
    }

    public void push(int a){
        stackNew.push(a);
    }

    public int peek() {
        shiftStack();
        return stackOld.peek();
    }

    public int pop() {
        shiftStack();
        return stackOld.pop();
    }

    public void shiftStack(){
        if(stackOld.isEmpty()) {
            while (!stackNew.isEmpty()) {
                stackOld.push(stackNew.pop());
            }
        }
    }

    public static void main(String[] args) {
        MyQueue m = new MyQueue();
        m.push(2);
        m.push(3);
        m.push(4);
        System.out.println(m.peek());
        m.push(5);
        m.push(6);
        m.push(7);
        System.out.println(m.peek());
        m.push(8);
        System.out.println(m.pop());
        m.push(9);
        m.push(10);
    }
}
