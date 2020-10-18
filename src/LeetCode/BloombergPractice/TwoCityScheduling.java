package LeetCode.BloombergPractice;

import java.util.Arrays;
import java.util.Comparator;

public class TwoCityScheduling {
  public int twoCitySchedCost(int[][] costs) {
    Arrays.sort(costs, new Comparator<int[]>() {
      @Override
      public int compare(int[] a, int[] b){
        return (a[0] - a[1]) - (b[0] - b[1]);
      }
    });

    int n = costs.length / 2, res = 0;
    for (int i = 0; i < n; i++) {
      res += costs[i][0] + costs[n+i][1];
    }
    return res;
  }
  public static void main(String[] args){

  }
}
