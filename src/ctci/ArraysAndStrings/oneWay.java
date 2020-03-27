package ctci.ArraysAndStrings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by joetomjob on 7/9/17.
 */
public class oneWay {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        String second = br.readLine();

        if(first.length() == second.length()) {
            System.out.println(oneEditReplace(first, second));
        } else if (first.length() + 1 == second.length()){
            System.out.println(oneEditInsert(first, second));
        } else if (first.length() - 1 == second.length()){
            System.out.println(oneEditInsert(second, first));
        } else {
            System.out.println(false);
        }
    }

    public static boolean oneEditReplace(String s1, String s2){
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                if (count > 0) {
                    return false;
                }
                count++;
            }
        }
        return true;
    }

    public static boolean oneEditInsert(String s1, String s2){
        int index1 = 0, index2 = 0;
        while (index1 < s1.length() && index2 < s2.length()) {
            if(s1.charAt(index1) != s2.charAt(index2)){
                if(index1 != index2) {
                    return false;
                }
                index2++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;

    }
}
