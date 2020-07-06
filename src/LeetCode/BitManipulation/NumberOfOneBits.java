package LeetCode.BitManipulation;

public class NumberOfOneBits {
  public int noOfOneBits(int a) {
    int cnt = 0;
    while (a != 0) {
      cnt++;
      a &= a-1; // x & (x-1) drops the least significant bit
    }
    return cnt;
  }
  public static void main(String[] args) {
    NumberOfOneBits n = new NumberOfOneBits();
    System.out.print(n.noOfOneBits(16));
  }
}
