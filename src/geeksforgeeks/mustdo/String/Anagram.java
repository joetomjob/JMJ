package geeksforgeeks.mustdo.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by joetomjob on 5/22/19.
 */
public class Anagram {
    public static String checkAnagram(String s1, String s2){
        int asci[] = new int[26];
        for(int i = 0; i < s1.length(); i++){
            asci[(int)s1.charAt(i)-97]++;
        }
        for(int i = 0; i < s2.length(); i++){
            asci[(int)s2.charAt(i)-97]--;
        }
        for(int i = 0; i < asci.length; i++) {
            if(asci[i] != 0) {
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
            String[] s1 = s.split("\\s");
            System.out.println(checkAnagram(s1[0], s1[1]));
        }
    }
}
