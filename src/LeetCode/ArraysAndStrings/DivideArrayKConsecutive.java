package LeetCode.ArraysAndStrings;

import java.util.PriorityQueue;
// the question is same as hand of straights. leetcode 846
public class DivideArrayKConsecutive {
  public boolean isPossible(int[] nums, int t){
    PriorityQueue<Integer> q = new PriorityQueue<>();
    for(int n : nums)
      q.add(n);

    while (!q.isEmpty()){
      int cur = q.poll();
      for(int i = 1; i < t; i++){
        if(q.remove(cur+i))
          continue;
        else
          return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    int[] nums = {1,2,3,3,4,4,5,6};
    int k = 4;
    DivideArrayKConsecutive d = new DivideArrayKConsecutive();
    System.out.print(d.isPossible(nums, k));
  }
}
