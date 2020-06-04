package LeetCode.ArraysAndStrings;

public class MoveZeros {
  public void moveZeroes(int[] nums) {
    int index = 0;
    for (int num:nums) {
      if(num!=0) nums[index++] = num;
    }
    while (index < nums.length) {
      nums[index++] = 0;
    }
  }

  public static void main(String[] args) {
//    int[] a = {0,1,0,3,12};
    int[] a = {2,1};
    MoveZeros m = new MoveZeros();
    m.moveZeroes(a);
    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i]);
      System.out.print('\t');
    }
  }
}
