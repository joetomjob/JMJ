package LeetCode.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
  List<List<Integer>> res;
  public List<List<Integer>> combinationSum(int[] candidates, int target){
    res = new ArrayList<>();
    backTrack(candidates, target, new ArrayList<>(), 0, 0);
    return res;
  }

  public void backTrack(int[] candidates, int target, List<Integer> curList, int curSum, int curIndex) {
    if(curSum == target) res.add(new ArrayList<>(curList));

    if(curSum > target) return;

    for(int i = curIndex; i < candidates.length; i++) {
      curList.add(candidates[i]);
      backTrack(candidates, target, curList, curSum+candidates[i], i);
      curList.remove(curList.size() - 1);
    }
  }

  public static void main(String[] args){
    int[] candidates = {2,3,6,7};
    int target = 7;
    CombinationSum c = new CombinationSum();
    List<List<Integer>> res = c.combinationSum(candidates, target);
    for(List<Integer> l : res) {
      for(Integer i : l) {
        System.out.print(i);
        System.out.print('\t');
      }
      System.out.print('\n');
    }
  }
}
