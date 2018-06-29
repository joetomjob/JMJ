package Codility;

/**
 * Created by joetomjob on 6/25/18.
 */
public class RotateArray {
    public int[] rotateArray(int[] A, int K){
        if(A == null || A.length ==0)
            return A;
        K = K%A.length;
        reverse(A, 0, A.length-1);
        reverse(A, 0, K-1);
        reverse(A, K, A.length-1);
        return A;

    }

    public void reverse(int[] A, int start, int end){
        while (start < end){
            int temp = A[start];
            A[start] = A[end];
            A[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        RotateArray r = new RotateArray();
        r.rotateArray(array, 6);
    }
}
