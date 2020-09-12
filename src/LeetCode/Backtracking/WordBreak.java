package LeetCode.Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordBreak {
  public boolean wordBreak(String s, List<String> wordDict){
    return backTrack(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
  }

  public boolean backTrack(String s, HashSet<String> dict, int start, Boolean[] memo){
    if(start == s.length()) return true;

    if(memo[start] != null) return memo[start];

    for(int end = start+1; end <= s.length(); end++){
      if(dict.contains(s.substring(start, end)) && backTrack(s, dict, end, memo))
        return memo[start] = true;
    }
    return memo[start] = false;
  }

  // brute force
  public boolean wordBreakII(String s, List<String> wordDict){
    return backTrack(s, new HashSet<>(wordDict),0);
  }

  public boolean backTrack(String s, HashSet<String> words, int start){
    if(start == s.length()) return true;
    for(int end = start+1; end <= s.length(); end++){
      if(words.contains(s.substring(start, end)) && backTrack(s, words,end))
        return true;
    }
    return false;
  }

  public static void main(String[] args){
    String s = "applepenapple";
    List<String> dict = new ArrayList();
    dict.add("apple"); dict.add("pen");
    WordBreak w = new WordBreak();
    System.out.print(w.wordBreak(s, dict));
//    System.out.print(w.wordBreakII(s, dict));

  }
}
