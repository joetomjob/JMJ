package LeetCode.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MostSimilarPathInGraph {
  int[][] visited;
  int[][] nextbest;
  String[] target;
  String[] names;
  List<List<Integer>> matrix;
  public List<Integer> mostSimilar(int n, int[][] roads, String[] names, String[] targetPath){
    this.target = targetPath;
    this.names = names;

    // visited for memoization. if we already covered the path. no need to traverse again.
    visited = new int[names.length][targetPath.length];
    for(int[] v : visited) Arrays.fill(v, -1);

    // store the next best choice for a location
    nextbest = new int[names.length][targetPath.length];

    // idea: Start from all the points and find the best path.
    // create an adjacency matrix for saving the graph.
    matrix = new ArrayList<>();
    for(int i = 0; i < n; i++) matrix.add(new ArrayList<>());
    for(int[] road : roads){
      matrix.get(road[0]).add(road[1]);
      matrix.get(road[1]).add(road[0]);
    }

    int min = Integer.MAX_VALUE;
    int start = 0; // once we get the start by dfs, we construct the result using nextbest
    for(int i = 0; i < names.length; i++){
      // the dfs returns the cost of the best path that can be reached by starting from nameIndex.
      int res = dfs(i, 0);
      if(res < min){
        start = i;
        min = res;
      }
    }

    List<Integer> res = new ArrayList<>();
    for(int i = 0; i < targetPath.length; i++){
      res.add(start);
      start = nextbest[start][res.size()-1]; // nextbest save the neighbor value
    }

    return res;
  }

  // curIndex represents the index in target. to identify whether we reached the target length.
  // the dfs returns the cost of the best path that can be reached by starting from nameIndex.
  public int dfs(int nameIndex, int curIndex){
    if(visited[nameIndex][curIndex] != -1) return visited[nameIndex][curIndex];

    int cost = names[nameIndex].equals(target[curIndex]) ? 0 : 1;

    if(curIndex == target.length-1) return cost; // once we reach the number of hops, return the cost;

    // choose the minimum from all neighbors
    int min = Integer.MAX_VALUE;
    for(int i : this.matrix.get(nameIndex)){
      int res = dfs(i, curIndex+1);
      if(res < min) { // choose the minimum from all neighbors
        min = res;
        nextbest[nameIndex][curIndex] = i;
      }
    }

    cost += min;
    visited[nameIndex][curIndex] = cost;
    return cost;
  }
  public static void main(String[] args){
    int n = 6;
    int[][] roads = {{0,1},{1,2},{2,3},{3,4},{4,5}};
    String[] names = {"ATL","PEK","LAX","ATL","DXB","HND"};
    String[] targetPath = {"ATL","DXB","HND","DXB","ATL","LAX","PEK"};
    MostSimilarPathInGraph m = new MostSimilarPathInGraph();
    List<Integer> res = m.mostSimilar(n, roads, names, targetPath);
    for (int i = 0; i < res.size(); i++) {
      System.out.print(res.get(i));
      System.out.print('\t');
    }
  }
}
