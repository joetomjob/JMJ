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

  // another approach
//  public int triangleNumberII(int[] nums){
//    if(nums.length < 3) return 0;
//
//    res = 0;
//    Arrays.sort(nums);
//
//    int l = 0, r = 2;
//  }

  public static void main(String[] args){
//    int[] nums = {2,2,3,4};
    int[] nums = {0,1,1,1};
    ValidTriangleNumber v = new ValidTriangleNumber();
    System.out.print(v.triangleNumber(nums));
  }
}
