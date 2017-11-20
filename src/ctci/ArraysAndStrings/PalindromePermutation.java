package ctci.ArraysAndStrings;

/**
 * Created by joetomjob on 7/9/17.
 */
public class PalindromePermutation {
    public static void main(String[] args) {
        PalindromePermutation d= new PalindromePermutation();
        boolean v = d.palPermutation("taco cat");
        System.out.println(v);
    }
    public boolean palPermutation(String S2){
        String S1 = S2.toLowerCase();
        char[] s = S1.toCharArray();
        int count = 0;
        int[] i = new int[256];
        for (char c: s) {
            if(c != ' '){
                i[(int)c]++;
            }
        }
        for (char c: s) {
            if(c != ' '){
                if(i[(int)c]%2 != 0){
                    if(count>0){
                        return false;
                    }
                    else{
                        count++;
                    }
                }
            }
        }
        return true;

    }
}
