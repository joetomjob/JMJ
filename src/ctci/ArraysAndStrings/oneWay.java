package ctci.ArraysAndStrings;

/**
 * Created by joetomjob on 7/9/17.
 */
public class oneWay {
    public static void main(String[] args) {
        oneWay d= new oneWay();
        boolean v = d.oneWay("pale","bahe");
        System.out.println(v);
    }
    public boolean oneWay(String s1, String s2){
        int k,count=0,count2=0;
        String s,l;
        if(s1.length()>s2.length()){
            k=s2.length();
            s=s2;l=s1;
        }
        else{
            k=s1.length();
            s=s1;l=s2;
        }
        for (int i = 0; i < k; i++) {
            if(s.charAt(i) != l.charAt(count)){
                if(count2>0)
                    return false;
                else {
                    count++;
                    count2++;
                }
            }
            count++;
        }
        return true;
    }
}
