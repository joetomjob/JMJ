package ctci.ArraysAndStrings;

/**
 * Created by joetomjob on 7/27/19.
 */
public class isUnique {
    public static void main(String[] args) {
        String s1 = "water";

        boolean result = isUnique(s1);
        System.out.println(result);


    }

    public static boolean isUnique(String s1){
        int[] s = new int[256];
        for (int i = 0; i < s1.length(); i++) {
            int temp = s1.charAt(i);
            if (s[temp] == 0) {
                s[temp] = 1;
            } else
                return false;
        }
        return true;
    }
}
