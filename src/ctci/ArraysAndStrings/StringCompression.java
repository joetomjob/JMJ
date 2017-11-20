package ctci.ArraysAndStrings;

/**
 * Created by joetomjob on 7/9/17.
 */
public class StringCompression {
    public static void main(String[] args) {
        StringCompression d= new StringCompression();
        d.strComp("aaabcc");
    }
    public void strComp(String s){
        StringBuilder s1 = new StringBuilder();
        int counter = 1;
        for (int i = 1; i < s.length() ; i++) {
            if(s.charAt(i-1) != s.charAt(i)){
                s1.append(s.charAt(i-1));
                s1.append(counter);
                counter = 1;
            }
            else{
                counter++;
            }
        }
        s1.append(s.charAt(s.length()-1));
        s1.append(counter);
        System.out.println(s1);
    }
}
