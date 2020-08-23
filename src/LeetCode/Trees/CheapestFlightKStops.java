package LeetCode.Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class CheapestFlightKStops {
  class Neighbor {
    int cor;
    int price;

    Neighbor(int n, int price){
      this.cor = n;
      this.price = price;
    }
  }
  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K){
    // adjacency list. directed graph
    ArrayList<Neighbor>[] g = new ArrayList[n];
    for(int i = 0; i < n; i++) g[i] = new ArrayList<>();
    for(int[] f : flights) {
      g[f[0]].add(new Neighbor(f[1], f[2]));
    }

    PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[0] - b[0]);
    q.add(new int[] {0, src, K+1}); // array contains [price, source, no of hops left]
    while(!q.isEmpty()){
      int[] cur = q.poll();
      int price = cur[0], source = cur[1], remStops = cur[2];
      if(source == dst) return price;

      if(remStops > 0) {
        for (Neighbor i : g[source]) {
          q.add(new int[] {price + i.price, i.cor ,remStops-1});
        }
      }
    }
    return -1;
  }
  public static void main(String[] args){
    int[][] flights = {{4,1,1},{1,2,3},{0,3,2},{0,4,10},{3,1,1},{1,4,3}};
    CheapestFlightKStops c = new CheapestFlightKStops();
    System.out.print(c.findCheapestPrice(5, flights, 2, 1, 1));
  }
}
