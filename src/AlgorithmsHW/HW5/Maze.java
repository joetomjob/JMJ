package AlgorithmsHW.HW5;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by joetomjob on 4/22/17.
 */
public class Maze {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //Take the input; d1 = number of rows and d2 = number of columns
        String initialip = in.nextLine();
        String[] iniarr = initialip.split(" ");

        int d1 = Integer.parseInt(iniarr[0]);
        int d2 = Integer.parseInt(iniarr[1]);

        int[][] g = new int[d1][d2];
        
        int destr,destcol,startr,startcol;
        for (int i = 0; i < d1; i++) {
            String row = in.nextLine();
            String[] rowarr = row.split(" ");
            for (int j = 0; j < d2; j++) {
                g[i][j] = Integer.parseInt(rowarr[j]);
                if(g[i][j] == 2){
                    startr = i;
                    startcol = j;
                }
                else if(g[i][j]==3){
                    destr = i;
                    destcol = j;
                }
            }
        }




        for (int i = 0; i < d1; i++) {
            for (int j = 0; j < d2; j++) {
                System.out.print(g[i][j]);
                System.out.print("\t");
            }
            System.out.print("\n");
        }


    }
}
