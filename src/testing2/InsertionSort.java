package testing2;

/**
 * Created by joetomjob on 3/15/20.
 */
public class InsertionSort {
    public static void insertionSort(int[] x){
        for (int i = 1; i < x.length; i++) {
            for (int j = i; j > 0 ; j--) {
                if(x[j] < x[j-1]) {
                    int temp = x[j];
                    x[j] = x[j-1];
                    x[j-1] = temp;
                }
            }
        }
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i]);
            System.out.print('\t');
        }
    }
    public static void main(String[] args) {
        int[] x = {3,5,1,6,8,4,3,9};
        insertionSort(x);
    }
}
