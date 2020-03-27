package geeksforgeeks.mustdo.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by joetomjob on 8/3/19.
 */
public class GeeksDivisor {

    public static String geekDivisor(int n, int d){
        int count = 0;
        for (int i = 2; i <= n/2; i = i+2) {
            if(n%i == 0) {
                count++;
            }
        }
        count++;
        if(count == d) {
            return "YES";
        }
        return "NO";

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        for(int i=0;i<k;i++){
            String s = br.readLine();
            String[] strs = s.trim().split("\\s+");
            int n = Integer.parseInt(strs[0]);
            int d = Integer.parseInt(strs[1]);
            System.out.println(geekDivisor(n, d));
        }
    }
}
