package LeetCode.ArraysAndStrings;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {
  public List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> res = new ArrayList<>();
    int[] temp = new int[nums.length+1];
    for(int i : nums){
      temp[i]++;
    }
    for(int i = 1; i < temp.length; i++){
      if(temp[i] == 0){
        res.add(i);
      }
    }
    return res;
  }


  public List<Integer> findDisappearedNumbersII(int[] nums){
    List<Integer> res = new ArrayList<>();
    for(int i : nums) {
      int index = Math.abs(i);
      nums[index - 1] = -Math.abs(nums[index - 1]);
    }

    for(int i = 0; i < nums.length; i++){
      if(nums[i] > 0) res.add(i+1);
    }
    return res;
  }

  public static void main(String[] args){
    int[] nums = {4,3,2,7,8,2,3,1};
    FindDisappearedNumbers f = new FindDisappearedNumbers();
    List<Integer> list = f.findDisappearedNumbers(nums);
    for(Integer i : list) {
      System.out.print(i);
      System.out.print('\t');
    }
    System.out.print('\n');

    list = f.findDisappearedNumbersII(nums);
    for(Integer i : list) {
      System.out.print(i);
      System.out.print('\t');
    }
  }
}
