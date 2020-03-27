package geeksforgeeks.mustdo.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by joetomjob on 5/22/19.
 */
public class UpperCaseConversion {
    public static String ConvertToUppperCase(String s){
        StringBuffer sb = new StringBuffer();
        String s1[] = s.split("\\s");
        for (String s2 : s1) {
            if(s2.length() > 0) {
                sb.append(Character.toUpperCase(s2.charAt(0)));
                sb.append(s2.substring(1));
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            String s = br.readLine();
            System.out.println(ConvertToUppperCase(s));
        }
    }
}
