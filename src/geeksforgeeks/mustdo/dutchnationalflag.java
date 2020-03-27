package geeksforgeeks.mustdo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by joetomjob on 12/7/18.
 */
public class dutchnationalflag {
    private static void dutchflag(int[] A, int n){
        int h = n-1;
        int l = 0, m =0;
        int temp = -1;
        while (m<=h) {
            if (A[m] == 0){
                temp = A[l];
                A[l] = A[m];
                A[m] = temp;
                l++;
                m++;
            } else if (A[m] == 1){
                m++;
            } else if (A[m] == 2){
                temp = A[h];
                A[h] = A[m];
                A[m] = temp;
                h--;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(A[i]+" ");
        }
        System.out.println("");

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        for(int i=0;i<k;i++){
            int n = Integer.parseInt(br.readLine());
            int[] A = new int[n];

            String line = br.readLine();
            String[] strs = line.trim().split("\\s+");

            for (int j = 0; j < n; j++)
                A[j] = Integer.parseInt(strs[j]);

            dutchflag(A, n);
        }
    }
}
