package LeetCode.Others;

public class Sum2Integers {
  // method 1
  public int sum(int a, int b) {
    int x = Math.abs(a); int y = Math.abs(b);
    if(x < y) {
      return sum(b, a);
    }
    int sign = a > 0 ? 1 : -1;
    if(a*b >= 0) {
      while (y != 0) {
        int ans = x ^ y;
        int carry = (x & y) << 1;
        x = ans;
        y= carry;
      }
    } else {
      while (y != 0) {
        int ans = x ^ y;
        int borrow = (~x & y) << 1;
        x = ans;
        y= borrow;
      }
    }
    return x * sign;
  }

  // method 2
  public int sum2(int a, int b) {
    while (b != 0) {
      int sum = a ^ b;
      int carry = (a & b) << 1;
      a = sum;
      b = carry;
    }
    return a;
  }


  public static void main(String[] args) {
    Sum2Integers s = new Sum2Integers();
    System.out.println(s.sum(12, 15));
    System.out.println(s.sum2(12, 15));
  }
}
