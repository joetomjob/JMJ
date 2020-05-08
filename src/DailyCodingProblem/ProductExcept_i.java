package DailyCodingProblem;

//shouldn't involve division
public class ProductExcept_i {
    public static int[] productExcept_i(int[] a) {

        int[] ans = new int[a.length];

        // product of left
        int p = 1;
        for (int i = 0; i < a.length; i++) {
            ans[i] = p;
            p *= a[i];
        }

        // product of right
        p = 1;
        for (int i = a.length -1; i >= 0; i--) {
            ans[i] *= p;
            p *= a[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5 };
        int[] res = productExcept_i(a);
        for (int i = 0; i < res.length; i++) {
            System.out.print(" "+ res[i]);
        }
    }
}
