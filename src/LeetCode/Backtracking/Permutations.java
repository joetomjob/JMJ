package LeetCode.Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {
  List<List<Integer>> res;
  public List<List<Integer>> permute(int[] nums){
    res = new ArrayList<>();
    backTrack(nums, new ArrayList<>(), new HashSet<>());
    return res;
  }

  // can use LinkedHashset alone instead of both hashset and list. but that was slower than this
  public void backTrack(int[] nums, List<Integer> curList, HashSet<Integer> curSet) {
    if(curList.size() == nums.length) {
      res.add(new ArrayList<>(curList));
    }

    for (int i = 0; i < nums.length; i++) {
      if(curSet.contains(nums[i])) continue;
      curList.add(nums[i]);
      curSet.add(nums[i]);
      backTrack(nums, curList, curSet);
      curList.remove(curList.size()-1);
      curSet.remove(nums[i]);
    }
  }
  public static void main(String[] args) {
    int[] nums = {1,2,3};
    Permutations p = new Permutations();
    List<List<Integer>> res = p.permute(nums);
    for(List<Integer> l : res) {
      for(Integer i : l) {
        System.out.print(i);
        System.out.print('\t');
      }
      System.out.print('\n');
    }
  }
}
