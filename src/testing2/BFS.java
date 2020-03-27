package testing2;
import java.util.*;
import java.util.HashMap;
import java.util.Queue;

/**
 * Created by joetomjob on 3/24/20.
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
class GraphNodeBFS{
    String data;
    HashMap<String, Integer> neighbors = new HashMap<>();

    GraphNodeBFS(){}

    GraphNodeBFS(String key){
        this.data = key;
    }

    public void addNeighbor(String key, int weight){
        neighbors.put(key, weight);
    }

}

class GraphBFS{
    HashMap<String, GraphNodeBFS> graph = new HashMap<>();

    public void addVertex(String key, GraphNodeBFS node){
        graph.put(key, node);
    }

    public boolean pathExists(String start, String goal) {
        return pathExists(start, goal, new HashSet<String>());
    }

    public boolean pathExists(String start, String goal, Set<String> visited) {
        Queue<String> q = new LinkedList<>();
        q.add(start);
        visited.add(start);

        while (!q.isEmpty()) {
            String c = q.poll();
            if(c == goal){
                return true;
            }

            for (Map.Entry<String, Integer> m: this.graph.get(c).neighbors.entrySet()) {
                if(!visited.contains(m.getKey())) {
                    q.add(m.getKey());
                    visited.add(m.getKey());
                }
            }
        }
        return false;
    }

    public ArrayList<String> findPath(String start, String goal) {
        ArrayList<String> res = new ArrayList<>();
        HashMap<String, String> parents = new HashMap<>();
        parents.put(start, null);
        if (findPathBFS(start, goal, new HashSet<>(), parents)) {
            String n = goal;
            while(n != null) {
                res.add(0, n);
                n = parents.get(n);
            }
        }
        return res;
    }

    public boolean findPathBFS(String start, String goal, HashSet<String> visited, HashMap<String, String> parents){
        Queue<String> q = new LinkedList<>();
        q.add(start);
        visited.add(start);

        while (!q.isEmpty()){
            String s = q.poll();

            if(s == goal) {
                return true;
            }

            for (Map.Entry<String, Integer> entry: this.graph.get(s).neighbors.entrySet()) {
                if(!visited.contains(entry.getKey())){
                    parents.put(entry.getKey(), s);
                    q.add(entry.getKey());
                    visited.add(entry.getKey());
                }
            }

        }
        return false;
    }
}

public class BFS {
    public static void main(String[] args) {
        GraphNodeBFS A = new GraphNodeBFS("A");
        GraphNodeBFS B = new GraphNodeBFS("B");
        GraphNodeBFS C = new GraphNodeBFS("C");
        GraphNodeBFS D = new GraphNodeBFS("D");
        GraphNodeBFS E = new GraphNodeBFS("E");
        GraphNodeBFS F = new GraphNodeBFS("F");
        GraphNodeBFS G = new GraphNodeBFS("G");
        GraphNodeBFS H = new GraphNodeBFS("H");
        GraphNodeBFS I = new GraphNodeBFS("I");
        GraphNodeBFS J = new GraphNodeBFS("J");


        A.addNeighbor("B", 3);
        A.addNeighbor("C", 4);
        B.addNeighbor("D", 4);
        B.addNeighbor("E", 4);
        B.addNeighbor("F", 4);
        D.addNeighbor("G", 4);
        D.addNeighbor("H", 4);
        E.addNeighbor("I", 4);
        E.addNeighbor("J", 4);

        GraphBFS g = new GraphBFS();

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
        ArrayList<String> res = g.findPath("A", "F");
        for (String s: res) {
            System.out.print(s);
            System.out.print('\t');
        }
        System.out.print('\n');
    }

}
