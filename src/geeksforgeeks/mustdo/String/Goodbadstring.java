package geeksforgeeks.mustdo.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by joetomjob on 5/23/19.
 */
public class Goodbadstring {
    public static int checkgoodbadstring(String s){
        int vc = 0, cc = 0;
        for (int i = 0; i < s.length(); i++) {
            if(isVowel(Character.toLowerCase(s.charAt(i)))){
                vc++;
                cc = 0;
                if(vc>5)
                    return 0;
            } else if(isCons(Character.toLowerCase(s.charAt(i)))) {
                cc++;
                vc = 0;
                if(cc>3)
                    return 0;
            } else if(s.charAt(i) == '?'){
                if(vc == 5 || cc == 3){
                    return 0;
                } else {
                    vc++;
                    cc++;
                }
            }
        }
        return 1;
    }

    public static boolean isVowel(char c) {
        if(c == 'a' || c == 'i' || c == 'o' || c == 'u' || c == 'e'){
            return true;
        }
        return false;
    }

    public static boolean isCons(char c) {
        if(Character.isLetter(c)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            String s = br.readLine();
            System.out.println(checkgoodbadstring(s));
        }
    }
}
