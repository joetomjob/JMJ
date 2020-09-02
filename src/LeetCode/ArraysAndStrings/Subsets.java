package LeetCode.ArraysAndStrings;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
  List<List<Integer>> res = new ArrayList<>();
  public List<List<Integer>> subsets(int[] nums){
    backtrack(nums, 0, new ArrayList<Integer>());
    return res;
  }

  public void backtrack(int[] nums, int index, ArrayList<Integer> curList){
    res.add(new ArrayList<>(curList));
    for(int i = index; i < nums.length; i++){
      curList.add(nums[i]);
      backtrack(nums, i+1, curList);
      curList.remove(curList.size()-1);
    }
  }

  public static void main(String[] args){
    int[] nums = {1,2,3,4};
    Subsets s = new Subsets();
    List<List<Integer>> res = s.subsets(nums);
    for (int i = 0; i < res.size(); i++) {
      for (int j = 0; j < res.get(i).size(); j++) {
        System.out.print(res.get(i).get(j));
        System.out.print('\t');
      }
      System.out.print('\n');
    }
  }
}
