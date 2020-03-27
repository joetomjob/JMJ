package Jinu;
import java.io.*;


/**
 * Created by joetomjob on 3/24/20.
 */
public class LargestJinu {
    public static void main(String[] args)throws Exception
    {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter the first no ");
        int num1 = Integer.parseInt(br.readLine());
        System.out.println("enter the second no ");
        int num2 = Integer.parseInt(br.readLine());
        System.out.println("enter the third no ");
        int num3 = Integer.parseInt(br.readLine());


        if(num1>num2)
        {
            if (num1 > num3)
                {
                    System.out.println("num1 is largest ");
                }
            else
                {
                    System.out.println("num3 is largest");
                }
        }
        else if(num2>num3)
                {
                    System.out.println("num2 is largest");
                }
        else
                {
                    System.out.println("num3 is largest");
                }
    }
}
