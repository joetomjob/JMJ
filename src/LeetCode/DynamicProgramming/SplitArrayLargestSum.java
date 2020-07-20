package LeetCode.DynamicProgramming;

public class SplitArrayLargestSum {
  public int splitArray(int[] nums, int m) {
    int l = 0;
    int h = 0;

    for(int num : nums){
      h += num;
      l = Math.max(num, l);
    }

    while (l < h){
      int mid = l + (h - l)/2;
      int pieces = split(nums, mid);
      if(pieces > m){
        l = mid + 1;
      } else{
        h = mid;
      }
    }
    return l;
  }

  private int split(int[] nums, int largest){
    int pieces = 1;
    int tempsum = 0;
    for(int num : nums){
      if(tempsum + num > largest){
        tempsum = num;
        pieces++;
      } else {
        tempsum += num;
      }
    }
    return pieces;
  }

  public static void main(String[] args){
    int[] nums = {7,2,5,10,8};
    int m = 2;
    SplitArrayLargestSum s = new SplitArrayLargestSum();
    System.out.print(s.splitArray(nums, m));
  }
}
