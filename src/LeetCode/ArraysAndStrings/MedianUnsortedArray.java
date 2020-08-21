package LeetCode.ArraysAndStrings;

public class MedianUnsortedArray {
  public double median(int[] nums){
    int l = 0, r = nums.length - 1;
    while (l <= r){
      int mid = medianHelper(nums, l, r);
      if(mid == nums.length/2) {
        if(nums.length%2 == 1)
          return (double) nums[mid];
        else
          return (double)(nums[mid]+nums[mid+1])/2.0;
      } else if(mid < nums.length/2)
        l = mid+1;
      else
        r = mid-1;
    }
    return -1;
  }

  public int medianHelper(int[] nums, int start, int end){
    int pivot = nums[end];
    int s = start;
    for(int i = start; i < end; i++){
      if(nums[i] <= pivot){
        int temp = nums[i];
        nums[i] = nums[s];
        nums[s] = temp;
        s++;
      }
    }
    nums[end] = nums[s];
    nums[s] = pivot;

    return pivot;
   }

  public static void main(String[] args){
    MedianUnsortedArray m = new MedianUnsortedArray();
    int[] nums = {6,2,9,2,3,18,12,11,5,4};
    System.out.print(m.median(nums));
  }
}
