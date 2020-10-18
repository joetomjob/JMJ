package LeetCode.BloombergPractice;

public class CandyCrush {
  public int[][] candyCrush(int[][] board){
    int rows = board.length;
    int cols = board[0].length;
    boolean todo = false;

    // rows
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j+2 < cols; j++) {
        int x = Math.abs(board[i][j]);
        if(x != 0 && x == Math.abs(board[i][j+1]) && x == Math.abs(board[i][j+2])) {
          todo = true;
          board[i][j] = board[i][j + 1] = board[i][j + 2] = -x;
        }
      }
    }

    // cols
    for (int i = 0; i+2 < rows; i++) {
      for (int j = 0; j < cols; j++) {
        int x = Math.abs(board[i][j]);
        if(x != 0 && x == Math.abs(board[i+1][j]) && x == Math.abs(board[i+2][j])) {
          todo = true;
          board[i][j] = board[i+1][j] = board[i+2][j] = -x;
        }
      }
    }

    if(todo) {
      for (int j = 0; j < cols; j++) {
        int w = rows-1;
        for (int i = rows-1; i >= 0; i--) {
          if(board[i][j] > 0) board[w--][j] = board[i][j];
        }
        for(int k = w; k >= 0; k--) board[k][j] = 0;
      }
      return candyCrush(board);
    }

    return board;
  }
  public static void main(String[] args) {

  }
}
