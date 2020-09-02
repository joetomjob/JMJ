package LeetCode.Trees;

import java.util.ArrayList;
import java.util.List;

public class AllPathFromSouceToTarget {
  List<List<Integer>> res = new ArrayList<>();
  int n;
  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    List<List<Integer>> g = new ArrayList<>();
    n = graph.length;
    for (int[] gr : graph) {
      List<Integer> temp = new ArrayList<>();
      for (int i : gr)
        temp.add(i);
      g.add(new ArrayList<>(temp));
    }

    backtrack(g, new ArrayList<>(), 0);
    return res;
  }

  public void backtrack(List<List<Integer>> graph, List<Integer> temp, int cur){
    temp.add(cur);
    if(cur == n - 1)
      res.add(new ArrayList<>(temp));
    for(Integer i : graph.get(cur)){
      backtrack(graph, temp, i);
      temp.remove(temp.size() - 1);
    }
  }

  public static void main(String[] args) {
    int[][] graph = {{1,2},{3},{3},{}};
    AllPathFromSouceToTarget a = new AllPathFromSouceToTarget();
    a.allPathsSourceTarget(graph);
  }
}
