package LeetCode.ArraysAndStrings;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LongestSubstring2Char {
  public int lengthOfLongestSubstringTwoDistinct(String s) {
    int n = s.length();
    if(n<3) return n;

    int l = 0, r = 0, maxlen = 2;
    HashMap<Character, Integer> map = new HashMap<>();

    while(r < n) {
      if(map.size() < 3)
        map.put(s.charAt(r), r++);
      if(map.size() == 3) {
        //we are getting the min value. value is the index and not the character.
        // The min value is the min index.
        int del_index = Collections.min(map.values());
        map.remove(s.charAt(del_index)); // then we get the character and remove it from the map.
        l = del_index+1;
      }
      maxlen = Math.max(maxlen, r-l);
    }
    return maxlen;
  }
  public static void main(String[] args) {
    LongestSubstring2Char l = new LongestSubstring2Char();
    System.out.println(l.lengthOfLongestSubstringTwoDistinct("ecccbbbaaaaa"));
  }
}
