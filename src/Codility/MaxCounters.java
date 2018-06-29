package Codility;

import java.util.Arrays;

/**
 * Created by joetomjob on 6/27/18.
 */
public class MaxCounters {
    public int[] solution(int N, int[] A){
        int[] r = new int[N];
        int max = 0;
        int lastMax = 0;
        for (int i = 0; i < A.length; i++) {
            if(A[i] != N+1){
                r[A[i]-1] = Math.max(r[A[i]-1],lastMax);
                r[A[i]-1] += 1;
                max = Math.max(max, r[A[i]-1]);
            }
            else{
                lastMax = max;
            }
        }

        for (int i = 0; i < r.length; i++) {
            r[i] = Math.max(lastMax, r[i]);
        }

        return r;
    }

    public static void main(String[] args) {
        int[] A = {3,4,4,6,1,4,4};
        MaxCounters m = new MaxCounters();
        m.solution(5,A);
    }
}
