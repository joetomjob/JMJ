package LeetCode.Backtracking;

public class MaxAreaOfIsland {
  int[][] grid;
  int rows, cols, maxArea;
  int[] row = {0,1,0,-1};
  int[] col = {1,0,-1,0};
  public int maxAreaOfIsland(int[][] grid){
    this.grid = grid;
    maxArea = 0;

    if(grid == null || grid.length == 0 || grid[0].length == 0) return maxArea;
    this.rows = grid.length;
    this.cols = grid[0].length;

    for(int i = 0; i < this.rows; i++){
      for(int j = 0; j < this.cols; j++){
        if(this.grid[i][j] == 1)
          maxArea = Math.max(maxArea, backTrack(i, j));
      }
    }

    return maxArea;
  }

  public int backTrack(int i, int j){

    if(i < 0 || i >= this.rows || j < 0 || j >= this.cols || this.grid[i][j] == 0)
      return 0;

    grid[i][j] = 0;

    return 1 + backTrack(i+row[0], j+col[0])+backTrack(i+row[1], j+col[1])
          +backTrack(i+row[2], j+col[2])+backTrack(i+row[3], j+col[3]);
  }

  int curArea;
  public int maxAreaOfIslandII(int[][] grid){
    this.grid = grid;
    maxArea = 0;

    if(grid == null || grid.length == 0 || grid[0].length == 0) return maxArea;
    this.rows = grid.length;
    this.cols = grid[0].length;

    for(int i = 0; i < this.rows; i++){
      for(int j = 0; j < this.cols; j++){
        if(this.grid[i][j] == 1) {
          this.curArea = 0;
          backTrackII(i, j);
          maxArea = Math.max(maxArea, curArea);
        }
      }
    }

    return maxArea;
  }

  public void backTrackII(int i, int j){
    grid[i][j] = 0;
    curArea++;
    for(int k = 0; k < 4; k++) {
      int nextR = i+row[k];
      int nextC = j+col[k];
      if(nextR >=0 && nextR < rows && nextC >= 0 && nextC < cols && grid[nextR][nextC] == 1)
        backTrackII(nextR, nextC);
    }
  }

  public static void main(String[] args){
    MaxAreaOfIsland m = new MaxAreaOfIsland();
    int[][] grid = {
        {0,0,1,0,0,0,0,1,0,0,0,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,1,1,0,1,0,0,0,0,0,0,0,0},
        {0,1,0,0,1,1,0,0,1,0,1,0,0},
        {0,1,0,0,1,1,0,0,1,1,1,0,0},
        {0,0,0,0,0,0,0,0,0,0,1,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,0,0,0,0,0,0,1,1,0,0,0,0}};

    int[][] grid2 = {{1,1,1},{1,0,0}};

//    System.out.print(m.maxAreaOfIsland(grid2));
    System.out.print(m.maxAreaOfIslandII(grid));
  }
}
