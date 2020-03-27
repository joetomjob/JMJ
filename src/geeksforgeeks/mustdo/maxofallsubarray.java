package geeksforgeeks.mustdo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by joetomjob on 12/11/18.
 */
public class maxofallsubarray {
    public static int maxsubarray(int[] A, int n){
        int max = A[0];
        for (int i = 1; i < n; i++) {
            if(A[i]>max)
                max = A[i];
        }
        return max;
    }

    public static void slidingWindow(int[] A, int n, int k){
        Deque<Integer> d = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!d.isEmpty() && d.getFirst() == i-k)
                d.removeFirst();
            while (!d.isEmpty() && A[d.getLast()] < A[i])
                d.removeLast();
            d.addLast(i);
            if(i>=k-1)
                System.out.print(A[d.getFirst()]+" ");

        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            String s = br.readLine();
            String[] st = s.trim().split("\\s+");
            int n = Integer.parseInt(st[0]);
            int subsize = Integer.parseInt(st[1]);
            String s1 = br.readLine();
            String[] st1 = s1.trim().split("\\s+");
            int[] A = new int[n];
            for (int j = 0; j < n; j++) {
                A[j] = Integer.parseInt(st1[j]);
            }

//            //normal method
//            for (int j = 0; j < n-(subsize-1); j++) {
//                System.out.print(maxsubarray(Arrays.copyOfRange(A,j,j+subsize), subsize) + " ");
//            }
//            System.out.println();

            //sliding window
            slidingWindow(A, n, subsize);
            System.out.println();
        }
    }
}
