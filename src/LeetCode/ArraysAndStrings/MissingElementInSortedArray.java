package LeetCode.ArraysAndStrings;

public class MissingElementInSortedArray {
  public int missingElement(int[] nums, int k){
    int[] mem = new int[nums.length];
    mem[0] = 0;
    // build an array to see how many elements are missing till an index in array
    for(int i = 1; i < nums.length; i++){
      mem[i] = mem[i-1] + nums[i] - nums[i-1] - 1;
    }
    int i = 0;
    while (i < nums.length && mem[i] < k)
      i++;

    return nums[i-1]+k-mem[i-1];
  }

  // one pass
  public int missingElementOnePass(int[] nums, int k){
    int prevM = 0, curM = 0, i = 1;
    while (i < nums.length){
      prevM = curM;
      curM = prevM + nums[i] - nums[i-1] - 1;
      if(curM >=k) {
        return nums[i-1] + k - prevM;
      }
      i++;
    }
    return nums[i-1] + k - curM;
  }

  // binary search
  public int missingTillIndex(int index, int[] nums){
    return nums[index] - nums[0] - index;
  }

  public int missingElementBinary(int[] nums, int k){
    int l = 0, r = nums.length - 1;
    if(k > missingTillIndex(nums.length - 1, nums))
      return nums[nums.length - 1] + k - missingTillIndex(nums.length - 1, nums);
    while (l != r){
      int mid = (l + r)/2;
      if(missingTillIndex(mid, nums) < k) {
        l = mid + 1;
      } else {
        r = mid;
      }
    }
    // nums[l] will have k elements missing till index l. so the missing number will be between nums[l-1] and nums[l]
    // so get the no of missing elements till nums[l-1]. nums[l-1] + k - number of missing elements till nums[l-1] will be the answer.
    return nums[l-1] + k - missingTillIndex(l-1, nums);
  }

  public static void main(String[] args){
    int[] nums = {4,7,9,10};
    MissingElementInSortedArray m = new MissingElementInSortedArray();
    System.out.println(m.missingElement(nums, 3));
    System.out.println(m.missingElementOnePass(nums, 3));
    System.out.println(m.missingElementBinary(nums, 3));
  }
}
