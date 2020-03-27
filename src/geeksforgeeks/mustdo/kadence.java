package geeksforgeeks.mustdo;

import java.util.Scanner;

/**
 * Created by joetomjob on 12/6/18.
 */
public class kadence {

    private static void kadencealgo(int[] A, int n){
        int maxhere = 0;
        int maxend = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            maxhere = maxhere+A[i];
            if(maxend < maxhere)
                maxend = maxhere;
            if(maxhere < 0)
                maxhere = 0;
        }
        System.out.println(maxend);

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int notest = s.nextInt();
        for (int i = 0; i < notest; i++) {
            int n = s.nextInt();
            int[] A = new int[n];
            for(int j = 0; j< n; j++){
                A[j] = s.nextInt();
            }
            kadencealgo(A, n);
        }
    }
}
