package ctci.TreesandGraphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by joetomjob on 8/11/19.
 */

public class dfs {
    HashMap<Integer, Node> nodeLookup = new HashMap<Integer, Node>();

    private static class Node {
        int id;
        LinkedList<Node> adjacent = new LinkedList<Node>();
        private Node(int id){
            this.id = id;
        }
    }

    private Node getNode(int id) {
        if(nodeLookup.containsKey(id)) {
            return nodeLookup.get(id);
        } else {
            return null;
        }
    }

    public void addEdge(int source, int destination) {
        Node s = getNode(source);
        Node d = getNode(destination);
        s.adjacent.add(d);
    }

    public boolean hasPathToDFS(int source, int destination) {
        Node s = getNode(source);
        Node d = getNode(destination);
        HashSet<Integer> visited = new HashSet<>();
        return hasPathDFS(s, d, visited);
    }

    private boolean hasPathDFS(Node source, Node destination, HashSet<Integer> visited) {
        if(visited.contains(source.id)){
            return false;
        }
        visited.add(source.id);
        if(source == destination) {
            return true;
        }
        for (Node child: source.adjacent) {
            if (hasPathDFS(child, destination, visited)){
                return true;
            }
        }
        return false;
    }

    public boolean hasPathToBFS(int source, int destination) {
        Node s = getNode(source);
        Node d = getNode(destination);
        return hasPathBFS(s, d);
    }

    private boolean hasPathBFS(Node source, Node destination) {
        LinkedList<Node> nextToVisit = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();

        nextToVisit.add(source);
        while (!nextToVisit.isEmpty()) {
            Node node = nextToVisit.remove();
            if(source == destination){
                return true;
            }

            if(visited.contains(node.id)){
                continue;
            }
            visited.add(node.id);

            for (Node a : source.adjacent) {
                nextToVisit.add(a);
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }

}
