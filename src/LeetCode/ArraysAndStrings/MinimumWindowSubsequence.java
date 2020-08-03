package LeetCode.ArraysAndStrings;

import java.util.HashMap;

public class MinimumWindowSubsequence {
  public String minWindow(String S, String T){
    String minWin = ""; int min = S.length()+1;
    int n = S.length(), j = 0;
    for(int i = 0; i < n; i++){
      if(S.charAt(i) == T.charAt(j)){
        j++;
        if(j >= T.length()){
          int end = i+1;
          j--;
          while (j >= 0){
            if(S.charAt(i) == T.charAt(j)){
              j--;
            }
            i--;
          }
          i++; j++;
          if(end - i < min){
            min = end - i;
            minWin = S.substring(i, end);
          }
        }
      }
    }
    return minWin;
  }
  public static void main(String[] args){
    MinimumWindowSubsequence m = new MinimumWindowSubsequence();
    System.out.println(m.minWindow("abcdebdde", "bde"));
  }
}
