package LeetCode.DynamicProgramming;

public class UniquePathsII {
  public int UniquePathsWithObstacles(int[][] obstacleGrid){
    int r = obstacleGrid.length;
    int c = obstacleGrid[0].length;

    for(int i = 0; i < r; i++){
      for(int j = 0; j < c; j++){
        if(i == 0 && j == 0){
          if(obstacleGrid[i][j] == 0) obstacleGrid[i][j] = 1;
          else obstacleGrid[i][j] = 0;
        } else if (i == 0){
          if(obstacleGrid[i][j] == 0) obstacleGrid[i][j] = obstacleGrid[i][j-1];
          else obstacleGrid[i][j] = 0;
        } else if (j == 0){
          if(obstacleGrid[i][j] == 0) obstacleGrid[i][j] = obstacleGrid[i-1][j];
          else obstacleGrid[i][j] = 0;
        } else {
          if (obstacleGrid[i][j] == 0) obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
          else obstacleGrid[i][j] = 0;
        }
      }
    }

    return obstacleGrid[r-1][c-1];
  }

  public static void main(String[] args){
    int[][] grid = {{0,0,0},{0,1,0},{0,0,0}};
    UniquePathsII u = new UniquePathsII();
    System.out.println(u.UniquePathsWithObstacles(grid));
  }
}
