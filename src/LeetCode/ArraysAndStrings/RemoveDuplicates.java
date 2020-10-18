package LeetCode.ArraysAndStrings;

public class RemoveDuplicates {
  public String removeDuplicates(String S) {
    StringBuilder sb = new StringBuilder(S);
    for(int i = 0; i < sb.length(); i++) {
      if(i > 0 && sb.charAt(i) == sb.charAt(i-1)) {
        sb.delete(i-1, i+1);
        i = i-2;
      }
    }
    return sb.toString();
  }

  public static void main(String[] args){
    RemoveDuplicates r = new RemoveDuplicates();
    String S = "abbaca";
    System.out.println(r.removeDuplicates(S));
  }
}
