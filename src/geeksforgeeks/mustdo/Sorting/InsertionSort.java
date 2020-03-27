package geeksforgeeks.mustdo.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by joetomjob on 6/7/19.
 */
public class InsertionSort {
    public static int[] insertionSort(int arr[], int n) {
        int i;
        int res[] = new int[n];
        for (i = 1; i < n; i++)
            res = insert(arr, i);
        return res;
    }
    public static int[] insert(int arr[], int i){
        int key = arr[i];
        int j = i-1;
        while (j >=0 && arr[j] > key){
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = key;
        return arr;
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
            int[] res = insertionSort(s3, n);
            for (int j = 0; j < n; j++) {
                System.out.print(res[j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
