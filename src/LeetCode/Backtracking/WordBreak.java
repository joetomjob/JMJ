package LeetCode.Backtracking;

import java.util.*;

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

  // BFS approach
  // add the start index to the queue. visited says whether the node is visited or not.
  public boolean wordBreakIII(String s, List<String> wordDict){
    Queue<Integer> q = new LinkedList<>();
    int[] visited = new int[s.length()];
    q.add(0);
    while(!q.isEmpty()){
      int index = q.poll();
      if(visited[index] == 0) {
        for (int end = index + 1; end <= s.length(); end++) {
          if (wordDict.contains(s.substring(index, end))) {
            q.add(end);
            if (end == s.length()) return true;
          }
        }
        visited[index] = 1;
      }
    }
    return false;
  }

  // dynamic programming approach. The approach is to divide into subproblems. "catsanddog" can be split into "catsand" & "dog".
  // "catsand" can be further divided into "cats" & "dog".
  public boolean wordBreakIV(String s, List<String> wordDict){
    HashSet<String> set = new HashSet<>(wordDict);
    // dp array is a boolean array. the first element is set as true. Because, the first is empty string and is always valid.
    // "" and "catanddog".
    boolean[] dp = new boolean[s.length()+1];
    dp[0] = true;

    for(int i = 1; i <= s.length(); i++) {
      for (int j = 0; j < i; j++) {
        if (dp[j] && set.contains(s.substring(j, i))) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[s.length()];
  }

  public static void main(String[] args){
    String s = "applepenapple";
    List<String> dict = new ArrayList();
    dict.add("apple"); dict.add("pen");

    String s1 = "catsanddog";
    List<String> dict1 = new ArrayList();
    dict1.add("cats"); dict1.add("dog");dict1.add("sand");dict1.add("and");dict1.add("cat");

    WordBreak w = new WordBreak();
    System.out.println(w.wordBreak(s, dict));
    System.out.println(w.wordBreak(s1, dict1));
    System.out.println(w.wordBreakIII(s1, dict1));
    System.out.println(w.wordBreakIV(s1, dict1));
//    System.out.print(w.wordBreakII(s, dict));

  }
}
