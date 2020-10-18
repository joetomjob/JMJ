package LeetCode.BloombergPractice;

public class NumberOfIslands {
  int[] rows = {0,1,0,-1}, cols = {1,0,-1,0};
  int row, col, res;
  public int numIslands(char[][] grid) {
    if(grid.length == 0 || grid[0].length == 0) return 0;
    row = grid.length;
    col = grid[0].length;
    res = 0;

    for(int i = 0; i < row; i++) {
      for(int j = 0; j < col; j++){
        if(grid[i][j] == '1') {
          res++;
          backTrack(grid, i, j);
        }
      }
    }
    return res;
  }

  public void backTrack(char[][]grid, int i, int j){
    grid[i][j] = 'a';
    for (int k = 0; k < 4; k++) {
      if(i+rows[k] >= 0 && j+cols[k] >= 0 && i+rows[k] < row && j+cols[k] < col && grid[i+rows[k]][j+cols[k]] == '1')
        backTrack(grid, i+rows[k], j+cols[k]);
    }
    grid[i][j] = '0';
  }
  public static void main(String[] args){

  }
}
