package LeetCode.Strings;

public class LongestPallindromicSubstring {
  public String longestPalindrome(String s) {
    int start = 0, end = 0, n = s.length();
    if(n == 0 || s == null) return "";
    for (int i = 0; i < n; i++) {
      int len1 = expandAroundCenter(s, i, i); // to handle cases where there is a middle element or length is odd. eg: racecar
      int len2 = expandAroundCenter(s, i, i+1); // to handle cases where there is no middle element or length is odd. eg: abba
      int len = Math.max(len1, len2);
      if(len > end-start) {
        start = i - ((len-1)/2);
        end = i - (len/2);
      }
    }
    return s.substring(start, end+1);
  }

  public int expandAroundCenter(String s, int l, int r) {
    if (s == null || l> r) return 0;
    while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
      l--; r++;
    }
    return r-l-1; // why -1 and not +1 - Because, we decremented l and incremented r.
                  // That is incrementing by a factor of 2 in total. therefore r-l+1-2 = r-l-1;
  }
  public static void main(String[] args) {
    LongestPallindromicSubstring l = new LongestPallindromicSubstring();

  }
}
