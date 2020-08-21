package LeetCode.ArraysAndStrings;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
  public int[][] insert(int[][] intervals, int[] newInterval){
    List<int[]> res = new ArrayList<>();
    for(int[] interval : intervals){
      if(newInterval ==null || interval[1] < newInterval[0])
        res.add(interval);
      else if(newInterval[1] < interval[0]){
        res.add(newInterval);
        newInterval = null;
        res.add(interval);
      } else {
        newInterval[0] = Math.min(interval[0], newInterval[0]);
        newInterval[1] = Math.max(interval[1], newInterval[1]);
      }
    }
    int[][] resA = new int[res.size()][2];
    if(newInterval == null) return res.toArray(resA);
    res.add(newInterval);
    return res.toArray(resA);
  }

  public static void main(String[] args){
//    int[][] intervals = {{1,3}, {6,9}};
//    int[] newInterval = {2,5};

    int[][] intervals = {{1,2}, {3,5}, {6,7},{8,10},{12,16}};
    int[] newInterval = {4,8};

    InsertInterval i = new InsertInterval();
    int[][] res = i.insert(intervals, newInterval);
    for(int[] k : res){
      for(int j : k){
        System.out.print(j);
        System.out.print('\t');
      }
      System.out.print('\n');
    }
  }
}
