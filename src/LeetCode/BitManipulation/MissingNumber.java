package LeetCode.BitManipulation;

public class MissingNumber {
  public int missingNumber(int[] a) {
    int xor = a.length;
    for (int i = 0; i < a.length; i++) {
      xor ^= a[i] ^ i;
    }
    return xor;
  }

  public int gauss(int[] a) {
    int expected = (a.length * (a.length + 1)) / 2;
    int sum = 0;
    for (int i = 0; i < a.length; i++) {
      sum += a[i];
    }
    return expected - sum;
  }
  public static void main(String[] args) {
    MissingNumber m = new MissingNumber();
    System.out.println(m.missingNumber(new int[] {0,1,2,3,4,5,6,7,9}));
    System.out.println(m.gauss(new int[] {0,1,2,3,4,5,6,7,9}));
  }
}
