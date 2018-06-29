package LeetCode.LeetCode_Easy;

import java.util.HashSet;

/**
 * Created by joetomjob on 6/14/18.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> h = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char c = board[i][j];
                if(c != '.') {
                    if (!h.add(c + " in row " + i) || !h.add(c + " in column " + j) || !h.add(c + " in block " + i / 3 + "," + j / 3))
                        return false;
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {{'8','3','.','.','7','.','.','.','.'},
                          {'6','.','.','1','9','5','.','.','.'},
                          {'.','9','8','.','.','.','.','6','.'},
                          {'8','.','.','.','6','.','.','.','3'},
                          {'4','.','.','8','.','3','.','.','1'},
                          {'7','.','.','.','2','.','.','.','6'},
                          {'.','6','.','.','.','.','2','8','.'},
                          {'.','.','.','4','1','9','.','.','5'},
                          {'.','.','.','.','8','.','.','7','9'}};


        char[][] board1 = {{'5','3','.','.','7','.','.','.','.'},
                         {'6','.','.','1','9','5','.','.','.'},
                         {'.','9','8','.','.','.','.','6','.'},
                         {'8','.','.','.','6','.','.','.','3'},
                         {'4','.','.','8','.','3','.','.','1'},
                         {'7','.','.','.','2','.','.','.','6'},
                         {'.','6','.','.','.','.','2','8','.'},
                         {'.','.','.','4','1','9','.','.','5'},
                         {'.','.','.','.','8','.','.','7','9'}
                         };

        ValidSudoku v = new ValidSudoku();
        System.out.println(v.isValidSudoku(board1));
    }
}
