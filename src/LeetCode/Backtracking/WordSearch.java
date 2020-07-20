package LeetCode.Backtracking;

public class WordSearch {
  char[][] board;
  int r, c;
  public boolean exist(char[][] board, String word) {
    this.board = board;
    this.r = board.length;
    this.c = board[0].length;

    for(int i = 0; i < r; i++){
      for(int j = 0; j < c; j++){
        if(dfs(i, j, word, 0))
          return true;
      }
    }
    return false;
  }
  public boolean dfs(int i, int j, String word, int wordindex){
    if(wordindex >= word.length())
      return true;
    if(i < 0 || j < 0 || i >= r || j >= c || word.charAt(wordindex) != this.board[i][j]){
      return false;
    }
    int[] rowOffset = {0, 1, 0, -1};
    int[] colOffset = {1, 0, -1, 0};
    boolean ret = false;
    this.board[i][j] = '#';
    for(int k = 0; k < 4; k++){
      ret = dfs(i + rowOffset[k], j+colOffset[k], word, wordindex+1);
      if (ret)
        break;
    }
    this.board[i][j] = word.charAt(wordindex);
    return ret;
  }
  public static void main(String[] args){
    char[][] board = {{'A','B','C','E'}, {'S','F','C','S'},{'A','D','E','E'}};
    WordSearch w = new WordSearch();
    System.out.print(w.exist(board, "ABCCED"));
  }
}
