package LeetCode.Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class letterCombinationsOfPhoneNumber {
  HashMap<String, String> map = new HashMap<>(){{
    put("2", "abc");
    put("3", "def");
    put("4", "ghi");
    put("5", "jkl");
    put("6", "mno");
    put("7", "pqrs");
    put("8", "tuv");
    put("9", "wxyz");
  }};
  List<String> output = new ArrayList<>();

  public List<String> letterCombinations(String digits) {
    if(digits.length() > 0)
      buildCombinations("", digits);
    return output;
  }

  public void buildCombinations(String combined, String rem_digits) {
    if(rem_digits.length() == 0) {
      output.add(combined);
    } else {
      String digit = rem_digits.substring(0, 1);
      String letters = map.get(digit);
      for(int i = 0; i < letters.length(); i++) {
        String letter = letters.substring(i, i+1);
        buildCombinations(combined + letter, rem_digits.substring(1));
      }
    }
  }
  public static void main(String[] args) {
    letterCombinationsOfPhoneNumber l = new letterCombinationsOfPhoneNumber();
    List<String> res = l.letterCombinations("23");
    for (int i = 0; i < res.size(); i++) {
      System.out.println(res.get(i));
    }
  }
}
