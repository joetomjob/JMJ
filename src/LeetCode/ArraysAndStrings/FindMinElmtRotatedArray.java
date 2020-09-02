package LeetCode.ArraysAndStrings;

public class FindMinElmtRotatedArray {
  public int findMin(int[] nums){
    int left = 0, right = nums.length - 1;
    if(nums[left] < nums[right]) return nums[0]; // if not rotated, return first element;
    while(left < right){
      int mid = (left + right) / 2;
      if(nums[mid] > nums[right]) left = mid +1;
      else right = mid;
    }
    return nums[left];
  }
  public static void main(String[] args){
    int[] nums = {3,4,5,1,2};
    FindMinElmtRotatedArray f = new FindMinElmtRotatedArray();
    System.out.print(f.findMin(nums));
  }
}
