package LeetCode.ArraysAndStrings;

public class MedianSortedArrays {
  public double findMedianSortedArrays(int[] nums1, int[] nums2){
    if(nums2.length < nums1.length)
      return findMedianSortedArrays(nums2, nums1);

    int x = nums1.length;
    int y = nums2.length;

    int low = 0;
    int high = x;

    while(low <= high){
      int mid1 = (low+high)/2;
      int mid2 = (x+y+1)/2 - mid1;

      int maxleft1 = mid1 == 0 ? Integer.MIN_VALUE : nums1[mid1-1];
      int minright1 = mid1 == x ? Integer.MAX_VALUE: nums1[mid1];

      int maxleft2 = mid2 == 0 ? Integer.MIN_VALUE : nums2[mid2-1];
      int minright2 = mid2 == y ? Integer.MAX_VALUE : nums2[mid2];

      if(maxleft1 <= minright2 && maxleft2 <= minright1){
        if((x+y)%2 == 0){
          return ((double)(Math.max(maxleft1, maxleft2) + Math.min(minright1, minright2)))/2;
        } else {
          return (double)Math.max(maxleft1, maxleft2);
        }
      } else if(maxleft1 > minright2) {
        high = mid1-1;
      } else {
        low = mid1+1;
      }
    }
    return -1;
  }
  public static void main(String[] args){
    int[] nums1 = {1,3};
    int[] nums2 = {2};
    MedianSortedArrays m = new MedianSortedArrays();
    System.out.print(m.findMedianSortedArrays(nums1, nums2));
  }
}
