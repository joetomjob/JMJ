package LeetCode.DynamicProgramming;

public class MaxSubArray {
  public int maxSubArray(int[] nums) {
    int maxSum = Integer.MIN_VALUE;
    int currentSum = 0;
    for(int i = 0; i < nums.length; i++){
      currentSum = Math.max(nums[i], currentSum + nums[i]);
      if(currentSum > maxSum){
        maxSum = currentSum;
      }
    }
    return maxSum;
  }

  public int maxSubArray1(int[] nums){
    int maxSum = Integer.MIN_VALUE, curSum = 0;
    for (int n : nums) {
      curSum = Math.max(n, curSum + n);
      maxSum = curSum > maxSum ? curSum : maxSum;
    }
    return maxSum;
  }

  public static void main(String[] args){
    int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
    MaxSubArray m = new MaxSubArray();
    System.out.print(m.maxSubArray(nums));
  }
}
