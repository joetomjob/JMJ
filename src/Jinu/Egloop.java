package Jinu;
import java.io.*;

/**
 * Created by joetomjob on 3/26/20.
 */
public class Egloop {

    public static boolean givePrime(int n){
        int divisor = 2;
        while(divisor < n) {
            if (n % divisor == 0) {
                return false;
            }
            divisor++;
        }
        return true;
    }

    public static void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(givePrime(n));

    }

}


/*public class Egloop {

    public static boolean givePrime(int n){
        for(int i=2; i<n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(givePrime(n));
    }
}*/



