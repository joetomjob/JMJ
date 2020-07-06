package LeetCode.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {
  public List<String> generateParenthesis(int n) {
    List<String> res = new ArrayList<>();
    helper(new char[2*n], 0, res);
    return res;
  }

  public void helper(char[] current, int pos, List<String> res) {
    if(pos == current.length) {
      if(isValid(current)) {
        res.add(new String(current));
      }
    } else {
      current[pos] = '(';
      helper(current, pos+1, res);
      current[pos] = ')';
      helper(current, pos+1, res);
    }
  }

  // if count < 0 any time, then it is invalid. if count != 0 at end of for loop, it is invalid
  public boolean isValid(char[] current) {
    int count = 0;
    for (char c : current) {
      if(c == '(') count++;
      else count--;
      if(count < 0) return false;
    }
    return count == 0;
  }

  // better algorithm
  public List<String> generateParenthesisNew(int n) {
    List<String> res = new ArrayList<>();
    backTrack(res, "", 0, 0, n);
    return res;
  }

  public void backTrack(List<String>res, String current, int open, int closed, int max) {
     if(current.length() == max*2) {
      res.add(current);
    }

    if(open < max) // add '(' if there is atleast one place remaining
      backTrack(res, current+'(', open+1, closed, max);
    if(closed < open)
      backTrack(res, current+')', open, closed+1, max);
  }

  public static void main(String[] args) {
    GenerateParanthesis g = new GenerateParanthesis();
    List<String> res = g.generateParenthesis(3);
    for (int i = 0; i < res.size(); i++) {
      System.out.println(res.get(i));
    }

    List<String> res1 = g.generateParenthesisNew(3);
    for (int i = 0; i < res1.size(); i++) {
      System.out.println(res1.get(i));
    }
  }
}
