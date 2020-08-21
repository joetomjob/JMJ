package LeetCode.ArraysAndStrings;

import java.util.*;

public class FindAndReplaceString {
  public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets){
    int[] matches = new int[S.length()];
    Arrays.fill(matches, -1);
    for(int i = 0; i < indexes.length; i++){
      if(S.substring(indexes[i], indexes[i] + sources[i].length()).equals(sources[i])){
        matches[indexes[i]] = i;
      }
    }
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < matches.length;) {
      if (matches[i] == -1) {
        sb.append(S.charAt(i));
        i++;
      } else {
        sb.append(targets[matches[i]]);
        i += sources[matches[i]].length();
      }
    }
    return sb.toString();
  }
  public static void main(String[] args){
    String S = "abcd";
    int[] indexes = {0,2};
    String[] sources = {"a", "cd"};
    String[] targets = {"eee", "ffff"};
    FindAndReplaceString f = new FindAndReplaceString();
    System.out.print(f.findReplaceString(S, indexes, sources, targets));
  }
}
