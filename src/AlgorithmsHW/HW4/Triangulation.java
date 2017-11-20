package AlgorithmsHW.HW4;

import java.util.Scanner;

public class Triangulation {
    public static void main(String[] args) {
        Triangulation t = new Triangulation();
        Scanner in = new Scanner(System.in);
        //Take the input; n = the total number points
        Integer n = in.nextInt();
        in.nextLine();

        String[] strPoint = new String[n];

        //Take the n points
        for (int i = 0; i < n; i++) {
            strPoint[i] = in.nextLine();
        }

        String[][] strPointtwoD = new String[n][2];

        //Store n point in String 2D array
        for (int i = 0; i < n; i++) {
            strPointtwoD[i] = strPoint[i].split(" ");
        }

        double[][] points = new double[n][2];
        //Store n points in double 2D array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                points[i][j] = Double.parseDouble(strPointtwoD[i][j]);
            }
        }
        double[][] s = new double[n][n];
        for (int x = 0; x < n; x++) {
            int i = 0, j;
            for (j = x; j < n; j++) {
                if (j > i + 2) {
                    s[i][j] = Double.MAX_VALUE;
                    for (int k = i + 1; k <= j - 1; k++) {
                        double dist = 0;
                        if (k == i + 1) {
                            dist += t.calculateDistance(points[k], points[j]);
                        } else if (k == j - 1) {
                            dist += t.calculateDistance(points[i], points[k]);
                        } else {
                            dist += t.calculateDistance(points[k], points[j]) + t.calculateDistance(points[i], points[k]);
                        }
                        dist += s[i][k] + s[k][j];
                        if (dist < s[i][j]) {
                            s[i][j] = dist;
                        }
                    }
                }
                i++;
            }
        }

        System.out.println((int)Math.floor(s[0][n-1]));

    }
    //Function used to calculate the distance between 2 points
    public double calculateDistance(double[] p1, double[] p2){
        double d = 0;
        d = Math.sqrt(Math.pow((p2[1] - p1[1]),2) + Math.pow((p2[0] - p1[0]),2));
        return d;
    }
}
