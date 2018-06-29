package Codility;

/**
 * Created by joetomjob on 6/25/18.
 */
public class OddOccurrencesInArray {
    public int solution(int[] A){
        int x = A[0];
        for (int i = 1; i < A.length; i++) {
            x = x^A[i];
        }
        return x;
    }
    public static void main(String[] args) {
        int[] inp = {1,1,2,4,3,2,4,3,6,7,8,7,8};
    }
}
