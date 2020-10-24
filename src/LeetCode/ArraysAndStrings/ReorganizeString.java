package LeetCode.ArraysAndStrings;

import java.util.PriorityQueue;

public class ReorganizeString {
  class CharCount {
    int count;
    char character;

    CharCount(char character, int count){
      this.character = character;
      this.count = count;
    }
  }

  public String reorganizerString(String S) {
    int[] s = new int[26];
    for(char c : S.toCharArray()) {
      s[c-'a']++;
    }
    int length = S.length();
    int max = 0;

    PriorityQueue<CharCount> q = new PriorityQueue<>((a, b) -> b.count - a.count);
    for (int i = 0; i < 26; i++) {
      if(s[i] > max) max = s[i];
      if(s[i] > 0) q.add(new CharCount((char)(i + 'a'), s[i]));
    }

    if (length - max + 1 < max) return "";

    StringBuilder sb = new StringBuilder();
    while (!q.isEmpty()) {
      CharCount c1 = q.poll();
      if(c1 != null) {
        sb.append(c1.character);
      }

      CharCount c2 = q.poll();
      if(c2 != null) {
        sb.append(c2.character);
      }

      if(c1 != null && c1.count > 1) {
        --c1.count;
        q.add(c1);
      }

      if(c2 != null && c2.count > 1) {
        --c2.count;
        q.add(c2);
      }
    }

    return sb.toString();
  }
  public static void main(String[] args){
    ReorganizeString r = new ReorganizeString();
    System.out.println(r.reorganizerString("aab"));
    System.out.println(r.reorganizerString("aaab"));
  }
}
