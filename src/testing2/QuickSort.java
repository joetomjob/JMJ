package testing2;

/**
 * Created by joetomjob on 3/18/20.
 */
public class QuickSort {
    public static void main(String[] args) {
        int k[] = {1,2,90,6,3,2,12};
        quickSort(k, 0, k.length-1);
        for (int i = 0; i < k.length; i++) {
            System.out.print(k[i]);
            System.out.print('\t');
        }
    }

    public static void quickSort(int[] k, int l, int r) {
        if(l < r) {
            int index = partition(k, l, r);
            quickSort(k, l, index - 1);
            quickSort(k, index + 1, r);
        }
    }

    public static int partition(int[] k, int l, int r){
        int pivot = k[r];
        int base = l;
        for (int i = l; i < r; i++) {
            if(k[i] <= pivot) {
                int temp = k[i];
                k[i] = k[base];
                k[base] = temp;
                base++;
            }
        }
        k[r] = k[base];
        k[base] = pivot;
        return base;
    }


}
