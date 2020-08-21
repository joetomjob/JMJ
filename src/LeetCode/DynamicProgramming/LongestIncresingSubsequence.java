package LeetCode.DynamicProgramming;

import java.util.Arrays;
import java.util.Collections;

public class LongestIncresingSubsequence {
  public int lengthOfLIS(int[] nums){
    if(nums.length == 0) return 0;
    if(nums.length == 1) return 1;
    int[] mem = new int[nums.length];
    Arrays.fill(mem,1);
    int maxAns = 1;
    for(int i = 1; i < nums.length; i++){
      for(int j = 0; j < i; j++){
        if(nums[i] > nums[j]){
          mem[i] = Math.max(mem[i], mem[j]+1);
        }
      }
      maxAns = Math.max(maxAns, mem[i]);
    }
    return maxAns;
  }

  public static void main(String[] args){
    int[] nums = {10,9,2,5,3,7,101,18};
    LongestIncresingSubsequence l = new LongestIncresingSubsequence();
    System.out.print(l.lengthOfLIS(nums));
  }
}
