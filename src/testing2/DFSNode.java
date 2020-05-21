package testing2;
/*
        A
       / \
      B   C
    / | \
   D  E  F
  /|   |\
 G H   I J
*/


import java.util.*;
import java.util.HashMap;

public class DFSNode{
    String item;
    ArrayList<DFSNode> neighbors = new ArrayList<>();

    DFSNode(String s){
        this.item = s;
    }

    public void addNeighbor(DFSNode node){
        this.neighbors.add(node);
    }

    public static boolean pathExists(DFSNode start, DFSNode goal) {
        return pathExists(start, goal, new HashSet<>());
    }

    public static boolean pathExists(DFSNode start, DFSNode goal, HashSet<DFSNode> visited) {
        if(start.neighbors.contains(goal)){
            return true;
        }

        for (DFSNode g: start.neighbors) {
            if(!visited.contains(g)) {
                visited.add(g);
                return pathExists(g, goal, visited);
            }
        }
        return false;
    }

    public static ArrayList<String> findPath(DFSNode start, DFSNode goal){
        ArrayList<String> res = new ArrayList<>();
        HashMap<String, String> parents = new HashMap<>();
        parents.put(start.item, null);

        if(findPathDFS(start, goal, new HashSet<DFSNode>(), parents)) {
            String next = goal.item;
            while (next != null) {
                res.add(0, next);
                next = parents.get(next);
            }
        }
        return res;
    }

    // function use the  logic in pathExists function above to determine if a path exists. parents hashmap will save the value for parents in all stage
    // key for hashmap is the child and value is the parent
    public static boolean findPathDFS(DFSNode start, DFSNode goal, Set<DFSNode> visited, HashMap<String, String> parents) {
        if(start.neighbors.contains(goal)) {
            parents.put(goal.item, start.item);
            return true;
        }

        for(DFSNode g: start.neighbors) {
            if(!visited.contains(g)) {
                parents.put(g.item, start.item);
                visited.add(g);
                return findPathDFS(g, goal, visited, parents);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DFSNode A = new DFSNode("A");
        DFSNode B = new DFSNode("B");
        DFSNode C = new DFSNode("C");
        DFSNode D = new DFSNode("D");
        DFSNode E = new DFSNode("E");
        DFSNode F = new DFSNode("F");
        DFSNode G = new DFSNode("G");
        DFSNode H = new DFSNode("H");
        DFSNode I = new DFSNode("I");
        DFSNode J = new DFSNode("J");

        A.addNeighbor(B);
        A.addNeighbor(C);
        B.addNeighbor(D);
        B.addNeighbor(E);
        B.addNeighbor(F);
        D.addNeighbor(G);
        D.addNeighbor(H);
        E.addNeighbor(I);
        E.addNeighbor(J);

        System.out.println(pathExists(A, H));
        ArrayList<String> res = findPath(A, H);
        for (String s: res) {
            System.out.print(s);
            System.out.print('\t');
        }
        System.out.print('\n');
    }
}


