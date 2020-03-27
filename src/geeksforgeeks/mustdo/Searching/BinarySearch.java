package geeksforgeeks.mustdo.Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by joetomjob on 5/28/19.
 */
public class BinarySearch {
    public static int binarySearch(int[] A, int left, int right, int k){
        while (left <= right) {
            int m = (right+left) / 2;
            if(A[m] == k) {
                return m;
            } else if(A[m] < k) {
                left = m+1;
            }else {
                right = m-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            int n = Integer.parseInt(br.readLine());
            String s2 = br.readLine();
            String[] s3 = s2.split("\\s");
            int s4[] = new int[s3.length];
            for (int j = 0; j < s3.length; j++) {
                s4[j] = Integer.parseInt(s3[j]);
            }
            int val = Integer.parseInt(br.readLine());
            System.out.println(binarySearch(s4, 0, n-1, val));
        }
    }
}
