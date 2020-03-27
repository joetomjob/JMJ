package geeksforgeeks.mustdo.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by joetomjob on 6/8/19.
 */
public class MergeSort {
    public static void mergeSort(int[] arr, int l, int h){
        if (l < h) {
            int m = (h+l)/2;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, h);

            merge(arr, l, m, h);
        }
    }
    public static void merge(int[] arr, int l, int m, int h){
        int n1 = m-l+1;
        int n2 = h-m;

        int arr1[] = new int[n1];
        int arr2[] = new int[n2];

        for (int i = 0; i < n1; i++) {
            arr1[i] = arr[l+i];
        }

        for (int i = 0; i < n2; i++) {
            arr2[i] = arr[m + 1 + i];
        }

        int i =0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if(arr1[i] <= arr2[j]) {
                arr[k] = arr1[i];
                i++;
            } else {
                arr[k] = arr2[j];
                j++;
            }
            k++;

        }
        while (i < n1){
            arr[k] = arr1[i];
            i++;
            k++;
        }
        while (j < n2){
            arr[k] = arr2[j];
            j++;
            k++;
        }
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
            mergeSort(s3, 0, n-1);
            for (int j = 0; j < n; j++) {
                System.out.print(s3[j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
