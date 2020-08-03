package LeetCode.ArraysAndStrings;

import java.util.Stack;

public class ValidateStack {
  public boolean validateStackSequences(int[] pushed, int[] popped){
    if(pushed.length != popped.length) return false;

    int i = 0;
    Stack<Integer> stack = new Stack<>();

    for(int n : pushed){
      stack.push(n);
      while (!stack.isEmpty() && i < pushed.length && stack.peek() == popped[i]){
        stack.pop();
        i++;
      }
    }
    return i == pushed.length;
  }
  public static void main(String[] args){
    int[] pushed = {2,1,0};
    int[] popped = {1,2,0};
    ValidateStack v = new ValidateStack();
    System.out.println(v.validateStackSequences(pushed, popped));
  }
}
