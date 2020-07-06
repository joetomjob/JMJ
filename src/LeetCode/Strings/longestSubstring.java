package LeetCode.Strings;

public class longestSubstring {
  public int lengthOfLongestSubstring(String s) {
    int a[] = new int[128];
    int ans = 0;
    int n = s.length();

    for (int j = 0, i = 0; j < n; j++) {
      i = Math.max(i, a[s.charAt(j)]);
      ans = Math.max(ans, j-i+1);
      a[s.charAt(j)] = j+1;
    }
    return ans;
  }

  public static void main(String[] args) {
    longestSubstring l = new longestSubstring();
    System.out.print(l.lengthOfLongestSubstring("abcabcbb"));
  }
}
