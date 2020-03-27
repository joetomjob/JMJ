package ctci.ArraysAndStrings;

/**
 * Created by joetomjob on 7/27/19.
 */
public class URLify {

    public static void main(String[] args) {
        String ss = "asdasd asdsad as  ";
        String s = urlify(ss, 16);
        System.out.println(s);
    }
    public static String urlify(String s, int n){
        StringBuilder s1 = new StringBuilder();
        int counter = 0;
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == ' ') {
                s1.append("&%20");
            } else {
                s1.append(s.charAt(i));
            }
            counter++;
            if(counter >= n)
                return s1.toString();
        }
        return s1.toString();
    }
}
