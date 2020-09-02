package LeetCode.ArraysAndStrings;

public class SearchSortedArray {
  public int search(int[] nums, int target){
    if(nums == null || nums.length == 0) return -1;
    int pivot = getPivot(nums);
    int left = 0, right = nums.length - 1;

    // condition. if the target is greater than pivot elem and less than the right elem, look at the right side else look at left side
    if(target >= nums[pivot] && target <= nums[right]) left = pivot;
    else right = pivot;


    while(left <= right) {
      int mid = (left + right) / 2;
      if(target == nums[mid])
        return mid;
      if(target < nums[mid])
        right = mid - 1;
      else
        left = mid + 1;
    }
    return -1;
  }

  private int getPivot(int[] nums){
    int left = 0, right = nums.length - 1, n = nums.length;

    if(nums[left] < nums[right]) return 0; // if sorted and not rotated return first element

    // how logic works
    while(left < right){
      int mid = (left+right)/2;
      if(nums[mid] > nums[right]) { // means if mid elem > right elem, small elem is in right side
        left = mid + 1;
      } else { // else if mid elem < right elem, the series is increasing to right. which means the small element is in left side
        right = mid;
      }
    }
    return left;
  }

  public static void main(String[] args) {
//    int[] nums = {6,7,0,1,2,3,4,5};
//    int target = 5;
    int[] nums = {1,3};
    int target = 3;
    SearchSortedArray s = new SearchSortedArray();
    System.out.print(s.search(nums, target));
  }
}
