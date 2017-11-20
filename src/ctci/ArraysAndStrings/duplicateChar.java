package ctci.ArraysAndStrings;

import java.util.HashMap;

/**
 * Created by joetomjob on 7/8/17.
 */
public class duplicateChar {
    public static void main(String[] args) {
        duplicateChar d= new duplicateChar();
        String s = "joe";
        for (int i = 0; i < 3; i++) {
            System.out.println((int)s.charAt(i));
        }
        boolean v = d.duplicateChar("Joe");
        System.out.println(v);
    }
    public  boolean duplicateChar(String s){
        char[] c = s.toCharArray();
        int[] i = new int[26];
        HashMap<Integer,Character> h = new HashMap<>();
        for (char ch : c) {
            if(h.containsKey((int)ch)){
                return true;
            }
            else{
                h.put((int)ch,ch);
            }
        }
        return false;
    }
}
