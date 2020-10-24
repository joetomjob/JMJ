package LeetCode.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class PermutationsII {
  List<List<Integer>> res;
  public List<List<Integer>> permuteUnique(int[] nums) {
    res = new ArrayList<>();
    Arrays.sort(nums);
    backTrack(nums, new ArrayList<>(), new boolean[nums.length]);
    return res;
  }

  public void backTrack(int[] nums, List<Integer> curList, boolean[] used) {
    if(curList.size() == nums.length) {
      res.add(new ArrayList<>(curList));
      return;
    }

    for(int i = 0; i < nums.length; i++) {
      if(used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i-1])) continue;
      curList.add(nums[i]);
      used[i] = true;
      backTrack(nums, curList, used);
      curList.remove(curList.size()-1);
      used[i] = false;
    }
  }

  public static void main(String[] args){
    int[] nums = {1,1,2};
    PermutationsII p = new PermutationsII();
    List<List<Integer>> res = p.permuteUnique(nums);
    for(List<Integer> l : res) {
      for(Integer i : l) {
        System.out.print(i);
        System.out.print('\t');
      }
      System.out.print('\n');
    }
  }
}
