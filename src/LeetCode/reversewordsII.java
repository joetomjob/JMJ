package LeetCode;

/**
 * Created by joetomjob on 2/25/18.
 */
public class reversewordsII {
    public void reverseWords(char[] str) {
        int l=0,r=0;

        str = this.reverse(str,0,str.length-1);
        for(int i=0;i<str.length;i++){
            if(str[i]==' '){
                str = reverse(str,l,i-1);
                l=i+1;
            }

        }
    }
    public char[] reverse(char[] s, int l, int r){
        while(l<r){
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;r--;
        }
        return s;
    }

    public static void main(String[] args) {
        reversewordsII r = new reversewordsII();
        char s[] = {'t','h','e',' ' ,'s','k','y',' ' ,'i','s',' ','b','l','u','e'};
        r.reverseWords(s);
    }
}
