package geeksforgeeks.mustdo.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by joetomjob on 6/7/19.
 */
public class DutchNationalFlag {
    public static int[] sort012(int[] s, int n){
        int l=0, m = 0, h =n-1, temp = -1;
        while ( m <= h ) {
            switch (s[m]) {
                case 0:
                    temp = s[l];
                    s[l] = s[m];
                    s[m] = temp;
                    m++;
                    l++;
                    break;
                case 1:
                    m++;
                    break;
                case 2:
                    temp = s[m];
                    s[m] = s[h];
                    s[h] = temp;
                    h--;
                    break;
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
            int[] res = sort012(s3, n);
            for (int j = 0; j < n; j++) {
                System.out.print(res[j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
