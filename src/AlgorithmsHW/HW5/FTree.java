package AlgorithmsHW.HW5;


import java.util.*;
class graph{
    int src;
    int dest;
    int wt;
    int f;

    graph(){}
    graph(int src, int dest, int wt, int f){
        this.src = src;
        this.dest = dest;
        this.wt = wt;
        this.f = f;
    }
}

class vertex {
    int neighbor;
    int weight;
    int F;
    vertex(){}

    vertex(int neighbor,int weight,int F){
        this.neighbor = neighbor;
        this.weight = weight;
        this.F = F;
    }
}

public class FTree {
    public static void main(String[] args) {
        FTree ft = new FTree();
        Scanner in = new Scanner(System.in);
        //Take the input; n = number of vertices and m = number of edges
        String initialip = in.nextLine();
        String[] iniarr = initialip.split(" ");

        int n = Integer.parseInt(iniarr[0]);
        int m = Integer.parseInt(iniarr[1]);

        ArrayList<vertex>[] g = new ArrayList[n];
        ArrayList<graph> ginitial = new ArrayList<>();
        int edgecounter = 0;
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            String edge = in.nextLine();
            String[] edgearr = edge.split(" ");
            int e = Integer.parseInt(edgearr[0]);
            int f = Integer.parseInt(edgearr[1]);
            int h = Integer.parseInt(edgearr[2]);
            int k = Integer.parseInt(edgearr[3]);
            graph ver = new graph(e,f,h,k);
            ginitial.add(ver);
        }

        ft.sort(ginitial,0,ginitial.size()-1, "wt");
        ft.sort(ginitial,0,ginitial.size()-1,"f");
        int dist = 0;
        for (int i = 0; i < ginitial.size(); i++) {
            if(ginitial.size()== edgecounter-1){
                System.out.println(dist);
                break;
            }
            vertex v1 = new vertex(ginitial.get(i).dest,ginitial.get(i).wt,ginitial.get(i).f);
            vertex v2 = new vertex(ginitial.get(i).src,ginitial.get(i).wt,ginitial.get(i).f);
            g[ginitial.get(i).src].add(v1);
            g[ginitial.get(i).dest].add(v2);

            if(ginitial.get(i).f == 1) {
                if (isCycleFormed(g)) {
                    dist = -1;
                    break;
                }
                else{
                    edgecounter++;
                    dist += ginitial.get(i).wt;
                }
            }
            else {
                if (isCycleFormed(g)) {
                    int s1 = g[ginitial.get(i).src].size() - 1;
                    int s2 = g[ginitial.get(i).dest].size() - 1;
                    g[ginitial.get(i).src].remove(s1);
                    g[ginitial.get(i).dest].remove(s2);
                } else {
                    edgecounter++;
                    dist += ginitial.get(i).wt;
                }

            }

        }
        System.out.println(dist);

    }

    public static boolean isCycleFormed(ArrayList<vertex>[] g){


        int[] parent = new int[g.length];
        for (int i = 0; i < g.length; i++) {
            parent[i] = -1;
        }
        for (int i = 0; i < g.length; i++) {
            if (parent[i] == -1){
                LinkedList<Integer> q = new LinkedList<>();
                q.add(i);
                parent[i] = i;
                while (!q.isEmpty()) {
                    int k = q.remove(0);
                    for (vertex nbr : g[k]) {
                        if (parent[nbr.neighbor] == k || (parent[nbr.neighbor] != -1 && parent[k] != nbr.neighbor)) {
                            return true;
                        }
                        if (parent[k] == nbr.neighbor) {
                            continue;
                        }
                        q.addFirst(nbr.neighbor);
                        parent[nbr.neighbor] = k;
                    }
                }
             }
        }
        return false;
    }


    //function to merge for merge sort
    void merge(ArrayList<graph> arr, int l, int m, int r, String s) {

        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;//we added +1 here because, we are passing index and the length of array must be index+1
        int n2 = r - m;

        /* Create temp arrays */
        ArrayList<graph> L = new ArrayList<>();
        ArrayList<graph> R = new ArrayList<>();

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L.add(arr.get(l+i));

        for (int j = 0; j < n2; ++j)
            R.add(arr.get(m+1+j));

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        if(s == "wt") {
            while (i < n1 && j < n2) {
                if (L.get(i).wt <= R.get(j).wt) {
                    arr.set(k, L.get(i));
                    i++;
                } else {
                    arr.set(k, R.get(j));
                    j++;
                }
                k++;
            }
        }
        else{
            while (i < n1 && j < n2) {
                if (L.get(i).f >= R.get(j).f) {
                    arr.set(k, L.get(i));
                    i++;
                } else {
                    arr.set(k, R.get(j));
                    j++;
                }
                k++;
            }
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr.set(k,L.get(i));
            i++;
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (j < n2) {
            arr.set(k,R.get(j));
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    //sort() function implements mergesort
    void sort(ArrayList<graph> arr, int l, int r, String s) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            sort(arr, l, m, s);
            sort(arr, m + 1, r, s);

            // Merge the sorted halves
            merge(arr, l, m, r, s);
        }
    }
}
