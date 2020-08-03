package LeetCode.ArraysAndStrings;

public class MergedSortedArrays {
  public void merge(int[] nums1, int m, int[] nums2, int n){
    int i = m-1, j = n-1, end = m+n-1;
    while (i >= 0 && j >= 0){
      nums1[end--] = nums1[i] < nums2[j] ? nums2[j--] : nums1[i--];
    }
    while (j>=0){
      nums1[end--] = nums2[j--];
    }
  }
  public static void main(String[] args){
    MergedSortedArrays m = new MergedSortedArrays();
    int[] nums1 = {1,2,3,0,0,0};
    int[] nums2 = {2, 5, 6};
    m.merge(nums1, 3, nums2, nums2.length);

  }
}
