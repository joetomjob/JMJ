package LeetCode.sortingAndSearching;

import java.util.HashMap;

public class ValidAnagram {
  public boolean isAnagram(String s, String t) {
    int[] count = new int[26];

    int m = s.length();
    int n = t.length();
    if(m != n)
      return false;

    for (char c :s.toCharArray()) {
      count[c - 'a']++;
    }

    for (char c :t.toCharArray()) {
      count[c - 'a']--;
    }

    for (int c: count) {
      if(c != 0)
        return false;
    }
    return true;
  }
  public static void main(String[] args){
    ValidAnagram v = new ValidAnagram();
    String s = "anagram";
    String t = "nagaram";
    System.out.print(v.isAnagram(s, t));
  }
}
