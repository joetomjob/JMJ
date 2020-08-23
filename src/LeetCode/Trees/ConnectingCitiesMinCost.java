package LeetCode.Trees;

import java.util.*;

public class ConnectingCitiesMinCost {
  class DSU {
    int[] rank;
    int[] parent;

    DSU(int n){
      rank = new int[n+1];
      parent = new int[n+1];
      for(int i = 0; i < n+1; i++)
        parent[i] = i;
    }

    public boolean union(int a, int b){
      int p1 = find(a);
      int p2 = find(b);

      if(p1 != p2){
        if(rank[p1] <= rank[p2]){
          parent[p1] = p2;
          if(rank[p1] == rank[p2]){
            rank[p2]++;
          }
        } else {
          parent[p2] = p1;
        }
        return true;
      } else
        return false;
    }

    public int find(int a){
      if(parent[a] != a)
        parent[a] = find(parent[a]);
      return parent[a];
    }
  }

  public int minimumCost(int N, int[][] connections){
    DSU d = new DSU(N);
    Arrays.sort(connections, (a, b) -> a[2] - b[2]); // sort based on weights

    int res = 0;
    List<int[]> resList = new ArrayList<>();

    // kruskals algo. sort input based on weight. add edge if points are connected. ignore if they are already connected
    for(int[] con : connections) {
      if(d.union(con[0], con[1])){
        res += con[2];
        resList.add(con);
      }
    }

    // put points in set to find number of connected components.
    Set<Integer> set = new HashSet<>();
    for(int i = 1; i < N+1; i++)
      set.add(d.find(i));

    int[][] resArr = new int[resList.size()][3];
    resArr = (int[][]) resList.toArray();

    // if number of connected components is more than one, all the points are not connected
    return set.size() > 1 ? -1 : res;

  }

  public static void main(String[] args) {
    int N = 3;
    int[][] input = {{1,2,5},{1,3,6},{2,3,1}};
    ConnectingCitiesMinCost m = new ConnectingCitiesMinCost();
    System.out.print(m.minimumCost(N, input));
  }
}
