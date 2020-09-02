package LeetCode.ArraysAndStrings;

import java.util.*;

public class GuessTheWord {
  class Master{
    String secret;
    Master(){}
    Master(String s){
      this.secret = s;
    }
    public int guess(String s){
      int c = 0;
     for(int i = 0; i < s.length();i++){
       if(s.charAt(i) == secret.charAt(i)){
         c++;
       }
     }
     return c;
    }
  }
  public void findSecretWord(String[] wordlist, Master master){
    List<String> list = Arrays.asList(wordlist);
    while(!list.isEmpty()) {
      // step 1: Create a map with 0 matches
      Map<String, Integer> map = new HashMap<>();
      for(String word : list){
        for(String other : list){
          if(match(word, other) == 0){
            map.put(word, map.getOrDefault(word, 0)+1);
          }
        }
      }

      // Step 2. get the word with lowest 0 matches. advantage of this and the above step is that, if we select the word with less
      // 0 matches, that will be the word with most matches. this will help in eliminating more words after each step.
      int min = Integer.MAX_VALUE;
      String word = list.get(0);
      for(Map.Entry<String, Integer> entry : map.entrySet()){
        if(entry.getValue() < min){
          min = entry.getValue();
          word = entry.getKey();
        }
      }

      // Step 3. get the matches with current word to secret word. if it equals 6, that means we found the secret word.
      int matchCount = master.guess(word);
      if (matchCount == 6) return;

      // Step 4. remove elements from list where the count does not match with the word in the list. Since the secret is a word in the
      // list, the count from master.guess() should exactly match with the word to be compared, so that that can be the secret.
      // eliminate all other words, as that won't be the secret.
      List<String> temp = new ArrayList<>();
      for(String w : list){
        if(matchCount == match(word, w)){
          temp.add(w);
        }
      }

      list = temp;
    }
  }

  public int match(String s1, String s2){
    int n = s1.length(), c = 0;
    for(int i = 0; i < n; i++){
      if(s1.charAt(i) == s2.charAt(i)) c++;
    }
    return c;
  }
  public static void main(){

  }
}
