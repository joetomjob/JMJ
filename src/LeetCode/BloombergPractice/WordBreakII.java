package LeetCode.BloombergPractice;

import java.util.*;

public class WordBreakII {
  public List<String>  wordBreak(String s, List<String> wordDict){
    HashSet<String> words = new HashSet<>(wordDict);
    return backTrack(s, 0, words, new HashMap<String, List<String>>());
  }

  public List<String> backTrack(String s, int index, HashSet<String> words, HashMap<String, List<String>> memo){
    List<String> res = new ArrayList<>();
    if(index == s.length()) {
      return new ArrayList<>(Arrays.asList(""));
    }

    if(memo.containsKey(s.substring(index))) return memo.get(s.substring(index));

    for(int i = index+1; i <= s.length(); i++){
      if(words.contains(s.substring(index, i))){
        List<String> list = backTrack(s, i, words, memo);
        for(String st : list) {
          res.add(s.substring(index, i) + (st == "" ? "" : " ") + st);
        }
      }
    }
    memo.put(s.substring(index), res);
    return res;
  }
  public static void main(String[] args){

  }
}
