package Codility;

import java.util.HashSet;

/**
 * Created by joetomjob on 6/27/18.
 */
public class MissingInteger {
    public int solution(int[] A){
        HashSet<Integer> h = new HashSet<>();
        int smallest = 1;
        for (int i = 0; i < A.length; i++) {
            if(A[i] > 0)
                h.add(A[i]);
        }
        while (h.contains(smallest)){
            smallest++;
        }
        return smallest;
    }
    public static void main(String[] args) {
        MissingInteger m = new MissingInteger();
        int[] A = {1,3,6,4,1,2};
        m.solution(A);
    }
}
