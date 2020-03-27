package geeksforgeeks.mustdo.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by joetomjob on 6/7/19.
 */
public class Bubblesort {
    static int[] bubble(int arr[], int i, int n)
    {
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j+1]){
                int temp = arr[j+1];
                arr[j+1] = arr[j];
                arr[j] = temp;
            }
        }
        return arr;
    }
    public static int[] bub(int[]s, int n){
        int[] res = new int[n];
        for (int i = 0; i < n-1; i++)
            res = bubble(s, i, n);
        return res;
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
            int[] res = bub(s3, n);
            for (int j = 0; j < n; j++) {
                System.out.print(res[j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
