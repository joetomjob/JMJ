package LeetCode.ArraysAndStrings;

public class CandyCrush {

  public int[][] candyCrush(int[][] board){
    int rows = board.length;
    int cols = board[0].length;
    boolean todo = false;
    // logic: go row wise and column wise. If absolute value of element in position i, i+1 and i+2 are same,
    // then change value of all these elements as -ve of the absolute value of element.

    // row wise
    for(int i = 0; i < rows; i++){
      for(int j = 0; j+2 < cols; j++){
        int x = Math.abs(board[i][j]);
        if(x != 0 && x == Math.abs(board[i][j+1]) && x == Math.abs(board[i][j+2])) {
          todo = true;
          board[i][j] = board[i][j + 1] = board[i][j + 2] = -x;
        }
      }
    }

    // column wise
    for(int i = 0; i+2 < rows; i++){
      for(int j = 0; j < cols; j++){
        int x = Math.abs(board[i][j]);
        if(x != 0 && x == Math.abs(board[i+1][j]) && x == Math.abs(board[i+2][j])) {
          todo = true;
          board[i][j] = board[i + 1][j] = board[i + 2][j] = -x;
        }
      }
    }

    for(int j = 0; j < cols; j++){
      int w = rows-1;
      for(int i = rows-1; i >= 0; i--){
        if(board[i][j] > 0)
          board[w--][j] = board[i][j];
      }
      for(int k = w; k >= 0; k--)
        board[k][j] = 0;
    }

    return todo ? candyCrush(board) : board;
  }

  public static void main(String[] args){
    int[][] board = {
        {110,5,112,113,114},
        {210,211,5,213,214},
        {310,311,3,313,314},
        {410,411,412,5,414},
        {5,1,512,3,3},
        {610,4,1,613,614},
        {710,1,2,713,714},
        {810,1,2,1,1},
        {1,1,2,2,2},
        {4,1,4,4,1014}};

    CandyCrush c = new CandyCrush();
    int[][] res = c.candyCrush(board);
    for (int i = 0; i <board.length ; i++) {
      for (int j = 0; j < board[0].length; j++) {
        System.out.print(board[i][j]);
        System.out.print('\t');
      }
      System.out.print('\n');
    }
  }
}
