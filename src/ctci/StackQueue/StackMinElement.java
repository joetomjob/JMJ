package ctci.StackQueue;

import java.util.Stack;

/**
 * Created by joetomjob on 8/3/19.
 */
public class StackMinElement extends Stack<Integer>{
    Stack<Integer> s2;
    public StackMinElement(){
        s2 = new Stack<Integer>();
    }

    public void push(int val) {
        if(val < min()) {
            s2.push(val);
        }
        super.push(val);
    }

    public Integer pop(){
        int val = super.pop();
        if(val == min()) {
            s2.pop();
        }
        return val;
    }


    public int min(){
        if(s2.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return s2.peek();
        }
    }


    public static void main(String[] args) {
        StackMinElement s = new StackMinElement();
        s.push(10);
        System.out.println(s.peek());
        System.out.println(s.s2.peek());
        s.push(9);
        s.push(11);
        s.push(3);
        System.out.println(s.peek());
        System.out.println(s.s2.peek());
        s.push(7);
        s.push(6);
        System.out.println(s.peek());
        System.out.println(s.s2.peek());
    }
}
