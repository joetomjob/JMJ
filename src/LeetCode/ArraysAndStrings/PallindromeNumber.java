package LeetCode.ArraysAndStrings;

public class PallindromeNumber {
  public boolean isPalindrome(int x) {
    if(x < 0) return false;

    int temp = x, res = 0;
    while(temp != 0) {
      int rem = temp%10;
      temp = temp/10;
      res = res*10 + rem;
    }
    return res == x;
  }
  public static void main(String[] args){
    PallindromeNumber p = new PallindromeNumber();
    System.out.print(p.isPalindrome(121));
  }
}
