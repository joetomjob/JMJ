package LeetCode;

/**
 * Created by joetomjob on 2/25/18.
 */
public class reversewords {
    public String reverseWords(String s) {
        if(s.trim().length()>0){
            String sarray[] = s.split(" ");
            StringBuilder sb = new StringBuilder();
            for(int i=sarray.length-1; i>=0; i--){
                if(sarray[i].trim().length()>0){
                    if(i!=sarray.length-1){
                        sb.append(" ");
                    }
                    sb.append(sarray[i]);
                }
            }
            return sb.toString();
        }
        else{
            return "";
        }
    }

    public static void main(String[] args) {
        reversewords r = new reversewords();
        r.reverseWords(" l");
    }
}
