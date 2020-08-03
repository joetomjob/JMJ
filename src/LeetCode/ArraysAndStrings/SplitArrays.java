package LeetCode.ArraysAndStrings;

import java.util.HashMap;

public class SplitArrays {
  public boolean isPossible(int[] nums){
    HashMap<Integer, Integer> map = new HashMap<>();
    HashMap<Integer, Integer> temp = new HashMap<>();

    for(int i : nums){
      map.put(i, map.getOrDefault(i, 0)+1);
    }

    for (int i : nums) {
      if(map.get(i) == 0) continue;
      else if(temp.getOrDefault(i, 0) > 0){
        temp.put(i, temp.get(i) - 1);
        temp.put(i+1, temp.getOrDefault(i+1, 0) + 1);
      } else if(map.getOrDefault(i+1, 0) > 0 && map.getOrDefault(i+2, 0) > 0){
        map.put(i+1, map.get(i+1) - 1);
        map.put(i+2, map.get(i+2) - 1);
        temp.put(i+3, temp.getOrDefault(i+3, 0)+1);
      } else return false;
      map.put(i, map.get(i) - 1);
    }
    return true;
  }

  public static void main(String[] args){
    int[] nums = {1,2,3,3,4,4,5,5};
    SplitArrays s = new SplitArrays();
    System.out.println(s.isPossible(nums));
  }
}
