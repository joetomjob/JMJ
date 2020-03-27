package geeksforgeeks.mustdo.Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by joetomjob on 5/28/19.
 */
public class SearchRotatedArray {
    public static int searchRotArr(int[] A, int n, int k){
        // find the pivot element first
        int index = findPivotElt(A, n, k);


        //After finding the pivot element, find the which half has to be searched
        int l =-1, r = -1;
        if(k >= A[index] && k <= A[n-1]) {
            l = index;
            r = n-1;
        } else {
            l = 0;
            r = index-1;
        }

        //After finding the half to be searched, perform binary search on the required part

        while (l <= r){
            int m = (l+r)/2;
            if(A[m] == k){
                return m;
            } else if(A[m] > k){
                r = m-1;
            }else {
                l = m+1;
            }
        }
        return -1;

    }

    public static int findPivotElt(int[] A, int n, int k){
        int l = 0, r = n-1;
        while (l <= n) {
            int m = (l+r)/2;
            if(m+1 < n) {
                if (A[m] > A[m + 1]) {
                    return m + 1;
                } else {
                    if (A[l] > A[m]) {
                        r = m - 1;
                    } else {
                        l = m + 1;
                    }
                }
            }

        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            int n = Integer.parseInt(br.readLine());
            String s1 = br.readLine();
            String[] s2 = s1.split("\\s");
            int s3[] = new int[s2.length];
            for (int j = 0; j < s2.length; j++) {
                s3[j] = Integer.parseInt(s2[j]);
            }
            int l = Integer.parseInt(br.readLine());
            System.out.println(searchRotArr(s3, n, l));
        }
    }
}
