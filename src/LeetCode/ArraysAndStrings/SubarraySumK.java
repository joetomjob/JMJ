package LeetCode.ArraysAndStrings;

public class SubarraySumK {
  public int subarraySum(int[] nums, int k){
    int res = 0, i = 0, j = 0, resCount = 0;

    while (j < nums.length){
      res = res + nums[j++];
      while (res >= k && i <= j && i < nums.length) {
        if(res == k)
          resCount++;
        res -= nums[i++];
      }
    }
    return resCount;
  }

  public static void main(String[] args){
    SubarraySumK s = new SubarraySumK();
    int[] nums = {-1, -1, 1};
    System.out.print(s.subarraySum(nums, 0));
  }
}
