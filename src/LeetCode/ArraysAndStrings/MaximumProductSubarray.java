package LeetCode.ArraysAndStrings;

public class MaximumProductSubarray {
  // O(n^2)
  public int maxProduct(int[] nums){
    if(nums == null) return 0;
    if(nums.length == 1) return nums[0];

    int max = Integer.MIN_VALUE;
    for(int i = 0; i < nums.length; i++) {
      int curMax = 1;
      for(int j = i; j < nums.length; j++){
        curMax *= nums[j];
        max = Math.max(curMax, max);
      }
    }

    return max;
  }

  // O(n)

  public int maxProductII(int[] nums) {
    if(nums == null || nums.length == 0) return 0;
    if(nums.length == 1) return nums[0];

    // the logic here is, we need to consider 3 cases, the number in the position itself can be the answer, the max_so_far * cur_num
    // can be the answer or min_so_far * cur_num can be the answer.
    // if we encounter a negative number second time, we need to track the min_so_far so that the product may result in large number.
    int min_so_far = nums[0];
    int max_so_far = nums[0];
    int res = nums[0];

    for (int i = 1; i < nums.length; i++){
      int cur_num = nums[i];

      int tempMax = Math.max(cur_num, Math.max(cur_num * max_so_far, cur_num * min_so_far));
      min_so_far = Math.min(cur_num, Math.min(cur_num * max_so_far, cur_num * min_so_far));
      max_so_far = tempMax;

      res = Math.max(max_so_far, res);
    }

    return res;
  }

  public static void main(String[] args){
    int[] nums = {2,3,-2,4};
    MaximumProductSubarray m = new MaximumProductSubarray();
    System.out.println(m.maxProductII(nums));
  }
}
