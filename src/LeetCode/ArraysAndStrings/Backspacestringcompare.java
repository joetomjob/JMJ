package LeetCode.ArraysAndStrings;

import java.util.Stack;

public class Backspacestringcompare {
  public boolean backspaceCompare(String S, String T) {
    return build(S).equals(build(T));
  }

  public String build(String s){
    Stack<Character> stack = new Stack();
    for (Character c : s.toCharArray()) {
      if (c != '#')
        stack.push(c);
      else if (!stack.isEmpty())
        stack.pop();
    }
    return String.valueOf(stack);
  }

  // better solution. two pointer approach
  public boolean backspacecompare2(String S, String T) {
    int i = S.length() - 1;
    int j = T.length() - 1;
    int skipS = 0, skipT = 0;

    while(i >= 0 || j >= 0) {
      while (i >= 0) {
        if (S.charAt(i) == '#') {skipS++; i--;}
        else if(skipS > 0) { skipS--; i--;}
        else break;
      }

      while (j >= 0) {
        if (T.charAt(j) == '#') {skipT++; j--;}
        else if(skipT > 0) { skipT--; j--;}
        else break;
      }

      if(i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)){
        return false;
      }

      // if char compared with nothing
      if(i >= 0 != j >= 0) return false; // can be written as (i != 0 || j != 0)

      i--; j--;
    }

    return true;
  }

  public static void main(String[] args) {
    Backspacestringcompare b = new Backspacestringcompare();
//    System.out.print(b.backspaceCompare("ab#c", "ad#c"));
    System.out.print(b.backspacecompare2("ab#c", "ad#c"));
  }
}
