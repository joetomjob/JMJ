package LeetCode.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidTriangleNumber {

  int res;
  public int triangleNumber(int[] nums){
    res = 0;
    backtrack(nums, new ArrayList<>(), 0);
    return res;
  }

  // worst. worse that o(n^3)
  public void backtrack(int[] nums, List<Integer> list, int index){
    if(list.size() == 3){
      if(isTriangle(list)) res++;
      return;
    }

    for (int i = index; i < nums.length; i++) {
      list.add(nums[i]);
      backtrack(nums, list, i+1);
      list.remove(list.size()-1);
    }
  }

  public boolean isTriangle(List<Integer> sides){
    return sides.get(0)+sides.get(1) > sides.get(2)
        && sides.get(1)+sides.get(2) > sides.get(0)
        && sides.get(0)+sides.get(2) > sides.get(1);
  }

  //// O(n^2 logn)
  // another approach: sort numbers. if numbers sorted, then we just need to check first 2 numbers in triplet. consider sorted
  // array [a, b, c]. if a+b > c, then it is evident that c+a > b and c+b > a as they are sorted.
  public int triangleNumberII(int[] nums){
    int res1 = 0;
    Arrays.sort(nums);
    for(int i = 0; i < nums.length - 2; i++) {
      int k = i+2;
      for(int j = i+1; j < nums.length - 1 && nums[i] != 0; j++){
        k = binarySearch(nums, k, nums.length-1, nums[i]+nums[j]);
        res1 += k - j - 1;
      }
    }
    return res1;
  }

  // here parameter x is the number to be compared with the element in array. x = a+b and we need to find an element in array
  // where c just greater than x => (a+b). so for all elements less than c, the property x>c will satisfy.
  public int binarySearch(int[] nums, int l, int r, int x){
    while(l <= r){
      int mid = (l + r)/2;
      if(x > nums[mid])  l = mid+1;
      else r = mid-1;
    }
    return l;
  }


  // O(n^2)
  public int triangleNumberIII(int[] nums){
    int res1 = 0;
    Arrays.sort(nums);

    for(int i = 0; i < nums.length - 2; i++) {
      int k = i+2;
      for(int j = i+1; j < nums.length - 1 && nums[i] != 0; j++){
        while (k < nums.length && nums[i]+nums[j] > nums[k])
          k++;
        res1 += k-j-1;
      }
    }
    return res1;
  }

  public static void main(String[] args){
//    int[] nums = {2,2,3,4};
    int[] nums = {0,1,1,1};
    ValidTriangleNumber v = new ValidTriangleNumber();
    System.out.print(v.triangleNumber(nums));
  }
}
