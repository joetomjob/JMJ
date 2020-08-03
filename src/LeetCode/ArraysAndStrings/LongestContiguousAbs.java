package LeetCode.ArraysAndStrings;

import java.util.Deque;
import java.util.LinkedList;

public class LongestContiguousAbs {
  public int longestSubrray(int[] nums, int limit){
    int ans = 1, i = 0;
    Deque<Integer> max = new LinkedList<>();
    Deque<Integer> min = new LinkedList<>();

    for(int j = 0; j < nums.length; j++){
      while (!max.isEmpty() && max.peekLast() < nums[j]){
        max.removeLast();
      }
      max.addLast(nums[j]);

      while (!min.isEmpty() && min.peekLast() > nums[j]){
        min.removeLast();
      }
      min.addLast(nums[j]);

      while (max.peekFirst() - min.peekFirst() > limit){
        if(max.peekFirst() == nums[i]) max.pollFirst();
        if(min.peekFirst() == nums[i]) min.pollFirst();
        i++;
      }

      ans = Math.max(ans, j - i + 1);
    }
    return ans;
  }

  public static void main(String[] args){

  }
}
