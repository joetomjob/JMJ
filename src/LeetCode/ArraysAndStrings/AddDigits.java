package LeetCode.ArraysAndStrings;

public class AddDigits {
  public int addDigits(int num){
    while (num/10 > 0){
      int temp = num;
      int sum = 0;
      while(temp > 0){
        sum = sum+(temp%10);
        temp /= 10;
      }
      num = sum;
    }
    return num;
  }

  public static void main(String[] args){
    AddDigits a = new AddDigits();
    System.out.println(a.addDigits(38));
  }
}