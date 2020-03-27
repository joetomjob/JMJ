package testing2;

/**
 * Created by joetomjob on 3/18/20.
 */
public class BinarySearch {
    public static void main(String[] args) {
        int k[] = {1, 2, 6, 18, 23, 33, 47, 82, 88, 89, 90};
        System.out.print(binarySearchHelper(k, 81));

    }

    public static int binarySearchHelper(int[] k, int val) {
        return binarySearch(k, 0, k.length-1, val);

    }

    public static int binarySearch(int[] k, int l, int r, int val) {
        if (l <= r) {

            int mid = (l + r) / 2;

            if (k[mid] == val) {
                return mid;
            } else if (val < k[mid]) {
                return binarySearch(k, l, mid - 1, val);
            } else{
                return binarySearch(k, mid + 1, r, val);
            }
        } else {
            return -1;
        }
    }
}
