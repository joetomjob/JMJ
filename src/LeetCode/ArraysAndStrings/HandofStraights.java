package LeetCode.ArraysAndStrings;

import java.util.PriorityQueue;

public class HandofStraights {
  public boolean isNStraightHand(int[] hand, int W) {
    PriorityQueue<Integer> q = new PriorityQueue<>();
    for(int i : hand){
      q.add(i);
    }

    while (!q.isEmpty()){
      int val = q.poll();
      for(int i = 1; i < W; i++){
        if(q.remove(val+i))
          continue;
        else
          return false;
      }
    }
    return true;
  }
  public static void main(String[] args){
    int[] hand = {1,2,3,6,2,3,4,7,8};
    int W = 3;
    HandofStraights h = new HandofStraights();
    System.out.println(h.isNStraightHand(hand, W));
  }
}
