package geeksforgeeks.mustdo.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by joetomjob on 6/8/19.
 */
public class SelectionSort {
    public static void selectionSort(int arr[], int n){
        for (int i = 0; i < n; i++) {
            int min_idx = i;
            for (int j = i+1; j < n; j++) {
                if(arr[j] < arr[min_idx ]){
                    min_idx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = temp;
        }
//        return arr;
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
            selectionSort(s3, n);
            for (int j = 0; j < n; j++) {
                System.out.print(s3[j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
