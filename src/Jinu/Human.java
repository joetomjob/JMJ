package Jinu;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.io.*;


/**
 * Created by joetomjob on 3/20/20.
 */
public class Human {
    public int age;
    public int mark;
    public String name;
    public static int numberOfHumans;


    public Human()
    {
        numberOfHumans++;
    }

    public static void print()
    {
        System.out.println("The number of humans is " + numberOfHumans);
    }

    public void introduce()
    {
        System.out.println("I am " + name + " and I am " + age + " years old.");
    }

    public void copy(Human original)
    {
        this.age = original.age;
        this.name = original.name;
    }


    public static void main(String[] args) throws Exception{

        Human jinu = new Human();
        jinu.age = 20;
        jinu.name = "rose";

        jinu.introduce();

        Human original = new Human();
        original.age = 50;
        original.name = "apple";





        jinu.copy(original);
        jinu.introduce();
        print();

        Human[] data = new Human[50];
        for (int i = 0; i < data.length; i++) {
            data[i] = new Human();
            System.out.println(data[i].age);
        }

    }
}
