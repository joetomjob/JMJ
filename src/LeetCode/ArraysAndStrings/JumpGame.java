package LeetCode.ArraysAndStrings;

public class JumpGame {
  public boolean canJump(int[] nums) {
    int leftIndex = nums.length - 1;
    for (int i = nums.length - 1; i >= 0 ; i--) {
      if(i + nums[i] >= leftIndex){
        leftIndex = i;
      }
    }
    return leftIndex == 0;
  }
  public static void main(String[] args) {
    int[] a = {9, 4, 2, 1, 0 , 2, 0};
    JumpGame j = new JumpGame();
    System.out.print(j.canJump(a));
  }
}
