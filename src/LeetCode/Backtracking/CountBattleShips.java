package LeetCode.Backtracking;

public class CountBattleShips {
  int[] row = {1, 0, -1, 0};
  int[] col = {0 ,1, 0, -1};
  int n, m;
  char[][] board;
  public int countBattleships(char[][] board) {
    int res = 0;
    this.board = board;
    n = board.length;
    m = board[0].length;

    for (int i = 0; i < n; i++){
      for (int j = 0; j < m; j++) {
        if(board[i][j] == 'X'){
          res++;
          backtrack(i, j);
        }
      }
    }
    return res;
  }
  public void backtrack(int i, int j){
    if(i >= n || j >= m || i < 0 || j < 0  || board[i][j] != 'X')
      return;
    if(board[i][j] == 'X')
      board[i][j] = '.';

    for (int k = 0; k < 4; k++) {
      backtrack(i+row[k], j+ col[k]);
    }
  }

  public int countBattleshipsII(char[][] board) {
    int res = 0;
    this.board = board;
    n = board.length;
    m = board[0].length;

    for (int i = 0; i < n; i++){
      for (int j = 0; j < m; j++) {
        if(board[i][j] == 'X'){
          res++;
          backTrackII(i, j);
        }
      }
    }
    return res;
  }

  public void backTrackII(int i, int j){
    board[i][j] = '.';
    for (int k = 0; k < 4; k++) {
      int nxI = i + row[k];
      int nxJ = j + col[k];
      if(nxI >=0 && nxJ >= 0 && nxI < n && nxJ < m && this.board[nxI][nxJ] == 'X') {
        backTrackII(nxI, nxJ);
      }
    }
  }

  public static void main(String[] args) {
    CountBattleShips c = new CountBattleShips();
    char[][] board = {{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}};
    System.out.println(c.countBattleships(board));
  }
}
