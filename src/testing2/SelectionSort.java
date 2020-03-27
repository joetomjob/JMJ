package testing2;

/**
 * Created by joetomjob on 3/15/20.
 */
public class SelectionSort {
    public static void selectionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i+1; j < a.length; j++) {
                if(a[j] < a[min]) {
                    min = j;
                }
            }
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            System.out.print('\t');
        }
    }
    public static void main(String[] args) {
        int[] x = {3,5,1,6,8,4,3,9};
        selectionSort(x);
    }
}
