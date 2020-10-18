package LeetCode.BloombergPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPathToTarget {
  List<List<Integer>> adjList = new ArrayList<>();
  int n;
  List<List<Integer>> res = new ArrayList<>();
  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    List<Integer> temp;
    this.n = graph.length;
    for(int[] i : graph){
      temp = new ArrayList<>();
      for(int j : i) temp.add(j);
      adjList.add(temp);
    }
    backTrack(0, new ArrayList<>());
    return res;
  }

  public void backTrack(int cur, List<Integer> temp){
    temp.add(cur);
    if(cur == this.n-1) res.add(new ArrayList<Integer>(temp));
    for (Integer i : adjList.get(cur)){
      backTrack(i, temp);
      temp.remove(temp.size() - 1);
    }
  }
  public static void main(String[] args) {

  }
}
