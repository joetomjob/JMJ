package LeetCode.DynamicProgramming;

import java.util.HashMap;
import java.util.HashSet;

public class DecodeWays {
  int res;

  public int numDecodings(String s){
    res = 0;
    backTrack(s, 0);
    return res;
  }

  public boolean backTrack(String s, int index){
    if(index == s.length()) return true;

    if(backTrack(s, index+1))
      res++;
    if(index+2 <= s.length() && Integer.parseInt(s.substring(index, index+2)) < 27 && backTrack(s, index+2))
      res++;
    return false;
  }

  public int numDecodingsII(String s){
    return backTrackII(s, 0, new int[s.length()]);
  }

  public int backTrackII(String s, int index, int[] memo){
    if(index == s.length()) return 1;

    if(s.charAt(index) == '0') return 0;

    if(memo[index] > 0) return memo[index];

    if(index+1 <= s.length()) {
      memo[index] +=  backTrackII(s, index+1, memo);
    }
    if(index+2 <= s.length() && Integer.parseInt(s.substring(index, index+2)) < 27) {
      memo[index] +=  backTrackII(s, index+2, memo);
    }
    return memo[index];
  }

  public static void main(String[] args){
    DecodeWays d = new DecodeWays();
    System.out.println(d.numDecodings("2326"));
    System.out.println(d.numDecodingsII("2326"));
  }
}
