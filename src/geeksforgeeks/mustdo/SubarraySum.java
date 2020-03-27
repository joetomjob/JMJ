package geeksforgeeks.mustdo;

import java.util.Scanner;

/**
 * Created by joetomjob on 12/7/18.
 */
public class SubarraySum {
    private static void subSum(int[] A, int n, int s){
        int curr_sum = A[0];
        int trail = 0;
        int end = -1;
        for(int i=1; i<n; i++){
            curr_sum += A[i];
            while(curr_sum > s){
                curr_sum -= A[trail];
                trail ++;
            }
            if(curr_sum == s){
                end = i+1;
                break;
            }
        }
        if(end == -1){
            System.out.println(-1);
        } else {
            System.out.print(trail+1);
            System.out.print(" ");
            System.out.print(end);
            System.out.println();
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        for(int i = 0; i< k; i++){
            int n = sc.nextInt();
            int s = sc.nextInt();
            int[] A = new int[n];
            for(int j = 0; j< n; j++){
                A[j] = sc.nextInt();
            }
            subSum(A, n, s);
        }
    }
}
