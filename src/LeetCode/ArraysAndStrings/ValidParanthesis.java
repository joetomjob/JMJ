package LeetCode.ArraysAndStrings;

import java.util.HashMap;
import java.util.Stack;

public class ValidParanthesis {

  public boolean isValidfirst(String s) {
    HashMap<Character, Character> map = new HashMap<>();
    map.put(')', '(');
    map.put(']', '[');
    map.put('}', '{');
    Stack<Character> stack = new Stack<>();
    for(char c : s.toCharArray()) {
      if(c == '(' || c == '[' || c == '{')
        stack.push(c);
      else if(c == ')' || c == ']' || c == '}') {
        char topElement = stack.isEmpty() ? '#' : stack.pop();
        if (topElement != map.get(c))
          return false;
      }
    }
    return stack.size() == 0;
  }

  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for(char c : s.toCharArray()) {
      if(c == '(')
        stack.push(')');
      else if(c == '{')
        stack.push('}');
      else if(c == '[')
        stack.push(']');
      else if (stack.isEmpty() || stack.pop() != c)
        return false;
    }
    return stack.isEmpty();
  }


  public static void main(String[] args) {
    ValidParanthesis v = new ValidParanthesis();
    System.out.println(v.isValid("{([)]"));
    System.out.println(v.isValidfirst("()[]{}"));
  }
}

