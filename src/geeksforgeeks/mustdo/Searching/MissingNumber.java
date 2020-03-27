package geeksforgeeks.mustdo.Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by joetomjob on 5/28/19.
 */
public class MissingNumber {
    public static int findMissingNumber(int[] A, int n){
        int temp[] = new int[n+1];
        for (int i = 0; i < A.length; i++) {
            temp[A[i]]++;
        }
        for (int i = 1; i <= n; i++) {
            if(temp[i] == 0){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            int n = Integer.parseInt(br.readLine());
            String s1 = br.readLine();
            String[] s2 = s1.split("\\s");
            int s3[] = new int[s2.length];
            for (int j = 0; j < s2.length; j++) {
                s3[j] = Integer.parseInt(s2[j]);
            }
            System.out.println(findMissingNumber(s3, n));
        }
    }
}
