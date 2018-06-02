package codefights;

import java.util.HashSet;

/**
 * Created by joetomjob on 2/17/18.
 */
public class sudoku {
    static boolean sudoku2(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        for(int i = 0; i< rows; i++){
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> col = new HashSet<>();
            for(int j = 0; j< cols; j++){
                if(grid[i][j] != '.'){
                    if(!row.add(grid[i][j])){
                        return false;
                    }
                    if(!col.add(grid[j][i])){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] s = {{'.','.','.','1','4','.','.','2','.'},
                {'.','.','6','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','1','.','.','.','.','.','.'},
                {'.','6','7','.','.','.','.','.','9'},
                {'.','.','.','.','.','.','8','1','.'},
                {'.','3','.','.','.','.','.','.','6'},
                {'.','.','.','.','.','7','.','.','.'},
                {'.','.','.','5','.','.','.','7','.'}};
        sudoku2(s);
    }

}
