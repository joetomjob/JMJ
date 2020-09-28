package LeetCode.DynamicProgramming;

import LeetCode.Recursion.WordSearchII;

import java.util.*;

public class WordBreakII {
  HashSet<String> set;
  List<String> res;
  public List<String> wordBreak(String s, List<String> wordDict){
    set = new HashSet<>(wordDict);
    res = new ArrayList<>();
    backTrack(s, 0, new ArrayList<String>());
    return res;
  }

  // time limit exceeded
  public void backTrack(String s, int start, List<String> cur){
    if(start == s.length()){
      StringBuilder sb = new StringBuilder();
      for(String st : cur){
        sb.append(st+" ");
      }
      res.add(sb.toString().trim());
    }

    for(int i = start+1; i <= s.length(); i++) {
      if(set.contains(s.substring(start, i))) {
        cur.add(s.substring(start, i));
        backTrack(s, i, cur);
        cur.remove(cur.size()-1);
      }
    }
  }

  // BFS - not successful
  public List<String> wordBreakII(String s, List<String> wordDict){
    set = new HashSet<>(wordDict);
    res = new ArrayList<>();
    Queue<Integer> q = new LinkedList<>();
    int[] visited = new int[s.length()];
    q.add(0);
    while (!q.isEmpty()){
      int start = q.poll();
      if(visited[start] == 0){
        for(int end = start+1; end <= s.length(); end++){
          if(set.contains(s.substring(start,end))) q.add(end);
          if(end == s.length()){
            System.out.println("hi");
          }
        }
      }
    }
    return res;
  }

  // backtracking with memoization
  public List<String> wordBreakIII(String s, List<String> wordDict){
    set = new HashSet<>(wordDict);
    return backTrackII(s, 0, new HashMap<String, List<String>>());
  }

  public List<String> backTrackII(String s, int start, Map<String, List<String>> memo){
    List<String> res = new ArrayList<String>();

    if(start == s.length()){
      res.add("");
      return res;
    }

    if(memo.containsKey(s.substring(start))) return memo.get(s.substring(start));

    for(int i = start+1; i <= s.length(); i++){
      if(set.contains(s.substring(start, i))){
        List<String> substrings = backTrackII(s, i, memo);
        for(String st : substrings){
          res.add(s.substring(start, i) + (!st.equals("") ? " " : "") +st);
        }
      }
    }
    memo.put(s.substring(start), res);
    return res;
  }

  public static void main(String[] args){
    String[] strings  = {"apple","pen","applepen","pine","pineapple"};
    List<String> wordDict = Arrays.asList(strings);
    String s = "pineapplepenapple";
    WordBreakII w = new WordBreakII();
    List<String> res = w.wordBreak(s, wordDict);
    for(String r : res){
//      System.out.println(r);
    }
    res = w.wordBreakIII(s, wordDict);
    for(String r : res){
      System.out.println(r);
    }
  }
}
