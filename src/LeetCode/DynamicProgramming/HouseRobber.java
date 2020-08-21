package LeetCode.DynamicProgramming;

public class HouseRobber {
  public int rob(int[] nums){
    if(nums.length == 0) return 0;
    int[] mem = new int[nums.length+1];
    mem[0] = 0;
    mem[1] = nums[0];
    for(int i = 1; i < nums.length; i++){
      mem[i+1] = Math.max(nums[i] + mem[i-1], mem[i]);
    }
    return mem[nums.length];
  }

  // better approach with O(1) space. we can replace the memoization array with 2 variables.
  public int rob2(int[] nums) {
    if(nums.length == 0) return 0;

    int prev1 = 0, prev2=0;
    for(int num : nums) {
      int temp = prev1;
      prev1 = Math.max(prev2+num, prev1);
      prev2 = temp;
    }
    return prev1;
  }

  public static void main(String[] args){
    HouseRobber r = new HouseRobber();
    int[] nums = {2,7,9,3,1};
    System.out.print(r.rob(nums));
  }
}
