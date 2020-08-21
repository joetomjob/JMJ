package LeetCode.Trees;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class RemoveStones {
  // the answer would be total stones - number of connected components

  class DSU{
    int rank[];
    int parent[]; // the index will be node value and value in the index would be the parent

    DSU(int n){
      rank = new int[n];
      parent = new int[n];
      for(int i = 0; i < n; i++)
        parent[i] = i;
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
      }
    }

    public int find(int n){
      if(parent[n] != n)
        parent[n] = find(parent[n]);
      return parent[n];
    }
  }

  public int removeStones(int[][] stones){
    int n = stones.length;
    DSU d = new DSU(n);

    for(int i = 0; i < n; i++){
      for(int j = i+1; j < n; j++){
        if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1])
          d.union(i, j);
      }
    }
    Set<Integer> v = new HashSet<>();
    for(int i = 0; i < n; i++)
      v.add(d.find(i));

    return n - v.size();

  }

  public static void main(String[] args){
//    int[][] stones = {{2,1},{2,2},{0,0},{1,2},{0,1},{1,0}};
//    int[][] stones = {{0,0},{0,2},{1,1},{2,0},{2,2}};
    int[][] stones = {{0,1},{1,2},{1,3},{3,3},{2,3},{0,2}};
    RemoveStones r = new RemoveStones();
    System.out.print(r.removeStones(stones));
  }
}
