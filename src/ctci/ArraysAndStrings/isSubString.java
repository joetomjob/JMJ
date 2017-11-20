package ctci.ArraysAndStrings;

/**
 * Created by jtomjob on 7/12/2017.
 */
public class isSubString {
    public static void main(String[] args) {
        String s1 = "waterbottle";
        String s2 = "erbottlewathhh";

        isSubString f = new isSubString();
        boolean result = f.SubString(s1+s1,s2);
        System.out.println(result);


    }

    public boolean SubString(String s1, String s2){
        if(s1.length()/2 == s2.length() && s2.length()>0){
            if(s1.contains(s2)){
                return true;
            }
        }
        return false;
    }

}
