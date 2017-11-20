package AlgorithmsHW.HW4;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;


public class Components {
    public static void main(String[] args) {
        Components c = new Components();
        Scanner in = new Scanner(System.in);
        //Take the input; n = number of vertices and m = number of edges
        String initialip = in.nextLine();
        String[] iniarr = initialip.split(" ");

        int n = Integer.parseInt(iniarr[0]);
        int m = Integer.parseInt(iniarr[1]);

        //construct the graph
        ArrayList<Integer>[] g = new ArrayList[n + 1];
        for (int i = 0; i < m; i++) {
            String temp = in.nextLine();
            String temparr[] = temp.split(" ");
            int v1 = Integer.parseInt(temparr[0]);
            int v2 = Integer.parseInt(temparr[1]);
            if (g[v1] == null) {
                g[v1] = new ArrayList<Integer>();

            }
            if (g[v2] == null) {
                g[v2] = new ArrayList<Integer>();
            }

            g[v1].add(v2);
            g[v2].add(v1);
        }


        int[] seen = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            seen[i] = 0;
        }
        int count = 1;
        for (int i = 1; i < n + 1; i++) {
            if (seen[i] == 0 && g[i] != null) {
                c.doDFS(g, seen, i, count);
                count++;
            }
        }
        count = count - 1;
        for (int i = 1; i < n + 1; i++) {
            if (seen[i] == 0) {
                count += 1;
            }
        }

        System.out.println(count);

    }

    //function to do the iterative DFS
    public void doDFS(ArrayList<Integer>[] g, int[] seen, int n, int count) {
        seen[n] = count;
        Stack<Integer> s = new Stack();
        ArrayList<Integer> visited = new ArrayList<>();
        visited.add(n);
        s.push(n);
        while (!s.empty()) {
            int k = s.pop();
            for (int i = 0; i < g[k].size(); i++) {
                if (!visited.contains(g[k].get(i))) {
                    s.push(g[k].get(i));
                    visited.add(g[k].get(i));
                    if (seen[g[k].get(i)] == 0) {
                        seen[g[k].get(i)] = count;
                    }
                }
            }
        }
    }
}
