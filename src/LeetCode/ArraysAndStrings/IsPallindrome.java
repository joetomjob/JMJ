package LeetCode.ArraysAndStrings;

public class IsPallindrome {
  public boolean isPalindrome(String s){
    if(s.trim().equals("")) return true;
    int i = 0, j = s.length()-1;
    while(i <= j){
      while(!Character.isLetterOrDigit(s.charAt(i)) && i < s.length()-1) i++;
      while(!Character.isLetterOrDigit(s.charAt(j)) && j > 0) j--;
      if(i<=j){
        if(Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))) {
          i++; j--;
        } else return false;
      }
    }
    return true;
  }

  public static void main(String[] args){
    IsPallindrome p = new IsPallindrome();
//    String s = "A man, a plan, a canal: Panama";
//    String s = "race a car";
    String s = ".";
    System.out.print(p.isPalindrome(s));
  }
}
