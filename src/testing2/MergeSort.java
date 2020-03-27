package testing2;

/**
 * Created by joetomjob on 3/15/20.
 */
public class MergeSort {
    public static void mergeSort(int[] x, int l, int r) {

        if(l >= r) {
            return;
        }

        int m = (l + r) / 2;

        mergeSort(x, l, m);
        mergeSort(x, m + 1, r);

        merge(x, l, r);

    }

    public static void merge(int[] x, int l, int r) {

        int m = (r + l) / 2;
        int i =l, j =m+1, k =0;
        int[] res = new int[r-l+1];

        while (i <= m && j <= r) {
            if(x[i] < x[j]) {
                res[k] = x[i];
                i++;
                k++;
            } else {
                res[k] = x[j];
                j++;
                k++;
            }
        }

        while (i <= m) {
            res[k] = x[i];
            i++; k++;
        }
        while (j <= r) {
            res[k] = x[j];
            j++; k++;
        }

        System.arraycopy(res, 0 , x, l , r-l+1);

    }



    public static void main(String[] args) {
        int[] x = {3,5,1,6,8,4,3,9};
        mergeSort(x, 0, x.length-1);
        for (int i = 0; i < x.length; i++) {
            System.out.print('\t');
            System.out.print(x[i]);
        }

    }
}
