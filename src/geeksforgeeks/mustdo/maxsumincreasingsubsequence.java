package geeksforgeeks.mustdo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by joetomjob on 12/8/18.
 */
public class maxsumincreasingsubsequence {
    private static int maxincsubseq(int[] A, int n){
        int[] sub = new int[n];
        for (int i = 0; i < n; i++) {
            sub[i] = A[i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(A[i] > A[j] && sub[j] + A[i] > sub[i]){
                    sub[i] = sub[j]+A[i];
                }
            }
        }
        int max = sub[0];
        for (int i = 0; i < n; i++) {
            System.out.print(sub[i]+" ");
            if(sub[i] > max)
                max = sub[i];
        }
        System.out.println();
        return max;
    }
    public static void main(String[] args) throws IOException {
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
            System.out.println(maxincsubseq(A, n));
        }

    }
}
