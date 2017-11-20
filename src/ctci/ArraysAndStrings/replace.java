package ctci.ArraysAndStrings;

/**
 * Created by joetomjob on 7/9/17.
 */
public class replace {
    public static void main(String[] args) {
        replace d= new replace();
        d.replacestring("Mr John Smith    ",13);
    }
    public void replacestring(String s1, int k){
        char[] s = s1.toCharArray();
        for (int i = s.length-1; i >=0 ; i--) {
            if(s[k-1] != ' '){
                s[i] = s[k-1];
            }
            else{
                s[i] = '0';
                s[i-1] = '2';
                s[i-2] = '%';
                i=i-2;
            }
            k--;
        }
        System.out.println(s);
    }
}
