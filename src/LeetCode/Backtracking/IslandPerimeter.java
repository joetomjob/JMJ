package LeetCode.Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class IslandPerimeter {
  int res, m ,n;
  // O(mn) time and O(mn) space
  public int islandPerimeter(int[][] graph){
    res = 0;
    m = graph.length;
    n = graph[0].length;
    List<int[]> set = new ArrayList<>();

    for(int i = 0; i < m; i++){
      for(int j = 0; j < n; j++){
        if(graph[i][j] == 1) {
          set.add(new int[]{i,j});
        }
      }
    }

    for(int[] arr : set){
      checkNeighbors(graph, arr[0], arr[1]);
    }
    return res;
  }

  // O(mn) time and O(1) space
  public int islandPerimeterII(int[][] graph){
    res = 0;
    m = graph.length;
    n = graph[0].length;

    for(int i = 0; i < m; i++){
      for(int j = 0; j < n; j++){
        if(graph[i][j] == 1) {
          checkNeighbors(graph, i, j);
        }
      }
    }

    return res;
  }

  public void checkNeighbors(int[][] graph, int i, int j){
    if(i == 0) res++;
    if(i == m-1) res++;
    if(j == 0) res++;
    if(j == n-1) res++;
    // top
    if(i-1 >= 0 && graph[i-1][j] == 0) res++;
    // bottom
    if(i+1 < m && graph[i+1][j] == 0) res++;
    // right
    if(j+1 < n && graph[i][j+1] == 0) res++;
    // left
    if(j-1 >= 0 && graph[i][j-1] == 0) res++;
  }

  public static void main(String[] args){
    int[][] graph = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
    IslandPerimeter i = new IslandPerimeter();
    System.out.print(i.islandPerimeterII(graph));
  }
}
