package Jinu;
import java.io.*;

/**
 * Created by joetomjob on 3/26/20.
 */
public class PrimesRange {
    public static boolean isPrime(int i){
        int divisor=2;
        while(divisor < i) {
            if (i % divisor == 0) {
                return false;
            }
            divisor++;
        }
        return true;
    }


    public static void printPrime(int n) {
        for (int i = 2; i <= n; i++){
            if(isPrime(i)){
                System.out.println(" " + i);
            }
        }

    }

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long startTime = System.nanoTime();
        printPrime(n);
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("Execution time in nanoseconds  : " + timeElapsed);
    }
}
