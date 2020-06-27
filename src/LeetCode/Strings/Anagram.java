package LeetCode.Strings;

import LeetCode.ArraysAndStrings.StringToWords;

import java.util.*;

public class Anagram {
  public List<List<String>> groupAnagrams(String[] strs) {
    if(strs.length == 0) return new ArrayList<>();
    HashMap<String, ArrayList<String>> map = new HashMap<>();
    for (String s: strs) {
      char[] c = s.toCharArray();
      Arrays.sort(c);

      String t = String.valueOf(c);
      if(!map.containsKey(t)) map.put(t, new ArrayList<>());
      map.get(t).add(s);
    }
    return new ArrayList<>(map.values());
  }

  public List<List<String>> groupAnagrams2(String[] strs) {
    if(strs.length == 0) return new ArrayList<>();
    HashMap<String, ArrayList<String>> map = new HashMap<>();
    for (String s: strs) {
      int[] count = new int[26];
      for (char c:s.toCharArray()) {
        count[c-'a']++;
      }
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < 26; i++) {
        sb.append('#');
        sb.append(count[i]);
      }
      String t = sb.toString();
      if(!map.containsKey(t)) map.put(t, new ArrayList<>());
      map.get(t).add(s);
    }
    return new ArrayList<>(map.values());
  }

  public static void main(String[] args) {
    String[] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
    Anagram a = new Anagram();
    List<List<String>> res = a.groupAnagrams2(s);
    for (List<String> arr: res) {
      for (String st:arr) {
        System.out.print(st);
        System.out.print('\t');
      }
      System.out.print('\n');
    }
  }
}
