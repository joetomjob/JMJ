package LeetCode.ArraysAndStrings;

public class ProductArrayExceptSelf {
  public int[] productExceptSelf(int[] nums) {
    int[] res = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      res[i] = 1;
    }

    int left = 1;
    for (int i = 0; i < nums.length; i++) {
      res[i] = left * res[i];
      left *= nums[i];
    }

    int right = 1;
    for (int i = nums.length-1; i >=0; i--) {
      res[i] *= right;
      right *= nums[i];
    }

    return res;
  }
  public static void main(String[] args) {
    ProductArrayExceptSelf p = new ProductArrayExceptSelf();
    int[] a = {1,2,3,4};
    int[] res = p.productExceptSelf(a);
    for (int i = 0; i < res.length; i++) {
      System.out.print(res[i]);
      System.out.print('\t');
    }
  }
}
