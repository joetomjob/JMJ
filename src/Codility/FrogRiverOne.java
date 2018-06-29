package Codility;

/**
 * Created by joetomjob on 6/26/18.
 */
public class FrogRiverOne {
    public int solution(int X, int[] A){
        int s = X;
        boolean[] b = new boolean[s+1];
        for (int i = 0; i < A.length; i++) {
            if(b[A[i]] == false) {
                b[A[i]] = true;
                s--;
            }
            if(s == 0)
                return i;
        }
        return -1;

    }
    public static void main(String[] args) {
        int[] A = {1,3,1,4,2,3,5,4};
    }
}
