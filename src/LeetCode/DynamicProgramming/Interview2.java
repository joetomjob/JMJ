package LeetCode.DynamicProgramming;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

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

  // BFS
  public boolean isPeriodicII(String s){
    Queue<Integer> q = new LinkedList<>();
    int[] visited = new int[s.length()];
    q.add(0);
    while(!q.isEmpty()){
      int index = q.poll();
      if(visited[index] == 0){
        for(int i = index+1; i <= s.length() && i <= index+2; i++){
          if(set.contains(s.substring(index, i).toUpperCase())) q.add(i);
          if(i == s.length()) return true;
        }
      }
    }
    return false;
  }

  //dp iterative
  public boolean isPeriodicIII(String s){
    boolean[] dp = new boolean[s.length()+1];
    dp[0] = true;

    for(int i = 1; i <= s.length(); i++){
      for(int j = i - 2; j < i; j++){
        if(j > -1 && dp[j] && set.contains(s.substring(j, i).toUpperCase())){
          dp[i] = true;
          break;
        }
      }
    }
    return dp[s.length()];
  }

  public static void main(String[] args){
    Collections.addAll(set, "S", "O", "H" , "AS", "I", "IR", "P", "K");
    Interview2 i = new Interview2();
    String s = "SHASHIR";
    System.out.println(i.isPeriodic(s));
    System.out.println(i.isPeriodicII(s));
    System.out.println(i.isPeriodicIII(s));
  }
}
