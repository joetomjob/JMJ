package LeetCode.ArraysAndStrings;

public class RotateArray {
  public void rotate(int[] nums, int k) {
    k = k % nums.length;
    if(nums.length == 1 || k == 0) return;
    reverse(nums, 0, nums.length -1);
    printArray(nums);
    reverse(nums, 0, k-1);
    printArray(nums);
    reverse(nums, k, nums.length-1);
    printArray(nums);
  }

  public void reverse(int[] nums, int s, int e){
    int m = s + ((e-s)/2);
    for (int i = s, j = e; i <= m; i++, j--) {
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
    }
  }

  public void printArray(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      System.out.print(nums[i]);
      System.out.print('\t');
    }
    System.out.print('\n');
  }

  public static void main(String[] args) {
    RotateArray r = new RotateArray();
    r.rotate(new int[] {1}, 0);
  }
}
