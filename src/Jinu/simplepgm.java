package Jinu;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by joetomjob on 3/19/20.
 */
public class simplepgm {
    public static void main(String[] args)throws Exception{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader keyboard= new BufferedReader(isr);
        System.out.println("enter the string");
        System.out.println(keyboard.readLine());
    }
}

