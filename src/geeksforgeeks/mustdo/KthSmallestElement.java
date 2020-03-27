package geeksforgeeks.mustdo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by joetomjob on 4/11/19.
 */
public class KthSmallestElement {
    public static void kthSamllestElement(int[] A, int n) {

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            int n = Integer.parseInt(br.readLine());
            String s1 = br.readLine();
            String[] st1 = s1.trim().split("\\s+");
            int[] A = new int[n];
            for (int j = 0; j < n; j++)
                A[j] = Integer.parseInt(st1[j]);
            kthSamllestElement(A, n);
        }
    }
}
