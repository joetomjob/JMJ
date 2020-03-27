package ElementsofProgrammingJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by joetomjob on 9/1/19.
 */
public class hindex {

    // O(n^2)
    public static int calculateHIndex(int[] k) {
        int h = Integer.MIN_VALUE;
        if (k.length == 0) {
            return Integer.MIN_VALUE;
        } else if(k.length == 1) {
            return k[0];
        }
        else {
            for (int i = 0; i < k.length; i++) {
                int count = 0;
                for (int j = 0; j < k.length; j++) {
                    if(k[i] <= k[j]) {
                        count++;
                    }
                }
                if(count >= k[i] && k[i] > h ) {
                    h = k[i];
                }
            }
        }
        return h;
    }

    // O(nlog(n))
    public static int calculateHIndex2(int[] k) {
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < k.length; i++) {
            a.add(k[i]);
        }
        Collections.sort(a);
        for (int i = 0; i < k.length; i++) {
            if((int)a.get(i) >= k.length - i){
                return a.get(i);
            }
        }
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        int[] k = {1,4,1,4,2,1,3,5,6};
        System.out.println(calculateHIndex(k));
        System.out.println(calculateHIndex2(k));
    }
}
