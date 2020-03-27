package geeksforgeeks.mustdo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by joetomjob on 12/7/18.
 */
public class EquilibriumPoint {
    private static int equilibrium(int[] A, int n) {
        int sum = 0;
        int lsum = 0;
        for (int i = 0; i < n; i++){
            sum += A[i];
        }

        for (int i = 0; i < n; i++) {
            sum -= A[i];
            if(sum == lsum)
                return i+1;
            lsum += A[i];
        }
        return -1;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] A = new int[n];
            String s = br.readLine();
            String[] st = s.trim().split("\\s+");
            for (int j = 0; j < n; j++) {
                A[j] = Integer.parseInt(st[j]);
            }
            System.out.println(equilibrium(A, n));

        }
    }
}
