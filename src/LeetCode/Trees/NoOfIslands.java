package LeetCode.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class NoOfIslands {
  public void dfs(char[][] grid, int r, int c) {
    int nr = grid.length;
    int nc = grid[0].length;

    if(r < 0 || c < 0 || r > nr-1 || c > nc -1 || grid[r][c] == '0') {
      return;
    }

    grid[r][c] = '0';
    dfs(grid, r-1, c);
    dfs(grid, r+1, c);
    dfs(grid, r, c-1);
    dfs(grid, r, c+1);
  }

  // DFS approach
  public int numIslands(char[][] grid) {
    if(grid.length == 0) return 0;
    int nr = grid.length;
    int nc = grid[0].length;
    int num_islands = 0;

    for(int i = 0; i < nr; i++) {
      for(int j = 0; j < nc; j++) {
        if(grid[i][j] == '1') {
          ++num_islands;
          dfs(grid, i, j);
        }
      }
    }
    return num_islands;
  }

  // BFS approach
  public int numIslandsBFS(char[][] grid) {
    if(grid == null || grid.length == 0) return 0;

    int nr = grid.length;
    int nc = grid[0].length;

    int num_islands = 0;

    for(int i = 0; i < nr; i++) {
      for(int j = 0; j < nc; j++) {
        if(grid[i][j] == '1') {
          ++num_islands;
          grid[i][j] = '0';

          Queue<Integer> q = new LinkedList<>();
          q.add(i * nc + j);
          while (!q.isEmpty()) {
            int k = q.poll();
            int r = k/nc;
            int c = k%nc;

            if(r-1 >= 0 && grid[r-1][c] == '1') {
              q.add((r-1) * nc + c);
              grid[r-1][c] = '0';
            }

            if(r+1 < nr && grid[r+1][c] == '1') {
              q.add((r+1) * nc + c);
              grid[r+1][c] = '0';
            }

            if(c-1 >= 0 && grid[r][c-1] == '1') {
              q.add(r * nc + (c-1));
              grid[r][c-1] = '0';
            }

            if(c+1 < nc && grid[r][c=1] == '1') {
              q.add(r * nc + (c+1));
              grid[r][c+1] = '0';
            }
          }
        }
      }
    }
    return num_islands;
  }


  public static void main(String[] args) {
    char[][] a = {{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'},{'0','0','0','1','1'}};
    char[][] b = {{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'},{'0','0','0','1','1'}};
    NoOfIslands n = new NoOfIslands();
    System.out.println(n.numIslands(a));
    System.out.println(n.numIslandsBFS(b));
  }
}
