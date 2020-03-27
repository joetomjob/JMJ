package geeksforgeeks.mustdo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by joetomjob on 12/17/18.
 */
public class TrapRainWater {
    public static int trapRainWater(int[] A, int n){
        if (n<3)
            return 0;

        int l = 0, r = A.length-1, res = 0, sum =0, i = l;
        while (l<r && A[l] <= A[l+1]) l++;
        while (l<r && A[r] <= A[r-1]) r--;

        while (l<r){
            sum += A[l];



        }
        return 1;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            String s = br.readLine();
            int n  = Integer.parseInt(br.readLine());
            String s1 = br.readLine();
            String[] st1 = s1.trim().split("\\s+");
            int[] A = new int[n];
            for (int j = 0; j < n; j++)
                A[j] = Integer.parseInt(st1[j]);
            System.out.println(trapRainWater(A, n));
        }
    }
}
