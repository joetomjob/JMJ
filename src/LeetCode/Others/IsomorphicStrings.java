package LeetCode.Others;

import java.util.HashMap;

public class IsomorphicStrings {
  public boolean isIsomorphic(String s, String t){
    if (s.length() != t.length())
      return false;
    if(s.length() == 0)
      return true;

    int n = s.length();
    int[] m1 = new int[256];
    int[] m2 = new int[256];

    for (int i = 0; i < n; i++) {
      char c1 = s.charAt(i);
      char c2 = t.charAt(i);
      if(m1[c1] != m2[c2]){
          return false;
      }
      m1[c1] = i + 1;
      m2[c2] = i + 1;
    }

    return true;
  }

  public boolean isIsomorphic2(String s, String t){
    if (s.length() != t.length())
      return false;
    if(s.length() == 0)
      return true;

    int n = s.length();
    HashMap<Character, Character> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      char c1 = s.charAt(i);
      char c2 = t.charAt(i);

      if(map.containsKey(c1)) {
        if(c2 != map.get(c1)) return false;
      } else {
        if(map.containsKey(c2)) return false;
        map.put(c1,c2);
      }
    }
    return true;
  }

  public static void main(String[] args){
    IsomorphicStrings i = new IsomorphicStrings();
    System.out.println(i.isIsomorphic("aba", "baa"));
  }
}
