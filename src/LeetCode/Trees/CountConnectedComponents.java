package LeetCode.Trees;

import java.util.HashSet;
import java.util.Set;

public class CountConnectedComponents {
  class DSU{
    int rank[];
    int parent[]; // the index will be node value and value in the index would be the parent
    int count;

    DSU(int n){
      rank = new int[n];
      parent = new int[n];
      for(int i = 0; i < n; i++)
        parent[i] = i;
      count = n;
    }

    public void union(int a, int b){
      int parent1 = find(a);
      int parent2 = find(b);

      if(parent1 != parent2){
        if(rank[parent1] <= rank[parent2]){
          parent[parent1] = parent2;
          if(rank[parent1] == rank[parent2])
            rank[parent2]++;
        } else
          parent[parent2] = parent1;
        count--;
      }
    }

    public int find(int n){
      if(parent[n] != n)
        parent[n] = find(parent[n]);
      return parent[n];
    }
  }

  public int countComponents(int n, int[][] edges){
    DSU d = new DSU(n);
    for(int[] edge : edges)
      d.union(edge[0], edge[1]);

    Set<Integer> v = new HashSet<>();
    for(int i = 0; i < n; i++)
      v.add(d.find(i));
    return v.size();
  }

  public static void main(String[] args){
    CountConnectedComponents c = new CountConnectedComponents();
    int n = 5;
    int[][] edges = {{0,1},{1,2},{2,3},{3,4}};
    System.out.print(c.countComponents(n, edges));
  }
}
