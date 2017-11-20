package AlgorithmsHW.HW5;


import java.util.ArrayList;
import java.util.Scanner;

class k {
    int v;
    int d;

    k(int v, int d) {
        this.v = v;
        this.d = d;
    }
}

public class VertexWeight {
    public static void main(String[] args) {
        VertexWeight vw = new VertexWeight();
        Scanner in = new Scanner(System.in);
        //Take the input; n = number of vertices and m = number of edges
        String initialip = in.nextLine();
        String[] iniarr = initialip.split(" ");

        int n = Integer.parseInt(iniarr[0]);
        int m = Integer.parseInt(iniarr[1]);

        int[][] gr = new int[n + 1][n + 1];
        int[] wt = new int[n + 1];

        String weights = in.nextLine();
        String[] warr = weights.split(" ");
        for (int i = 0; i < n; i++) {
            wt[i + 1] = Integer.parseInt(warr[i]);
        }
        for (int i = 0; i < m; i++) {
            String edge = in.nextLine();
            String[] edgearr = edge.split(" ");
            int e = Integer.parseInt(edgearr[0]);
            int f = Integer.parseInt(edgearr[1]);
            gr[e][f] = wt[f];
            gr[f][e] = wt[e];
        }
        String source = in.nextLine();
        int s = Integer.parseInt(source);

        vw.Dijkstras(gr, s, wt);

    }

    public void Dijkstras(int[][] g, int s, int[] wt) {
        int n = g[0].length;
        ArrayList<k> stack = new ArrayList<>();
        int[] dis = new int[n];


        for (int i = 1; i < n; i++) {
            dis[i] = Integer.MAX_VALUE;

        }

        stack.add(new k(s, wt[s]));
        dis[s] = wt[s];
        update(g, s, stack, dis);
        stack.remove(0);
        for (int i = 1; i < n; i++) {
            if (stack.size() > 0) {
                int[] lowest = lowest(stack, s);
                update(g, lowest[0], stack, dis);
                stack.remove(lowest[1]);
                s = lowest[0];
            }
        }
        for (int i = 1; i < n; i++) {
            System.out.print(dis[i]);
            System.out.print(" ");
        }
    }

    public void update(int[][] g, int s, ArrayList<k> stack, int[] dis) {
        int least = Integer.MAX_VALUE;
        for (int i = 1; i < g[s].length; i++) {
            if (dis[i] > dis[s] + g[s][i] && g[s][i] > 0) {
                dis[i] = dis[s] + g[s][i];
                stack.add(new k(i, dis[i]));
            }
        }
    }

    public int[] lowest(ArrayList<k> stack, int s) {
        int[] lowest = new int[2];
        lowest[0] = Integer.MAX_VALUE;
        int n = stack.size();

        for (int i = 0; i < n; i++) {
            if (stack.get(i).d < lowest[0]) {
                lowest[0] = stack.get(i).d;
                lowest[1] = i;
            }
        }
        lowest[0] = stack.get(lowest[1]).v;

        return lowest;
    }
}
