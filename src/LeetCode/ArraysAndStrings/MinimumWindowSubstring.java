package LeetCode.ArraysAndStrings;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumWindowSubstring {
  public String minWindow(String s, String t) {
    if(s.length() == 0 || t.length() ==0) return "";
    int[] ans = {-1, 0, 0};
    Map<Character, Integer> dicT = new HashMap<>();
    int n = t.length();
    for (int i = 0; i < n; i++) {
      int count = dicT.getOrDefault(t.charAt(i), 0);
      dicT.put(t.charAt(i), count+1);
    }
    int requiredsize = dicT.size();
    int formed = 0, l = 0, r = 0;
    Map<Character, Integer> windowCount = new HashMap<>();
    n = s.length();

    while (r < n) {
      char c = s.charAt(r);
      int count = windowCount.getOrDefault(c, 0);
      windowCount.put(c, count+1);

      if(dicT.containsKey(c) && dicT.get(c).intValue() == windowCount.get(c).intValue()) {
        formed++;
      }

      while (l <= r && formed == requiredsize) {
        c = s.charAt(l);
        if(ans[0] == -1 || r-l+1 < ans[0]){
          ans[0] = r-l+1;
          ans[1] = l;
          ans[2] = r;
        }
        windowCount.put(c, windowCount.get(c)-1);
        if(dicT.containsKey(c) && windowCount.get(c).intValue() < dicT.get(c).intValue()){
          formed--;
        }
        l++;
      }
      r++;
    }
    return ans[0] == -1 ? "" : s.substring(ans[1], ans[2]+1);
  }

  // we only need characters in S which are present in t. thus we can reduce complexity
  public String minWindow2(String s, String t) {
    if(s.length() == 0 || t.length() ==0) return "";

    Map<Character, Integer> dicT = new HashMap<>();
    int n = t.length();
    for (int i = 0; i < n; i++) {
      int count = dicT.getOrDefault(t.charAt(i), 0);
      dicT.put(t.charAt(i), count+1);
    }

    //hashmap saves the position and charater
    n = s.length();
//    List<<Integer, Character>> filteredS = new ArrayList<>();
//    for (int i = 0; i < n; i++) {
//      if(dicT.containsKey(s.charAt(i))) {
//
//        filteredS.add()
//      }
//    }

    int requiredsize = dicT.size();
    int formed = 0, l = 0, r = 0;
    int[] ans = {-1, 0, 0};
    Map<Character, Integer> windowCount = new HashMap<>();

    while (r < n) {
      char c = s.charAt(r);
      int count = windowCount.getOrDefault(c, 0);
      windowCount.put(c, count+1);

      if(dicT.containsKey(c) && dicT.get(c).intValue() == windowCount.get(c).intValue()) {
        formed++;
      }

      while (l <= r && formed == requiredsize) {
        c = s.charAt(l);
        if(ans[0] == -1 || r-l+1 < ans[0]){
          ans[0] = r-l+1;
          ans[1] = l;
          ans[2] = r;
        }
        windowCount.put(c, windowCount.get(c)-1);
        if(dicT.containsKey(c) && windowCount.get(c).intValue() < dicT.get(c).intValue()){
          formed--;
        }
        l++;
      }
      r++;
    }
    return ans[0] == -1 ? "" : s.substring(ans[1], ans[2]+1);
  }

  public static void main(String[] args) {
    String s = "ADOBECODEBANC";
    String t = "ABC";
    MinimumWindowSubstring m = new MinimumWindowSubstring();
    System.out.print(m.minWindow(s, t));
  }
}
