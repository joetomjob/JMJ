package ctci.StackQueue;

import java.util.Stack;

/**
 * Created by joetomjob on 8/3/19.
 */
public class SortStack {
    Stack<Integer> s = new Stack<Integer>();
    Stack<Integer> temp = new Stack<Integer>();

    public void push(int a){
        if (s.isEmpty()) {
            s.push(a);
        } else {
            while(!s.isEmpty() && s.peek() < a) {
                temp.push(s.pop());
            }
            s.push(a);
            while (!temp.isEmpty()){
                s.push(temp.pop());
            }
        }
    }

    public Integer pop() {
        if (!s.isEmpty()) {
            return s.pop();
        } else{
            return null;
        }
    }

    public static void main(String[] args) {
        SortStack s = new SortStack();
        s.push(5);
        s.push(4);
        s.push(10);
        s.push(4);
        s.push(11);
        s.push(2);
        s.push(6);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
