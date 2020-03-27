package ctci.ArraysAndStrings;

/**
 * Created by joetomjob on 7/30/19.
 */
public class ZeroMatrixCtci {
    public static void main(String[] args) {
        int[][] a = {
                {1 , 2, 0},
                {1 , 2, 3},
                {1 , 0, 3},
                {1 , 2, 3},
        };
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
             System.out.print(a[i][j]);
                System.out.print('\t');
            }
            System.out.print('\n');
        }

        boolean rowHasZero = false, colHasZero = false;

        //check if first row has zero
        for (int i = 0; i < a[0].length; i++) {
            if(a[0][i] == 0) {
                rowHasZero = true;
                break;
            }
        }

        //check if first col has zero
        for (int i = 0; i < a.length; i++) {
            if(a[i][0] == 0) {
                colHasZero= true;
                break;
            }
        }

        //check rest of array. if any element is zero, then make the first element of that row and column as zero
        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < a[0].length; j++) {
                if(a[i][j] == 0) {
                    a[i][0] = 0;
                    a[0][j] = 0;
                }
            }
        }

        //nullify row based on the values in first row
        for (int i = 1; i < a.length; i++) {
            if(a[i][0] == 0) {
                nullifyRow(a, i);
            }
        }

        //nullify col based on the values in first col
        for (int i = 1; i < a[0].length; i++) {
            if(a[0][i] == 0) {
                nullifyCol(a, i);
            }
        }

        //nullify first row
        if(rowHasZero) {
            for (int i = 0; i < a[0].length; i++) {
                a[0][i] = 0;
            }
        }

        //nullify first col
        if(colHasZero) {
            for (int i = 0; i < a.length; i++) {
                a[i][0] = 0;
            }
        }

        System.out.print('\n');
        System.out.print('\n');
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j]);
                System.out.print('\t');
            }
            System.out.print('\n');
        }

    }

    public static void nullifyRow(int[][] a, int row) {
        for (int i = 0; i < a[row].length; i++) {
            a[row][i] = 0;
        }
    }

    public static void nullifyCol(int[][] a, int col) {
        for (int i = 0; i < a.length; i++) {
            a[i][col] = 0;
        }
    }
}
