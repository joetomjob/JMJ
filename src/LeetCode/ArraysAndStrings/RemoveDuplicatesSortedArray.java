package LeetCode.ArraysAndStrings;

public class RemoveDuplicatesSortedArray {
  public int removeDuplicates(int[] nums) {
    int count = 1;
    int res = nums.length;
    for(int i = 0; i < res; i++) {
      while (i < res-1 && nums[i] == nums[i+1]) {
        ++count;
        i++;
      }
      if(count > 2) {
        int j, k;
        for(j = i - count + 3, k = i+1; k < res; j++, k++) {
          nums[j] = nums[k];
        }
        res -= (count-2);
        i = i - count+2;
      }
      count = 1;
    }
    return res;
  }

  // O(n) method
  public int removeDuplicatesii(int[] nums) {
    int count = 1, j = 1;

    for(int i = 1; i < nums.length; i++) {
      if(nums[i] == nums[i-1]) count++;
      else count = 1;

      if(count <= 2) nums[j++] = nums[i];
    }
    return j;
  }

  public static void main(String[] args) {
    int[] nums = {1,1,1,2,2,2,3,3};
    int[] nums1 = {1,1,1,2,2,2,3,3};
    RemoveDuplicatesSortedArray r = new RemoveDuplicatesSortedArray();
    System.out.println(r.removeDuplicates(nums));
    System.out.println(r.removeDuplicates(nums1));
  }
}
