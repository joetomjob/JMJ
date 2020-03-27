package geeksforgeeks.mustdo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by joetomjob on 12/8/18.
 */
public class leaderinarray {
    private static void leaderinarray(int[] A, int n){
        ArrayList<Integer> al = new ArrayList<>();
        al.add(A[n-1]);
        int max = A[n-1];
        for (int i = n-2; i >= 0 ; i--) {
            if(A[i] >= max) {
                al.add(A[i]);
                max = A[i];
            }
        }
        int sz = al.size();
        for (int i = sz-1; i >= 1; i--) {
            System.out.print(al.get(i)+" ");
        }
        System.out.print(al.get(0));
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] A = new int[n];
            String s = br.readLine();
            String[] st = s.trim().split("\\s+");
            for (int j = 0; j < n; j++) {
                A[j] = Integer.parseInt(st[j]);
            }
            leaderinarray(A, n);
        }

    }
}
