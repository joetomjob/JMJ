package IB;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by joetomjob on 2/8/18.
 */
public class Anagram {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        Anagram A = new Anagram();
        System.out.println(A.isAnagram(s,t));
    }
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> h = new HashMap<Character, Integer>();
        for(char c : s.toCharArray()){
            if(!h.containsKey(c)){
                h.put(c,1);
            }
            else{
                Integer i = h.get(c);
            }
        }
        for(char c : t.toCharArray()){
            if(!h.containsKey(c)){
                h.put(c,1);
            }
            else{
                Integer i = h.get(c);
                h.put(c,i+1);
            }
        }
        for (Map.Entry<Character,Integer> e: h.entrySet()) {
            Character key = e.getKey();
            Integer i = e.getValue();
            if(i%2 != 0){
                return false;
            }
        }
        return true;
    }
}
