package LeetCode.ArraysAndStrings;

public class RangeSumImmutable {
  int[] prefix;
  int len;
  public RangeSumImmutable(int[] nums){
    this.len = nums.length;
    prefix = new int[len+1];
    for(int i = 1; i < prefix.length; i++){
      prefix[i] = prefix[i-1] + nums[i-1];
    }
  }

  public int sumRange(int i, int j){
    if(this.len == 0) return 0;
    return prefix[j+1] - prefix[i];
  }

}
