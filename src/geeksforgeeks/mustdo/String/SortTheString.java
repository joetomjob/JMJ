package geeksforgeeks.mustdo.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;

/**
 * Created by joetomjob on 5/23/19.
 */
public class SortTheString {
    public static String sortstring(String s){
        StringBuffer s1 = new StringBuffer();
        int s2[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            s2[(int)s.charAt(i) - 97]++;
        }

        for (int i = s2.length -1 ; i >=  0; i--) {
            for (int j = 0; j < s2[i]; j++) {
                s1.append((char)(i+97));
            }
        }
        return s1.toString();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            String s = br.readLine();
            System.out.println(sortstring(s));
        }
    }
}
