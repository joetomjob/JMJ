package LeetCode.DynamicProgramming;

import java.util.HashMap;

public class TwoNonOverlappingSumK {
  public int minOfLengths(int[] arr, int target){
    int sum = 0, l = Integer.MAX_VALUE, res = Integer.MAX_VALUE;
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);
    for(int i = 0; i < arr.length; i++){
      sum += arr[i];
      map.put(sum, i);
    }

    sum = 0;
    for(int i = 0; i < arr.length; i++){
      sum += arr[i];
      if(map.containsKey(sum-target))
        l = Math.min(l, i - map.get(sum - target));
      if(map.containsKey(sum+target) && l < Integer.MAX_VALUE)
        res = Math.min(res, map.get(sum+target) - i + l);
    }
    return res == Integer.MAX_VALUE ? -1 : res;
  }
  public static void main(String[] args){
    TwoNonOverlappingSumK tn = new TwoNonOverlappingSumK();
    int[] arr = {3, 2, 2, 4, 3};
    int t = 3;
    System.out.print(tn.minOfLengths(arr, t));
  }
}
