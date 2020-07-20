package LeetCode.ArraysAndStrings;

public class PlusOne {
    public int[] plusOne(int[] digits) {
      int r = digits.length -1;
      while (r >= 0) {
        if(digits[r] < 9) {
          digits[r] = digits[r] + 1;
          return digits;
        } else {
          digits[r] = 0;
        }
        r--;
      }
      int[] res = new int[digits.length+1];
      res[0] = 1;
      return res;
    }
    public static void main(String[] args) {
      int[] a = {8, 9, 9, 9};
      PlusOne p = new PlusOne();
      int[] res = p.plusOne(a);
      for (int i = 0; i < res.length; i++) {
        System.out.print(res[i]);
        System.out.print('\t');
      }
    }
}
