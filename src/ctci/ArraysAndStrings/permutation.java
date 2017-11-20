package ctci.ArraysAndStrings;

/**
 * Created by joetomjob on 7/8/17.
 */
public class permutation {
    public static void main(String[] args) {
        permutation d= new permutation();
        boolean v = d.permutation("Joe","keJ");
        System.out.println(v);
    }
    public boolean permutation(String st1, String st2){
        int[] i = new int[256];
        char[] s1 = st1.toCharArray();
        char[] s2 = st2.toCharArray();
        System.out.println(s1.length);
        System.out.println(st1.length());
        for (char c: s1) {
            i[(int)c]++;
        }
        for (char c: s2) {
            i[(int)c]--;
            if(i[(int)c]<0){
                return false;
            }
        }
        return true;

    }

}
