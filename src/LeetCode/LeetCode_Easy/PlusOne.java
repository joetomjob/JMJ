package LeetCode.LeetCode_Easy;

/**
 * Created by joetomjob on 6/14/18.
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >= 0 ; i--) {
            if(digits[i]<9){
                digits[i] += 1;
                return digits;
            }
            else{
                digits[i] = 0;
            }
        }
        int[] result = new int[digits.length+1];
        result[0] = 1;
        return result;
     }

    public static void main(String[] args) {
        int[] digits = {9,9};
        PlusOne p = new PlusOne();
        int[] x = p.plusOne(digits);
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i]);
            System.out.print('\t');
        }


    }
}
