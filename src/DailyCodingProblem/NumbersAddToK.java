package DailyCodingProblem;

import java.util.HashMap;

public class NumbersAddToK {
    public static boolean numbersAddtok(int[] a, int k) {

        HashMap<Integer, Integer> h = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            h.put(a[i], a[i]);
        }

        for (int i = 0; i < a.length; i++) {
            if(h.containsKey(k-a[i])) {
                return true;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        int[] a = {10, 15, 3, 7};
        System.out.println(numbersAddtok(a, 17));
    }

}
