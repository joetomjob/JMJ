package geeksforgeeks.mustdo.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by joetomjob on 6/7/19.
 */
public class BinaryArraySort {
    public static int[] sortBinaryArray(int[] s, int n) {
        int min = 0, max = n-1, i =0;
        while (max > min) {
            if (s[i] == 0) {
                int temp = s[min];
                s[min] = s[i];
                s[i] = temp;
                min++;
                i++;
            } else {
                int temp = s[max];
                s[max] = s[i];
                s[i] = temp;
                max--;
            }
        }
        return s;
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
            int[] res = sortBinaryArray(s3, n);
            for (int j = 0; j < n; j++) {
                System.out.print(res[j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
