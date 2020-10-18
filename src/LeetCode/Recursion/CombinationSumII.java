package LeetCode.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
  List<List<Integer>> res;
  int[] candidates;
  int target;
  public List<List<Integer>> combinationSumII(int[] candidates, int target){
    this.res = new ArrayList<>();
    this.candidates = candidates;
    Arrays.sort(this.candidates);
    this.target = target;

    backTrack(new ArrayList<Integer>(), 0, 0);
    return res;
  }

  public void backTrack(List<Integer> curList, int curSum, int curIndex) {
    if(curSum == target) {
      res.add(new ArrayList<>(curList));
      return;
    }

    if(curSum > target || curIndex >= candidates.length) return;

    for(int i = curIndex; i < candidates.length; i++) {
      if(i > curIndex && candidates[i] == candidates[i-1]) continue;
      curList.add(candidates[i]);
      backTrack(curList, curSum+candidates[i], i+1);
      curList.remove(curList.size() - 1);
    }
  }


  public static void main(String[] args) {
    int[] candidates = {10,1,2,7,6,1,5};
    int target = 8;

    CombinationSumII c = new CombinationSumII();
    List<List<Integer>> res = c.combinationSumII(candidates, target);
    for(List<Integer> l : res) {
      for(Integer i : l ) {
        System.out.print(i);
        System.out.print('\t');
      }
      System.out.print('\n');
    }
  }
}
