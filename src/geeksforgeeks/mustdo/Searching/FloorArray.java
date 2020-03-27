package geeksforgeeks.mustdo.Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by joetomjob on 5/28/19.
 */
public class FloorArray {
    public static int floorOfArray(int[] A, int n, int k) {
        int res = -1, val = -1;
        for (int i = 0; i < n; i++) {
            if(A[i] <= k && A[i] > val) {
                res = i;
                val = A[i];
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            String s2 = br.readLine();
            String[] s3 = s2.split("\\s");
            int s4[] = new int[s3.length];
            for (int j = 0; j < s3.length; j++) {
                s4[j] = Integer.parseInt(s3[j]);
            }

            String s5 = br.readLine();
            String[] s6 = s5.split("\\s");
            int s7[] = new int[s6.length];
            for (int j = 0; j < s6.length; j++) {
                s7[j] = Integer.parseInt(s6[j]);
            }
            System.out.println(floorOfArray(s7, s4[0], s4[1]));
        }
    }
}
