package LeetCode.DynamicProgramming;

import java.util.HashMap;

public class SubarraySumK {
  public int subArraySum1(int[] nums, int k){
    if(nums.length == 0) return 0;
    int[] prefixSum = new int[nums.length+1];
    prefixSum[0] = 0;
    for(int i = 0; i < nums.length; i++){
      prefixSum[i+1] = nums[i] + prefixSum[i];
    }
    int count = 0;
    for(int i = 1; i < prefixSum.length;i++){
      for(int j = 0; j < i; j++){
        if(prefixSum[i] - prefixSum[j] == k)
          count++;
      }
    }
    return count;
  }

  public int subarraySum(int[] nums, int k){
    // logic - prefix sum logic. but save the prefix sum value to a hashmap.
    // Then we subtract the sum with k (sum-k) and check whether that is present in the map.
    // if present, then that means we will get another subarray with sum k.
    // proof for that is sum - k = val means => sum = k + val (val from map).
    // if the sum-k already present, then increment the counter
    // also initially add 0 and count 1 because for the first time sum reaches k, the sum - k should exist in the hashmap
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0,1);
    int sum = 0, count = 0;
    for(int i = 0; i < nums.length; i++){
      sum += nums[i];
      if(map.containsKey(sum - k))
        count += map.get(sum-k);
      map.put(sum, map.getOrDefault(sum, 0)+1);
    }
    return count;
  }

  public static void main(String[] args){
    SubarraySumK s = new SubarraySumK();
    int[] nums = {0,0,0,0,0,0,0,0,0,0};
    int k = 0;
//    int[] nums = {3,4,7,2,-3,1,4,2};
//    int k = 7;
//    System.out.print(s.subarraySum(nums, k));
    System.out.print(s.subArraySum1(nums, k));
  }
}
