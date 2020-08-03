package LeetCode.ArraysAndStrings;

public class StringCompression {
  public int compress(char[] chars){
    int i = 0, index = 0;
    while (i < chars.length){
      int j = i;
      while (j < chars.length && chars[i] == chars[j]){
        j++;
      }
      chars[index++] = chars[i];
      if(j-i > 1) {
        String s = j - i + "";
        for(char c : s.toCharArray()) {
          chars[index++] = c;
        }
      }
      i = j;
    }
    return index;
  }
  public static void main(String[] args){
    StringCompression s = new StringCompression();
    char[] c = {'d','a','a','r','u','b','b','c','c','c','k'};
    System.out.println(s.compress(c));
  }
}
