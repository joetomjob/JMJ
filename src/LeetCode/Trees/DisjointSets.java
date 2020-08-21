package LeetCode.Trees;

import java.util.HashMap;
public class DisjointSets {

  class NodeD{
    long data;
    NodeD parent;
    int rank;

    NodeD(){}
  }

  public HashMap<Long, NodeD> map = new HashMap<>();

  public void makeSet(long val){
    NodeD node = new NodeD();
    node.data = val;
    node.parent = node;
    node.rank = 0;

    map.put(val, node);
  }

  public void union(long data1, long data2){
    NodeD node1 = map.get(data1);
    NodeD node2 = map.get(data2);

    NodeD parent1 = findParent(node1);
    NodeD parent2 = findParent(node2);

    if(parent1.data == parent2.data)
      return;

    if(parent1.rank >= parent2.rank){
      parent2.parent = parent1;

      // increment rank if rank of both the parents are same.
      parent1.rank = parent1.rank == parent2.rank ? parent1.rank+1 : parent1.rank;
    } else
      parent1.parent = parent2;
  }

  public long findSet(long data){
    return findParent(map.get(data)).data;
  }

  public NodeD findParent(NodeD node){
    if(node.parent != node)
      node.parent = findParent(node.parent);
    return node.parent;
  }

  public static void main(String[] args){
    DisjointSets s = new DisjointSets();
    s.makeSet(1);
    s.makeSet(2);
    s.makeSet(3);
    s.makeSet(4);
    s.makeSet(5);
    s.makeSet(6);
    s.makeSet(7);

    s.union(1,2);
    s.union(2,3);
    s.union(4,5);
    s.union(6,7);
    s.union(5,6);
    s.union(3,7);

    System.out.print(s.findSet(1));
    System.out.print(s.findSet(2));
    System.out.print(s.findSet(3));
    System.out.print(s.findSet(4));
    System.out.print(s.findSet(5));
    System.out.print(s.findSet(6));
    System.out.print(s.findSet(7));
  }
}
