package LeetCode.ArraysAndStrings;

public class ExpressiveWords {
  int ans;
  public int expressiveWords(String S, String[] words) {
    ans = 0;

    for (String word : words) {
      if(isStretchy(word, S))
        ans++;
    }

    return ans;
  }

  public boolean isStretchy(String s1, String s2){
    int count1 = 1, count2 = 1, i = 0, j =0, s1l = s1.length(), s2l = s2.length();
    while (i < s1l && j < s2l ){
      if(s1.charAt(i) != s2.charAt(j))
        return false;
      while (i+1 < s1l && s1.charAt(i + 1) == s1.charAt(i)){
        i++; count1++;
      }
      while (j+1 < s2l && s2.charAt(j + 1) == s2.charAt(j)){
        j++; count2++;
      }
      if(count1 != count2 && count2 < 3 || count1 > count2)
        return false;

      i++; j++; count1 = 1; count2 = 1;
    }
    if(i != s1l || j != s2l)
      return false;

    return true;
  }

  public static void main(String[] args) {
    ExpressiveWords e = new ExpressiveWords();
    System.out.println(e.expressiveWords("aaa", new String[] {"aaaa"}));
  }
}
