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

import java.util.ArrayList;

/**
 * Created by joetomjob on 7/14/18.
 */
public class RouteBetweenNodes {
    public static boolean pathExists(Node start, Node end){
        return _pathExists(start, end, new ArrayList<Node>());
    }

    public static boolean _pathExists(Node start, Node end, ArrayList<Node> visited){
        if(start.children.contains(end))
            return true;

        for (Node nbr : start.children) {
            if(!visited.contains(nbr)){
                visited.add(start);
                if(_pathExists(nbr, end, visited))
                    return true;
            }
        }
        return false;
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

        System.out.print(pathExists(A, C));
    }
}
