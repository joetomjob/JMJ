package geeksforgeeks.mustdo.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by joetomjob on 5/22/19.
 */
public class AnagramPallindrome {
    public static String checkAnagramPallindrome(String s) {
        HashMap<Character, Integer> h = new HashMap<>();
        for(int i = 0; i< s.length(); i++) {
            if (h.containsKey(s.charAt(i))) {
                int a = h.get(s.charAt(i));
                h.put(s.charAt(i), ++a);
            } else {
                h.put(s.charAt(i), 1);
            }
        }
        int count =0;
        for(Integer i: h.values()) {
            if(i%2 != 0) {
                count++;
                if(count > 1){
                    return "No";
                }
            }
        }
        return "Yes";
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            String s = br.readLine();
            System.out.println(checkAnagramPallindrome(s));
        }
    }
}
