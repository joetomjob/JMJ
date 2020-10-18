package LeetCode.ArraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
  List<List<Integer>> res;
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    res = new ArrayList<>();
    Arrays.sort(nums);
    backTrack(nums, 0, new ArrayList<>());
    return res;
  }

  public void backTrack(int[] nums, int curIndex, List<Integer> curList) {
    res.add(new ArrayList<>(curList));

    for (int i = curIndex; i < nums.length; i++) {
      if(i > curIndex && nums[i] == nums[i-1]) continue;
      curList.add(nums[i]);
      backTrack(nums, i+1, curList);
      curList.remove(curList.size() - 1);
    }
  }

  public static void main(String[] args) {
    SubsetsII s = new SubsetsII();
    int[] nums = {1,2,2};
    List<List<Integer>> res = s.subsetsWithDup(nums);
    for (List<Integer> l : res) {
      for(Integer i : l) {
        System.out.print(i);
        System.out.print('\t');
      }
      System.out.print('\n');
    }
  }
}
