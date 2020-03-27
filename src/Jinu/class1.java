package Jinu;

/**
 * Created by joetomjob on 3/16/20.
 */
import java. util.Scanner;

public class class1 {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);

        System.out.println("enter the first no");
        int k = Integer.parseInt(myObj.nextLine());

        System.out.println("enter the second no");
        int m = Integer.parseInt(myObj.nextLine());

        class1 x = new class1();
        int y = x.sum(k , m);
        System.out.println(y);
    }

    private int sum(int a, int b)
    {
       return(a + b);

    }
}
