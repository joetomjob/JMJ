package geeksforgeeks.mustdo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by joetomjob on 12/9/18.
 */
public class MinimumPlatforms {
    public static void minPlatforms(int[] A, int[] B, int n){
        int counter = 1;
        int maxcnt = 1;
        int i = 1, j=0;
        Arrays.sort(A);
        Arrays.sort(B);
        while (i < n && j < n){
            if(A[i] <= B[j]){
                counter++;
                i++;
                maxcnt = Math.max(counter, maxcnt);
            } else {
                counter --;
                j++;
            }
        }

        System.out.println(maxcnt);

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] A = new int[n];
            int[] B = new int[n];
            String s1 = br.readLine();
            String[] st1 = s1.trim().split("\\s+");
            for (int j = 0; j < n; j++) {
                A[j] = Integer.parseInt(st1[j]);
            }

            String s2 = br.readLine();
            String[] st2 = s2.trim().split("\\s+");
            for (int j = 0; j < n; j++) {
                B[j] = Integer.parseInt(st2[j]);
            }
            minPlatforms(A, B, n);
        }

    }
}
