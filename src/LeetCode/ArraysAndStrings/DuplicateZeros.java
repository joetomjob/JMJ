package LeetCode.ArraysAndStrings;

public class DuplicateZeros {
  public void duplicateZeros(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      if(arr[i] == 0) {
        shiftNums(i+1, arr);
        if(i+1 < arr.length) {
          arr[i + 1] = 0;
          i++;
        }
      }
    }
  }

  public void shiftNums(int k, int[] nums) {
    for (int i = nums.length-1; i > k; i--) {
      nums[i] = nums[i-1];
    }
  }
  public static void main(String[] args) {
    int[] arr = {1,0,2,3,0,4,5,0};
    DuplicateZeros d = new DuplicateZeros();
    d.duplicateZeros(arr);
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i]);
      System.out.print('\t');
    }
  }
}
