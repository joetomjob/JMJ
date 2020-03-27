package geeksforgeeks.mustdo.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by joetomjob on 5/23/19.
 */
public class URLify {
    public static String urlifySrting(String s){
        s = s.trim();
        StringBuffer s1 = new StringBuffer();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ' && count == 0){
                s1.append("%20");
                count++;
            } else {
                s1.append(s.charAt(i));
                count = 0;
            }
        }
        return s1.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            String s = br.readLine();
            int l = Integer.parseInt(br.readLine());
            System.out.println(urlifySrting(s));
        }
    }
}
