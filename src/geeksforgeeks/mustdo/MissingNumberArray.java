package geeksforgeeks.mustdo;

import java.util.Scanner;

/**
 * Created by joetomjob on 12/6/18.
 */
public class MissingNumberArray {
    private static void missingnumber(int[]inp, int n){
        int sum = (n*(n+1))/2;
        int s = 0;
        for (int i = 0; i < n-2; i++) {
            s += inp[i];
        }
        System.out.println(sum-s);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int test = s.nextInt();
        for(int i = 0;i<test;i++){
            int n = s.nextInt();
            int[] inp =new int[n];
            for(int j = 0;j< n-1; j++){
                inp[j] = s.nextInt();
            }
            missingnumber(inp,n);
        }

    }
}
