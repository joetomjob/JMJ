package geeksforgeeks.mustdo.Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by joetomjob on 5/23/19.
 */
public class FacingTheSun {
    public static int facingSun(int n, int[] s){
        int count = 1;
        int f = s[0];
        if(n > 1) {
            for (int i = 1; i < n; i++) {
                if(s[i] > f){
                    count++;
                    f = s[i];
                }
            }
        }
        return count;
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
            System.out.println(facingSun(n, s4));
        }
    }
}
