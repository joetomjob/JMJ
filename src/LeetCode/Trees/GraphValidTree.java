package LeetCode.Trees;

import java.lang.reflect.Array;
import java.util.*;

public class GraphValidTree {
  public boolean validTree(int n, int[][] edges){
    if(edges.length != n-1) return false;
    HashMap<Integer, List<Integer>> map = new HashMap<>();

    for(int i = 0; i < n; i++){
      map.put(i, new ArrayList<>());
    }

    for(int[] edge : edges){
      map.get(edge[0]).add(edge[1]);
      map.get(edge[1]).add(edge[0]);
    }

    //do iterative dfs. not tree if cycle exists and not all nodes are covered
    boolean res = iterativeDFS(new HashMap<>(), map, n);

    //recursive dfs.
    HashSet<Integer> set = new HashSet<>();
    boolean res1 = recursiveDFS(0, -1, set, map) ? set.size() == n : false;

    // iterative bfs
    boolean res2 = iterativeBFS(new HashMap<>(), map, n);

    // iterative dfs
    boolean res3 = iterativeDFSII(new HashSet<>(), map, n);

    //recursive dfs.
    set = new HashSet<>();
    recursiveDFSII(0, set, map);
    boolean res4 = set.size() == n;

    boolean res5 = iterativeBFSII(new HashSet<>(), map, n);
    return res;
  }

  public boolean iterativeDFS(HashMap<Integer, Integer> parent, HashMap<Integer,  List<Integer>> map, int n) {
    Stack<Integer> s = new Stack<>();
    s.push(0);
    // initially the parent for 0 is set as -1. this hash map is used so that we dont go back to the
    // immediate parent (as this a bidirectional graph, parent and child are connected to each other).
    // also this helps (the keys) to keep track of the already visited elements.
    parent.put(0, -1);

    while (!s.isEmpty()){
      Integer e = s.pop();

      for(Integer neighbor : map.get(e)){
        if(parent.get(e) == neighbor) continue;
        if(parent.containsKey(neighbor)) return false;
        parent.put(neighbor, e);
        s.push(neighbor);
      }
    }
    return parent.size() == n;
  }

  // recursive dfs
  public boolean recursiveDFS(int node, int parent, HashSet<Integer> seen, HashMap<Integer,  List<Integer>> map){
    if(seen.contains(node)) return false;
    seen.add(node);
    for(Integer n : map.get(node)){
      if(n != parent)
        return recursiveDFS(n, node, seen, map);
    }
    return true;
  }

  public boolean iterativeBFS(HashMap<Integer, Integer> parent, HashMap<Integer,  List<Integer>> map, int n){
    Queue<Integer> s = new LinkedList<>();
    s.add(0);
    parent.put(0, -1);

    while (!s.isEmpty()){
      Integer e = s.poll();

      for(Integer neighbor : map.get(e)){
        if(parent.get(e) == neighbor) continue;
        if(parent.containsKey(neighbor)) return false;
        parent.put(neighbor, e);
        s.add(neighbor);
      }
    }
    return parent.size() == n;
  }

  // do not need to save the parent. the count of edges not equal to n-1, then return false immediatly
  public boolean iterativeDFSII(HashSet<Integer> parent, HashMap<Integer,  List<Integer>> map, int n) {
    Stack<Integer> s = new Stack<>();
    s.push(0);
    parent.add(0);

    while (!s.isEmpty()){
      Integer e = s.pop();

      for(Integer neighbor : map.get(e)){
        if(parent.contains(neighbor)) continue;
        parent.add(neighbor);
        s.push(neighbor);
      }
    }
    return parent.size() == n;
  }

  // recursive dfsII
  public void recursiveDFSII(int node, HashSet<Integer> seen, HashMap<Integer, List<Integer>> map){
    if(seen.contains(node)) return;
    seen.add(node);
    for(Integer n : map.get(node)){
        recursiveDFSII(n, seen, map);
    }
  }

  public boolean iterativeBFSII(HashSet<Integer> set, HashMap<Integer,  List<Integer>> map, int n){
    Queue<Integer> s = new LinkedList<>();
    s.add(0);
    set.add(0);

    while (!s.isEmpty()){
      Integer e = s.poll();

      for(Integer neighbor : map.get(e)){
        if(set.contains(neighbor)) continue;
        set.add(neighbor);
        s.add(neighbor);
      }
    }
    return set.size() == n;
  }

  class DSU {
    int parent[];
    int rank[];

    // set count as n initially and after each union we decrement the count. finally if the count is 1,
    // then all elements are connected and if count > 1, then all nodes are not connected
    int count;

    DSU(int n){
      parent = new int[n];
      rank = new int[n];
      for (int i = 0; i < n; i++) {
        parent[i] = i;
      }
      count = n;
    }

    public void union(int a, int b) {
      int pa = find(a);
      int pb = find(b);
      if(pa != pb) {
        if(rank[pa] == rank[pb]){
          parent[pa] = pb;
          rank[pa]++;
        } else if (rank[pa] > rank[pb]){
          parent[pb] = pa;
        } else if(rank[pa] < rank[pb]) {
          parent[pa] = pb;
        }
        count--;
      }
    }


    // to find the parent
    public int find(int a){
      if(parent[a] != a)
        parent[a] = find(a);
      return parent[a];
    }
  }

  public boolean validTreeII(int n, int[][] edges){
    if(edges.length != n-1) return false;
    DSU d = new DSU(n);
    for(int[] edge : edges){
      d.union(edge[0], edge[1]);
    }
    return d.count == 1;
  }


  public static void main(String[] args){
    int[][] edges = {{0,1},{2,3},{1,2}};
    GraphValidTree g = new GraphValidTree();
    System.out.println(g.validTree(4, edges));
    System.out.println(g.validTreeII(4, edges));
  }
}
