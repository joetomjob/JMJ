package LeetCode.DynamicProgramming;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class MinCostToMakeOneValidPath {
  public int minCost1(int[][] grid){
    if(grid == null) return 0;
    if(grid.length == 0) return 0;
    if(grid[0].length == 0) return 0;

    int m = grid.length;
    int n = grid[0].length;
    int max = m * n;
    int[][] mem = new int[m][n];
    for(int i = 0; i < m; i++){
      for(int j = 0; j < n; j++){
        mem[i][j] = max;
      }
    }

    mem[0][0] = 0;
    for(int i = 0; i < m; i++){
      for(int j = 0; j < n; j++){
        minCostHelper(grid, mem, i, j, 0);
      }
    }

    return mem[m-1][n-1];
  }

  public int minCostHelper(int[][] grid, int[][] mem, int r, int c, int nexval){
    int m = grid.length;
    int n = grid[0].length;
    int max = m * n;

    if(mem[r][c] != max)
      return mem[r][c] + nexval;

    int[] row = {0,0,-1,11};
    int[] col = {-1,1,0,0};

    for(int i = 0; i < 4; i++){
      if(r + row[i] >= 0 && r + row[i] < m && c + col[i] >= 0 && c + col[i] < n && mem[r+row[i]][c+col[i]] != max){
        int next = grid[r+row[i]][c+col[i]] == i+1 ? 0 : 1;
        mem[r][c] = Math.min(minCostHelper(grid, mem, r+row[i], c+ col[i], next), mem[r][c]);
      }
    }
    return nexval;
  }

  public int minCost(int[][] grid){
    if(grid == null) return 0;
    if(grid.length == 0) return 0;
    if(grid[0].length == 0) return 0;

    int m = grid.length;
    int n = grid[0].length;

    // min heap by cost
    PriorityQueue<int[]> q = new PriorityQueue<>(((o1, o2) -> o1[2] - o2[2]));
    Set<String> visited = new HashSet<>();
    q.add(new int[3]); // the 3 element array is [1, j, cost]. initially the i and j =0 and also cost is 0;

    while (!q.isEmpty()){
      int[] cur = q.poll();
      String curStr = cur[0] + "," + cur[1];

      if(visited.contains(curStr))
        continue;

      visited.add(curStr);

      if(cur[0] == m-1 && cur[1] == n-1)
        return cur[2];

      int[] row = {0,0,1,-1};
      int[] col = {1,-1,0,0};

      for(int i = 0; i < 4; i++){
        int nextR = cur[0]+row[i];
        int nextC = cur[1]+col[i];

        if(nextR < 0 || nextR >= m || nextC < 0 || nextC >= n || visited.contains(nextR+","+nextC))
          continue;

        if(grid[cur[0]][cur[1]] == i+1)
          q.add(new int[] {nextR, nextC, cur[2]});
        else
          q.add(new int[] {nextR, nextC, cur[2]+1});
      }
    }

    return -1;
  }

  public static void main(String[] args){
//    int[][] grid = {{1,1,1,1},{2,2,2,2},{1,1,1,1},{2,2,2,2}};
//    int[][] grid = {{1,1,3},{3,2,2},{1,1,4}};
    int[][] grid = {{2,2,2},{2,2,2}};
    MinCostToMakeOneValidPath m = new MinCostToMakeOneValidPath();
    System.out.print(m.minCost(grid));
  }
}
