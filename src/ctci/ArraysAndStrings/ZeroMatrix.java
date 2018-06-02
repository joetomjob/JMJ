package ctci.ArraysAndStrings;

import java.util.ArrayList;

/**
 * Created by jtomjob on 7/12/2017.
 */
public class ZeroMatrix {
    public static void main(String[] args) {
        ZeroMatrix r = new ZeroMatrix();
        int m = 5;
        int n = 4;
        int count = 1;
        int[][] mat = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = count;
                if((i==2 && j==2) ||((i==2 && j==1))){
                    mat[i][j] = 0;
                }
                count++;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j]);
                System.out.print('\t');
            }
            System.out.print('\n');
        }
        r.ZeroMatrix(mat);
    }

    public void ZeroMatrix(int[][] m) {
        int r, c;
        ArrayList<Integer> row = new ArrayList<>();
        ArrayList<Integer> col = new ArrayList<>();
        c = m[0].length;
        r = m.length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (m[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for (int a : row) {
            for (int i = 0; i < c; i++) {
                m[a][i] = 0;
            }
        }
        for (int a : col) {
            for (int i = 0; i < r; i++) {
                m[i][a] = 0;
            }
        }
        System.out.print('\n');
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(m[i][j]);
                System.out.print('\t');
            }
            System.out.print('\n');
        }
    }
}
