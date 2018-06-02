package LeetCode;

/**
 * Created by joetomjob on 2/25/18.
 */
public class pallindrome {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        int size = s.length();
        for(int i=0; i<size;i++){
            if(Character.isDigit(s.charAt(i))||Character.isLetter(s.charAt(i))){
                sb.append(s.charAt(i));
            }
        }
        s = sb.toString();
        size = s.length();
        for(int i=0;i<size/2;i++){
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(size-1-i))){
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        pallindrome p = new pallindrome();
        boolean r = p.isPalindrome("a a");
    }
}
