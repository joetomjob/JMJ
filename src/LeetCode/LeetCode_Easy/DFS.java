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

import ctci.LinkedList.*;

import java.lang.reflect.Array;
import java.util.*;
import java.util.List;

/**
 * Created by joetomjob on 6/30/18.
 */

class Node{
    char val;
    ArrayList<Node> children;
    boolean visited = false;

    Node(char a){
        val = a;
        children = new ArrayList<Node>();
    }
}

class Graph{
    HashMap<Character, Node> nodeMap = new HashMap<>();
//    ArrayList<Node> nodes = new ArrayList<>();
}

public class DFS {

    public static void  traverse(Node root){
        _traverse(root, new ArrayList<>());
    }

    public static void _traverse(Node node, ArrayList<Node> visited){
        if(node == null)
            return;

        visited.add(node);
        System.out.print(node.val);
        System.out.print('\t');
        for (Node nbr : node.children) {
            _traverse(nbr, visited);
        }
    }

    public static boolean pathExists(Node start, Node end){
        return _pathExists(start, end, new ArrayList<>());
    }

    public static boolean _pathExists(Node start, Node end, ArrayList<Node> visited){
        if (start.children.contains(end))
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

    public static ArrayList<Node> findPath(Node start, Node end){
        return _findPath(start, end, new ArrayList<Node>(), new ArrayList<Node>());
    }

    public static ArrayList<Node> _findPath(Node start, Node end, ArrayList<Node> visited, ArrayList<Node> path){
        if (start.children.contains(end)){
            path.add(end);
            path.add(start);
            return path;
        }

        for (Node nbr : start.children) {
            if(!visited.contains(nbr)){
                visited.add(start);
                ArrayList<Node> retpath = _findPath(nbr, end, visited, path);
                if(retpath != null && retpath.size() > 0){
                    path.add(start);
                    return path;
                }
            }
        }

        return new ArrayList<Node>();
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
