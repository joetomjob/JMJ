package LeetCode.ArraysAndStrings;

public class LengthOfLastWord {
  public int lengthOfLastWord(String s){
    s = s.trim();
    int n = s.length(), l = 0, i = n-1;
    while (i >= 0 && s.charAt(i) != ' '){
      l++;
      i--;
    }
    return l;
  }

  public static void main(String[] args){
    String s = "Hello World";
    LengthOfLastWord l = new LengthOfLastWord();
    System.out.println(l.lengthOfLastWord(s));
    System.out.println(l.lengthOfLastWord("a "));
  }
}
