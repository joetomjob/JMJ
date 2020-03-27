package testing2;
import java.util.*;
import java.util.HashMap;

/**
 * Created by joetomjob on 3/22/20.
 */

/*
        A
       / \
      B   C
    / | \
   D  E  F
  /|   |\
 G H   I J
*/

class GraphNode{
    String data;
    HashMap<String, Integer> neighbours = new HashMap<>();

    GraphNode(){}

    GraphNode(String s){
        this.data = s;
    }

    public void addNeighbor(String key, int val){
        this.neighbours.put(key, val);
    }
}

class Graph {

    HashMap<String, GraphNode> graph = new HashMap<>();

    Graph(){}

    public void addVertex(String key, GraphNode value) {
        graph.put(key, value);
    }

    public boolean pathExists(String start, String goal) {
        return pathExists(start, goal, new HashSet<>());
    }

    public boolean pathExists(String start, String goal, Set<String> visited) {
        if(this.graph.get(start).neighbours.containsKey(goal)){
            return true;
        }

        for (Map.Entry<String, Integer> map: this.graph.get(start).neighbours.entrySet()) {
            if(!visited.contains(map.getKey())) {
                visited.add(map.getKey());
                return pathExists(map.getKey(), goal, visited);
            }
        }
        return false;
    }

    public ArrayList<String> findPath(String start, String goal){
        ArrayList<String> res = new ArrayList<>();
        HashMap<String, String> parents = new HashMap<>();
        parents.put(start, null);

        if(findPathDFS(start, goal, new HashSet<String >(), parents)) {
            String next = goal;
            while (next != null) {
                res.add(0, next);
                next = parents.get(next);
            }
        }
        return res;
    }

    // function use the  logic in pathExists function above to determine if a path exists. parents hashmap will save the value for parents in all stage
    // key for hashmap is the child and value is the parent
    public boolean findPathDFS(String start, String goal, Set<String> visited, HashMap<String, String> parents) {
        if(this.graph.get(start).neighbours.containsKey(goal)) {
            parents.put(goal, start);
            return true;
        }

        for(Map.Entry<String, Integer> entry: this.graph.get(start).neighbours.entrySet()) {
            if(!visited.contains(entry.getKey())) {
                parents.put(entry.getKey(), start);
                visited.add(entry.getKey());
                return findPathDFS(entry.getKey(), goal, visited, parents);
            }
        }
        return false;
    }
}
public class DFS {
    public static void main(String[] args) {
        GraphNode A = new GraphNode("A");
        GraphNode B = new GraphNode("B");
        GraphNode C = new GraphNode("C");
        GraphNode D = new GraphNode("D");
        GraphNode E = new GraphNode("E");
        GraphNode F = new GraphNode("F");
        GraphNode G = new GraphNode("G");
        GraphNode H = new GraphNode("H");
        GraphNode I = new GraphNode("I");
        GraphNode J = new GraphNode("J");

        A.addNeighbor("B", 3);
        A.addNeighbor("C", 4);
        B.addNeighbor("D", 4);
        B.addNeighbor("E", 4);
        B.addNeighbor("F", 4);
        D.addNeighbor("G", 4);
        D.addNeighbor("H", 4);
        E.addNeighbor("I", 4);
        E.addNeighbor("J", 4);

        Graph g = new Graph();

        g.addVertex("A", A);
        g.addVertex("B", B);
        g.addVertex("C", C);
        g.addVertex("D", D);
        g.addVertex("E", E);
        g.addVertex("F", F);
        g.addVertex("G", G);
        g.addVertex("H", H);
        g.addVertex("I", I);
        g.addVertex("J", J);

        System.out.println(g.pathExists("A", "H"));
        ArrayList<String> res = g.findPath("A", "H");
        for (String s: res) {
            System.out.print(s);
            System.out.print('\t');
        }
        System.out.print('\n');
    }
}
