package LeetCode.Others;

import java.util.HashMap;

public class StobogrammaticNumber {
  public boolean isStrobogrammatic(String num){
    HashMap<Character, Character> h = new HashMap<>();
    h.put('6','9');
    h.put('9','6');
    h.put('1','1');
    h.put('8','8');
    h.put('0','0');

    int n = num.length();
    int l = 0, r = n-1;
    while (l <= r){
      if(!h.containsKey(num.charAt(r)) ||  num.charAt(l) != h.get(num.charAt(r))){
        return false;
      }
      l++; r--;
    }
    return true;
  }
  public static void main(String[] args){
    StobogrammaticNumber s = new StobogrammaticNumber();
    System.out.print(s.isStrobogrammatic("962"));
  }
}
