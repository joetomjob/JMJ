/**
 * Created by joetomjob on 7/14/18.
 */
package LeetCode.LeetCode_Easy;

/*
         A
        / \
       B   C
      /|\
     D E F
    /| |\
   G H I J
*/



import java.util.*;
public class BFS {

    public static void traverse(Node root){
        Queue<Node> q= new LinkedList<>();
        q.add(root);
        ArrayList<Node> visited = new ArrayList<>();
        visited.add(root);
        while (q != null && !q.isEmpty()){
            Node a = q.poll();
            System.out.print(a.val);
            System.out.print('\t');
            for (Node nbr : a.children) {
                if(!visited.contains(nbr)){
                    q.add(nbr);
                    visited.add(nbr);
                }
            }
        }
    }

    public static boolean pathExists(Node start, Node end){
        Queue<Node> q= new LinkedList<>();
        q.add(start);
        ArrayList<Node> visited = new ArrayList<>();
        visited.add(start);
        while (q != null && !q.isEmpty()){
            Node a = q.poll();
            if(a == end)
                return true;
            for (Node nbr : a.children) {
                if(!visited.contains(nbr)){
                    q.add(nbr);
                    visited.add(nbr);
                }
            }
        }

        return false;
    }

    public static ArrayList<Node> findPath(Node start, Node end){
        Queue<Node> q= new LinkedList<>();
        q.add(start);
        HashMap<Node, Node> parents = new HashMap<>();
        parents.put(start, null);
        while (q != null && !q.isEmpty()){
            Node a = q.poll();
            if(a == end)
                return make_path(a, parents);
            for (Node nbr : a.children) {
                if(!parents.containsKey(nbr)){
                    q.add(nbr);
                    parents.put(nbr, a);
                }
            }
        }
        return new ArrayList<Node>();
    }

    public static ArrayList<Node> make_path(Node a, HashMap<Node, Node> parents){
        ArrayList<Node> res = new ArrayList<>();
        res.add(a);
        Node current = a;
        while (a != null){
            a = parents.get(a);
            if(a != null)
                res.add(a);
        }
        return res;
    }

    public static void main(String[] args) {
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        Node H = new Node('H');
        Node I = new Node('I');
        Node J = new Node('J');

        A.children.add(B);
        A.children.add(C);
        B.children.add(D);
        B.children.add(E);
        B.children.add(F);
        D.children.add(G);
        D.children.add(H);
        E.children.add(I);
        E.children.add(J);

        Graph g = new Graph();
        g.nodeMap.put('A', A);
        g.nodeMap.put('B', B);
        g.nodeMap.put('C', C);
        g.nodeMap.put('D', D);
        g.nodeMap.put('E', E);
        g.nodeMap.put('F', F);
        g.nodeMap.put('G', G);
        g.nodeMap.put('H', H);
        g.nodeMap.put('I', I);
        g.nodeMap.put('J', J);

        traverse(A);
        System.out.println();
        traverse(g.nodeMap.get('A'));
        System.out.println();
        System.out.println(pathExists(A, J));
        System.out.println(pathExists(g.nodeMap.get('A'), g.nodeMap.get('J')));

        ArrayList<Node> res = findPath(g.nodeMap.get('A'), g.nodeMap.get('J'));
        Collections.reverse(res);
        for (Node a : res) {
            System.out.print(a.val);
            System.out.print('\t');
        }
    }
}
