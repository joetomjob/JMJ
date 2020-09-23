package LeetCode.ArraysAndStrings;

public class RunningSum {
  public int[] runningSum(int[] nums){
    for(int i = 1; i < nums.length; i++){
      nums[i] += nums[i-1];
    }
    return nums;
  }
  public static void main(String[] args){
    int[] nums = {1,2,3,4};
    RunningSum r = new RunningSum();
    int[] res = r.runningSum(nums);
    for(int i : res){
      System.out.print(i);
      System.out.print('\t');
    }
  }
}
