package LeetCode.ArraysAndStrings;

public class NextPermutation {
    public static void nextPermutation(int[] a) {

        int i = a.length - 2;
        while (i >= 0 && a[i+1] <= a[i]) {
            i--;
        }

        if(i >= 0) {
            int j = a.length-1;
            while (j > i && a[j] <= a[i]) {
                j--;
            }
            swap(a, i, j);
        }
        reverseElements(a, i+1);
    }

    public static void reverseElements(int[] a, int start) {
        int n = start + ((a.length - start) / 2);
        int j = a.length - 1;
        for (int i = start; i < n; i++) {
            swap(a, i, j);
            j--;
        }
    }

    public static void swap(int[] a, int start, int end) {
        int temp = a[start];
        a[start] = a[end];
        a[end] = temp;
    }

    public static void printArray(int[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            System.out.print('\t');
        }
        System.out.print('\n');
    }

    public static void main(String[] args) {
//        int[] a = {1,5,8,4,7,6,5,3,1};
//        int[] a = {7,6,5,4,1};
        int[] a = {3,2,1};
        nextPermutation(a);
        printArray(a);
    }
}
