package LeetCode.ArraysAndStrings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TwoCityScheduling {
  public int twoCitySchedCost(int[][] costs){
    Arrays.sort(costs, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0]-o1[1] - (o2[0]-o2[1]);
      }
    });

    int n = costs.length/2, total = 0;
    for(int i = 0; i < n; i++){
      total += costs[i][0] + costs[i+n][1];
    }
    return total;
  }

  public int twoCitySchedCostHeap(int[][] costs){
    PriorityQueue<int[]> p = new PriorityQueue<int[]>(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0]-o1[1] - (o2[0] - o2[1]);
      }
    });

    int n = costs.length/2, total = 0;
    for(int i = 0; i < costs.length; i++){
      p.add(costs[i]);
    }

    for (int i = 0; i < n; i++) {
      total += p.poll()[0];
    }
    for (int i = 0; i < n; i++) {
      total += p.poll()[1];
    }
    return total;
  }
  public static void main(String[] args){
    TwoCityScheduling t = new TwoCityScheduling();
    int[][] costs = {{10,20},{30,200},{400,50},{30,20}};
//    System.out.println(t.twoCitySchedCost(costs));
    System.out.println(t.twoCitySchedCostHeap(costs));
  }
}
