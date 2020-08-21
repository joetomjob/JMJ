package LeetCode.DynamicProgramming;

public class HouseRobberII {

  public int rob(int[] nums){
    if(nums.length == 0) return 0;
    if(nums.length == 1) return nums[0];

    int m1 = max(nums, 0, nums.length - 1);
    int m2 = max(nums, 1, nums.length);

    return Math.max(m1, m2);
  }

  public int max(int[] nums, int s, int e){
    int prev1 = 0, prev2 = 0;
    for(int i = s; i < e; i++){
      int temp = prev1;
      prev1 = Math.max(prev2 + nums[i], prev1);
      prev2 = temp;
    }
    return prev1;
  }

  public static void main(String[] args){
    HouseRobberII h = new HouseRobberII();
    int[] nums = {1,2,3,1};
    System.out.print(h.rob(nums));
  }
}
