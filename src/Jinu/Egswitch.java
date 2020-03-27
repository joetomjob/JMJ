package Jinu;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by joetomjob on 3/24/20.
 */
public class Egswitch {



    public int daysInMonth(int month)
    {
        switch (month)
        {
            case 2:
                return 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            default:
                return 0;

        }
    }

    public static void main(String[] args)throws Exception
    {
        Egswitch ad = new Egswitch();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int month = Integer.parseInt(br.readLine());
        System.out.println(ad.daysInMonth(month));


    }


}



