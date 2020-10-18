package LeetCode.BloombergPractice;

public class WordSearch {

  char[][] board;
  String word;
  int[] rows = {0,1,0,-1}, cols = {1,0,-1,0};
  int row, col;
  public boolean exist(char[][] board, String word){
    this.board = board;
    this.word = word;
    row = board.length;
    col = board[0].length;

    for(int i = 0; i < row; i++) {
      for(int j = 0; j < col; j++){
       if(board[i][j] == word.charAt(0)){
         if(backTrack(i, j, 0))
           return true;
       }
      }
    }
    return false;
  }

  public boolean backTrack(int i, int j, int index){
    if(index >= this.word.length()-1) return true;

    this.board[i][j] = '#';
    for(int k = 0; k < 4; k++){
      int nextR = i + this.rows[k];
      int nextC = j + this.cols[k];
      int nextIndex = index + 1;
      if(nextR >= 0 && nextC >=0 && nextR < this.row && nextC < this.col
          && nextIndex < this.word.length() && this.board[nextR][nextC] == this.word.charAt(nextIndex)) {
        boolean res = backTrack(nextR, nextC, nextIndex);
        if(res) {
          this.board[nextR][nextC] = this.word.charAt(nextIndex);
          return true;
        }
      }
    }
    this.board[i][j] = this.word.charAt(index);
    return false;
  }
  public static void main(String[] args){
    char[][] board = {{'A','B','C','E'}, {'S','F','C','S'},{'A','D','E','E'}};
    WordSearch w = new WordSearch();
    System.out.print(w.exist(board, "ABCB"));
  }
}
