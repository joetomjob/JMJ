package LeetCode.Backtracking;

public class CountBattleShips {
  public int countBattleships(char[][] board) {
    int res = 0;
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board[0].length; j++) {
        if(board[i][j] == 'X'){
          res++;
          backtrack(board, i, j);
        }
      }
    }
    return res;
  }
  public void backtrack(char[][] board, int i, int j){
    int n = board.length;
    int m = board[0].length;
    if(i >= n || j >= m || i < 0 || j < 0  || board[i][j] != 'X')
      return;
    if(board[i][j] == 'X')
      board[i][j] = '.';

    int[] row = {1, 0, -1, 0};
    int[] col = {0 ,1, 0, -1};
    for (int k = 0; k < 4; k++) {
      backtrack(board, i+row[k], j+ col[k]);
    }
  }
  public static void main(String[] args) {
    CountBattleShips c = new CountBattleShips();
    char[][] board = {{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}};
    System.out.println(c.countBattleships(board));
  }
}
