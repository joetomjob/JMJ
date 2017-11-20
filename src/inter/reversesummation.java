package inter;

/**
 * Created by joetomjob on 3/29/17.
 */
public class reversesummation {
    public static void main(String[] args) {
        reversesummation r = new reversesummation();
        int j = r.rever(4358, 754);
    }
    public static  int rever(int n1, int n2){

        int rev = 0;
        while(n1 != 0){
            rev = rev*10 + n1%10;
            n1 = n1/10;
        }

        int rev2 = 0;
        while(n2 != 0){
            rev2 = rev2*10 + n2%10;
            n2 = n2/10;
        }

        int k = rev+rev2;

        int rev3 = 0;
        while(k != 0){
            rev3 = rev3*10 + k%10;
            k = k/10;
        }

        return rev3;
    }
}
