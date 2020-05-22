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
import java.util.Queue;

public class BFSNode {
    String item;
    ArrayList<BFSNode> neighbors = new ArrayList<>();

    BFSNode(String s){
        this.item = s;
    }

    public void addNeighbor(BFSNode node){
        this.neighbors.add(node);
    }

    public static boolean pathExists(BFSNode start, BFSNode goal) {
        return pathExists(start, goal, new HashSet<BFSNode>());
    }

    public static boolean pathExists(BFSNode start, BFSNode goal, HashSet<BFSNode> visited) {
        Queue<BFSNode> q = new LinkedList<>();
        q.add(start);
        visited.add(start);

        while (!q.isEmpty()) {
            BFSNode c = q.poll();
            if(c == goal){
                return true;
            }


            for (BFSNode node: c.neighbors) {
                if(!visited.contains(node)) {
                    q.add(node);
                    visited.add(node);
                }
            }
        }
        return false;
    }

    public static ArrayList<String> findPath(BFSNode start, BFSNode goal) {
        ArrayList<String> res = new ArrayList<>();
        HashMap<BFSNode, BFSNode> parents = new HashMap<>();
        parents.put(start, null);
        if (findPathBFS(start, goal, new HashSet<>(), parents)) {
            BFSNode n = goal;
            while(n != null) {
                res.add(0, n.item);
                n = parents.get(n);
            }
        }
        return res;
    }

    public static boolean findPathBFS(BFSNode start, BFSNode goal, HashSet<BFSNode> visited, HashMap<BFSNode, BFSNode> parents){
        Queue<BFSNode> q = new LinkedList<>();
        q.add(start);
        visited.add(start);

        while (!q.isEmpty()){
            BFSNode s = q.poll();

            if(s == goal) {
                return true;
            }

            for (BFSNode node: s.neighbors) {
                if(!visited.contains(node)){
                    parents.put(node, s);
                    q.add(node);
                    visited.add(node);
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        BFSNode A = new BFSNode("A");
        BFSNode B = new BFSNode("B");
        BFSNode C = new BFSNode("C");
        BFSNode D = new BFSNode("D");
        BFSNode E = new BFSNode("E");
        BFSNode F = new BFSNode("F");
        BFSNode G = new BFSNode("G");
        BFSNode H = new BFSNode("H");
        BFSNode I = new BFSNode("I");
        BFSNode J = new BFSNode("J");


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
        ArrayList<String> res = findPath(A, F);
        for (String s: res) {
            System.out.print(s);
            System.out.print('\t');
        }
        System.out.print('\n');
    }
}
