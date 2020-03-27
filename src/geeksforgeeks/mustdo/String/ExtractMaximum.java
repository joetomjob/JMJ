package geeksforgeeks.mustdo.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by joetomjob on 5/23/19.
 */
public class ExtractMaximum {
    public static long extractMax(String s) {
        String s1 = "0";
        long m = 0;
        for (int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))) {
                s1 += s.charAt(i);
            } else {
                if(Long.parseLong(s1) > m) {
                    m = Long.parseLong(s1);
                }
                s1 = "0";
            }
        }
        if(Long.parseLong(s1) > m) {
            m = Long.parseLong(s1);
        }
        return m;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            String s = br.readLine();
            System.out.println(extractMax(s));
        }
    }
}
