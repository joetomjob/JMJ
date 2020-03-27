package geeksforgeeks.mustdo.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by joetomjob on 5/23/19.
 */
public class SaveIronMan {
    public static String checkPallindrome(String s) {
        char s1[] = s.toCharArray();
        StringBuffer s2 = new StringBuffer();
        for (int i = 0; i < s1.length; i++) {
            if(Character.isLetterOrDigit(s1[i])) {
                s2.append(s1[i]);
            }
        }
        s = s2.toString();
        for (int i = 0, j = s.length()-1; i < s.length()/2; i++, j--) {
            if(Character.toUpperCase(s.charAt(i))  != Character.toUpperCase(s.charAt(j))){
                return "NO";
            }
        }
        return "YES";
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            String s = br.readLine();
            System.out.println(checkPallindrome(s));
        }
    }
}
