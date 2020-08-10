package LeetCode.ArraysAndStrings;

public class PallindromicSubstrings {
  int res;
  public int countSubstrings(String s) {
    res = 0;
    if( s == null || s.length() == 0) return 0;
    int n = s.length();
    for(int i = 0; i < n; i++){
      expandFromCenter(i, i, s);
      expandFromCenter(i, i+1, s);
    }
    return res;
  }

  public void expandFromCenter(int l, int r, String s){
    if(l > r) return;
    int n = s.length();
    while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)){
      res++;
      l--;
      r++;
    }
  }

  public static void main(String[] args){
    PallindromicSubstrings p = new PallindromicSubstrings();
    System.out.println(p.countSubstrings("abbba"));
  }
}
