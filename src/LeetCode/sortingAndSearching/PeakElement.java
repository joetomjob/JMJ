package LeetCode.sortingAndSearching;

public class PeakElement {
  public int findPeakElementRecursive(int[] nums) {
    return searchRec(nums, 0, nums.length-1);
  }

  public int searchRec(int[] nums, int l, int r) {
    if(l == r) {
      return l;
    }

    int mid = (l+r) / 2;

    if(nums[mid] > nums[mid+1]) {
      return searchRec(nums, l, mid);
    } else {
      return searchRec(nums, mid+1, r);
    }
  }

  public int findPeakElementIterative(int[] nums) {
    int l = 0, r = nums.length - 1;
    while (l < r) {
      int mid = (l+r)/2;

      if(nums[mid] > nums[mid+1]){
        r = mid;
      } else {
        l = mid+1;
      }
    }
    return l;
  }

  public int searchIte(int[] nums, int l, int r) {
    while (l < r) {
      int mid = (l+r)/2;

      if(nums[mid] > nums[mid+1]){
        r = mid-1;
      } else {
        l = mid+1;
      }
    }
    return l;
  }

  public static void main(String[] args) {
    int nums[] = {1,2,1,3,5,6,4};
    PeakElement p = new PeakElement();
    System.out.println(p.findPeakElementIterative(nums));
    System.out.println(p.findPeakElementRecursive(nums));


  }
}
