package LeetCode.ArraysAndStrings;

import java.util.*;

public class SmallerNumbersThanCurrent {
  public int[] smallerNumbersThanCurrent(int[] nums){
    HashMap<Integer, Integer> map = new HashMap<>();
    HashMap<Integer, Integer> newMap = new HashMap<>();
    for(int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);
    List<Integer> keys = new ArrayList<>(map.keySet());
    Collections.sort(keys, (a,b) -> a - b);
    for(int i = 0; i < keys.size(); i++){
      if(i == 0) newMap.put(keys.get(i), 0);
      else newMap.put(keys.get(i), newMap.get(keys.get(i-1)) + map.get(keys.get(i-1)));
    }

    for(int i = 0; i < nums.length; i++) {
      nums[i] = newMap.get(nums[i]);
    }
    return nums;
  }

  public static void main(String[] args){
    int[] nums = {8,1,2,2,3};
    SmallerNumbersThanCurrent s = new SmallerNumbersThanCurrent();
    int[] res = s.smallerNumbersThanCurrent(nums);
    for(int i : res){
      System.out.print(i);
      System.out.print('\t');
    }
  }
}
