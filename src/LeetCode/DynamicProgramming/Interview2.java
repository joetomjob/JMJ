package LeetCode.DynamicProgramming;

import java.util.Collections;
import java.util.HashSet;

public class Interview2 {
  static HashSet<String> set = new HashSet<>();
  public boolean isPeriodic(String s){
    return checkPeriodic(s, 0, new Boolean[s.length()]);
  }

  public boolean checkPeriodic(String s, int i, Boolean[] mem){
    if(i == s.length()) return true;

    if(mem[i] != null) return mem[i];

    if(set.contains(s.substring(i, i+1).toUpperCase()) && checkPeriodic(s, i+1, mem)){
      mem[i] = true;
      return true;
    }

    if(i+2 <= s.length() && set.contains(s.substring(i, i+2).toUpperCase()) && checkPeriodic(s, i+2, mem)){
      mem[i] = true;
      return true;
    }

    mem[i] = false;
    return false;
  }
  public static void main(String[] args){
    Collections.addAll(set, "S", "O", "H" , "AS", "I", "IR", "P", "K");
    Interview2 i = new Interview2();
    System.out.println(i.isPeriodic("SHASHIR"));
  }
}
