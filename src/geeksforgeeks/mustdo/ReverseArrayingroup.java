package geeksforgeeks.mustdo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by joetomjob on 12/12/18.
 */
public class ReverseArrayingroup {
    public static void reverseArrayGroup(int[] A, int n, int k){
        for (int i = 0; i < n; i += k ) {
            int left = i;
            int right = Math.min(i+k-1, n-1);
            int temp;

            while (left < right){
                temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
                right--;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(A[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            String s = br.readLine();
            String[] st = s.trim().split("\\s+");
            int n = Integer.parseInt(st[0]);
            int subsize = Integer.parseInt(st[1]);
            String s1 = br.readLine();
            String[] st1 = s1.trim().split("\\s+");
            int[] A = new int[n];
            for (int j = 0; j < n; j++)
                A[j] = Integer.parseInt(st1[j]);
            reverseArrayGroup(A, n, subsize);
        }
    }
}
