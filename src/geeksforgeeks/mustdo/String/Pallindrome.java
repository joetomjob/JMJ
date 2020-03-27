package geeksforgeeks.mustdo.String;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by joetomjob on 5/22/19.
 */
public class Pallindrome {
    public static String checkPallindrome(String s, int n) {
        for (int i = 0, j = n-1; i < n/2; i++, j--) {
            if(s.charAt(i) != s.charAt(j)) {
                return "No";
            }
        }
        return "Yes";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            int n  = Integer.parseInt(br.readLine());
            String s1 = br.readLine();
            System.out.println(checkPallindrome(s1, n));
        }
    }
}
