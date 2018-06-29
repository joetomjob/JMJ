package Codility;

/**
 * Created by joetomjob on 6/26/18.
 */
public class TapeEquilibrium {
    public int solution(int[] A){
        long l = A[0];
        long r = 0;
        long diff = Integer.MIN_VALUE;
        for (int i = 1; i < A.length; i++) {
            r += A[i];
        }
        diff = Math.abs(l-r);

        for (int i = 1; i < A.length; i++) {
            diff = Math.min(diff, Math.abs(l-r));
            l = l+A[i];
            r = r - A[i];
        }
        return (int)diff;
    }

    public static void main(String[] args) {
        int[] A = {3,1,2,4,3};
        TapeEquilibrium t = new TapeEquilibrium();
        t.solution(A);
    }
}
