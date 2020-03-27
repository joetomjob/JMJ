package geeksforgeeks.mustdo.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by joetomjob on 5/23/19.
 */
public class MergeTwoStrings {
    public static String mergeSrtings(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int i = 0, j = 0,counter = 0;
        StringBuffer s = new StringBuffer();
        while (i < m && j < n) {
            if(counter%2==0){
                s.append(s1.charAt(i));
                i++;
            } else {
                s.append(s2.charAt(j));
                j++;
            }
            counter++;
        }
        while(i < m){
            s.append(s1.charAt(i));
            i++;
        }
        while(j < n){
            s.append(s2.charAt(j));
            j++;
        }
        return s.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            String s = br.readLine();
            String s1[] = s.split("\\s");
            System.out.println(mergeSrtings(s1[0], s1[1]));
        }
    }
}
