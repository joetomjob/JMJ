package LeetCode.Math;

public class FactorialTrailingZeros {
  public int trailingZeroes(int n) {
    int zeros = 0;
    while(n > 0){
      n = n / 5;
      zeros += n;
    }
    return zeros;
  }
  public static void main(String[] args) {
    FactorialTrailingZeros f = new FactorialTrailingZeros();
    System.out.println(f.trailingZeroes(125));
  }
}
