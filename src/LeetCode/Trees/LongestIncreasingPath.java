package LeetCode.Trees;

public class LongestIncreasingPath {
  int res = 0, m, n;
  int[][] matrix;
  int[][] cache;
  public int longestIncreasingPath(int[][] matrix){
    if(matrix.length == 0 || matrix[0].length==0)
      return 0;
    this.m = matrix.length;
    this.n = matrix[0].length;
    this.matrix = matrix;
    this.cache = new int[m][n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        res = Math.max(res, dfs(i,j, cache));
      }
    }
    return res;
  }

  public int dfs(int r, int c, int[][] cache){
    if(cache[r][c] != 0)
      return cache[r][c];
    int[] row = {0, 1, 0, -1};
    int[] col = {1, 0 , -1, 0};

    for (int i = 0; i < 4; i++) {
      if(r+row[i] >= 0 && r+row[i] < this.m && c+col[i] >= 0 && c+col[i] < this.n && this.matrix[r][c] > this.matrix[r+row[i]][c+col[i]])
        cache[r][c] = Math.max(cache[r][c], dfs(r+row[i], c+col[i], cache));
    }
    return ++cache[r][c];
  }

  public static void main(String[] args){
//    int[][] matrix = {{9,9,4},{6,6,8},{2,1,1}};
    int[][] matrix = {
      {0,1,2,3,4,5,6,7,8,9},
      {19, 18, 17, 16, 15, 14, 13, 12, 11, 10},
      {20,21,22,23,24,25,26,27,28,29},
      {39,38,37,36,35,34,33,32,31,30},
      {40,41,42,43,44,45,46,47,48,49},
      {59,58,57,56,55,54,53,52,51,50},
      {60,61,62,63,64,65,66,67,68,69},
      {79,78,77,76,75,74,73,72,71,70},
      {80,81,82,83,84,85,86,87,88,89},
      {99,98,97,96,95,94,93,92,91,90},
      {100,101,102,103,104,105,106,107,108,109},
      {119,118,117,116,115,114,113,112,111,110},
      {120,121,122,123,124,125,126,127,128,129},
      {139,138,137,136,135,134,133,132,131,130},
      {0,0,0,0,0,0,0,0,0,0}
    };
    LongestIncreasingPath l = new LongestIncreasingPath();
    System.out.print(l.longestIncreasingPath(matrix));
  }
}
