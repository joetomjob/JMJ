package LeetCode.Others;

import java.util.*;

public class MinStack {
  Stack<Integer> stack;
  List<Integer> minL;
  public MinStack() {
    stack = new Stack<>();
    minL = new ArrayList();
  }

  public void push(int x) {
    stack.push(x);
    if(minL.isEmpty() || x <= minL.get(minL.size()-1)){
      minL.add(x);
    }
  }

  public void pop() {
    if(stack.peek().equals(minL.get(minL.size()-1)))
      minL.remove(minL.size()-1);
    stack.pop();

  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return minL.get(minL.size()-1);
  }

  public static void main(String[] args){
    MinStack m = new MinStack();
    m.push(512);
    m.push(-1024);
    m.push(-1024);
    m.push(512);
    m.pop();
    System.out.println(m.getMin());
    m.pop();
    System.out.println(m.getMin());
    m.pop();
    System.out.println(m.getMin());
  }
}
