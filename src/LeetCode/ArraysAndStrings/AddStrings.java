package LeetCode.ArraysAndStrings;

public class AddStrings {

  public String addStrings(String num1, String num2){

    // if any number is empty return the other string
    if(num1.length() == 0 || num2.length() == 0) return num1.length() == 0 ? num2 : num1;

    int l1 = num1.length()-1;
    int l2 = num2.length()-1;
    int rem = 0;
    StringBuilder sb = new StringBuilder();

    while (l1 != -1 || l2 != -1){
      int t1 = l1 == -1 ? 0 : num1.charAt(l1)-'0';
      int t2 = l2 == -1 ? 0 : num2.charAt(l2)-'0';

      int sum = t1 + t2 + rem;
      rem = sum/10;
      sb.append(sum%10);

      l1 = l1 != -1 ? --l1 : l1;
      l2 = l2 != -1 ? --l2 : l2;
    }

    if(rem > 0) sb.append(rem);
    return sb.reverse().toString();
  }

  public static void main(String[] args){
    String num1 = "9487";
    String num2 = "29";
    AddStrings a = new AddStrings();
    System.out.print(a.addStrings(num1, num2));
  }
}
