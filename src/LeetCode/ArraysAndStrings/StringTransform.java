package LeetCode.ArraysAndStrings;

import java.util.HashMap;
import java.util.HashSet;

public class StringTransform {
  public boolean canConvert(String s1, String s2){
    if(s1.equals(s2)) return true;

    HashMap<Character, Character> h1 = new HashMap<>();
    int n = s1.length();
    for(int i = 0; i < n; i++){
      if(h1.containsKey(s1.charAt(i)) && h1.get(s1.charAt(i)) != s2.charAt(i))
        return false;
      h1.put(s1.charAt(i), s2.charAt(i));
    }

    //edge case. check if all the letters are mapped. if all letters are mapped,
    // then we wont be having any character to act as a temp character to map a
    // character to different character
    return new HashSet<>(h1.values()).size() < 26;
  }
  public static void main(String[] args){
    StringTransform s = new StringTransform();
    System.out.println(s.canConvert("aabbcc", "ccddee"));
  }
}
