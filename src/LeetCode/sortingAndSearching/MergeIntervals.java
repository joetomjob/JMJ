package LeetCode.sortingAndSearching;

import java.util.*;

class NewComparator implements Comparator<int[]> {
  @Override
  public int compare(int[] a, int[] b) {
    return a[0] < b[0] ? -1 : a[0] == b[0] ? 0 : 1;
  }
}

public class MergeIntervals {

  public int[][] merge(int[][] intervals) {
    Collections.sort(Arrays.asList(intervals), new NewComparator());
    LinkedList<int[]> merged = new LinkedList<>();
    for (int[] interval : intervals) {
      if(merged.isEmpty() || merged.getLast()[1] < interval[0]) {
        merged.addLast(interval);
      } else {
        merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
      }
    }
    return merged.toArray(new int[merged.size()][]);
  }

  public static void main(String[] args) {
    MergeIntervals mergeIntervals = new MergeIntervals();
    int[][] intervals = {{2,3}, {2,2}, {3,3}, {1,3}, {5,7}, {2,2}, {4,6}};
    mergeIntervals.merge(intervals);
  }
}
