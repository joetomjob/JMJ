package geeksforgeeks.mustdo.Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by joetomjob on 5/23/19.
 */
public class SearchingANumber {
    public static int extractIndex(int n, int k, int[] s) {
        for (int i = 0; i < n; i++) {
            if(k == s[i]) {
                return i+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            String s = br.readLine();
            String[] s1 = s.split("\\s");
            String s2 = br.readLine();
            String[] s3 = s2.split("\\s");
            int s4[] = new int[s3.length];
            for (int j = 0; j < s3.length; j++) {
                s4[j] = Integer.parseInt(s3[j]);
            }
            int n = Integer.parseInt(s1[0]);
            int l = Integer.parseInt(s1[1]);
            System.out.println(extractIndex(n, l, s4));
        }
    }
}
