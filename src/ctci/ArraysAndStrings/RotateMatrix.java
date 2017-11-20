package ctci.ArraysAndStrings;

/**
 * Created by jtomjob on 7/12/2017.
 */
public class RotateMatrix {
    public static void main(String[] args) {
        RotateMatrix r = new RotateMatrix();
        int n = 10;
        int count=0;
        int[][] m = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = count;
                count++;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(m[i][j]);
                System.out.print('\t');
            }
            System.out.print('\n');
        }
        r.rotateMatrix(m);
    }
    public void rotateMatrix(int[][] m){
        int temp,i,j,n;
        n = m[0].length;
        for (i = 0; i <= n/2 ; i++) {
            int f=i;
            int l = n-1-i;
            for (int k = f; k < l; k++) {
                int offset = k-f;

                temp = m[f][k];

                //left to top
                m[f][k] = m[l-offset][f];

                //bottom to left
                m[l-offset][f] = m[l][l-offset];

                //right to bottom
                m[l][l-offset] = m[k][l];

                //top to right
                m[k][l] = temp;

            }


        }
        System.out.print('\n');

        for (i =0; i < n; i++) {
            for ( j = 0; j < n; j++) {
                System.out.print(m[i][j]);
                System.out.print('\t');
            }
            System.out.print('\n');
        }
    }
}
