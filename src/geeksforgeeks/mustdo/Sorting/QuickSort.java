package geeksforgeeks.mustdo.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by joetomjob on 6/8/19.
 */
public class QuickSort {

    public static void quickSort(int[] arr, int l, int h){
        if(l < h) {
            int pi = partition(arr, l, h);

            quickSort(arr, l, pi - 1);
            quickSort(arr, pi + 1, h);
        }

    }

    public static int partition(int[] arr, int l, int h){
        int pi = arr[h];
        int l_idx = l-1;
        for (int i = l; i < h; i++) {
            if(arr[i] < pi){
                l_idx++;
                int temp = arr[l_idx];
                arr[l_idx] = arr[i];
                arr[i] = temp;
            }
        }
        int temp = arr[l_idx+1];
        arr[l_idx+1] = arr[h];
        arr[h] = temp;

        return l_idx+1;
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
            quickSort(s3, 0, n-1);
            for (int j = 0; j < n; j++) {
                System.out.print(s3[j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
