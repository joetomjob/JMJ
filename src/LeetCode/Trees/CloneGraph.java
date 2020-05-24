package LeetCode.Trees;

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;

    Node(int val) {
        this.val = val;
        this.neighbors = new LinkedList<>();
    }

    Node(int val, List<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}

public class CloneGraph {

    // DFS
    Map<Node, Node> visited = new HashMap<>();
    public Node deepCopy(Node node) {
        if(node == null) {
            return node;
        }

        if(visited.containsKey(node)) {
            return visited.get(node);
        }

        Node clone_Node = new Node(node.val, new ArrayList<>());
        visited.put(node, clone_Node);

        for (Node n: node.neighbors) {
            clone_Node.neighbors.add(deepCopy(n));
        }

        return clone_Node;
    }

    // BFS
    Map<Node, Node> visitedBFS = new HashMap<>();
    public Node deepCopyBFS(Node node) {
        if(node == null) {
            return node;
        }

        visitedBFS.put(node, new Node(node.val, new ArrayList<>()));

        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()){
            Node n = q.poll();

            for (Node nd: n.neighbors) {
                if(!visitedBFS.containsKey(nd)) {
                    visitedBFS.put(nd, new Node(nd.val, new ArrayList<>()));
                    q.add(nd);
                }
                visitedBFS.get(n).neighbors.add(visitedBFS.get(nd));
            }
        }
        return visitedBFS.get(node);
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);

        a.neighbors.add(b);
        a.neighbors.add(d);

        b.neighbors.add(a);
        b.neighbors.add(c);

        c.neighbors.add(d);
        c.neighbors.add(b);

        d.neighbors.add(a);
        d.neighbors.add(c);

        CloneGraph cg = new CloneGraph();
        Node copydfs = cg.deepCopy(a);
        Node copybfs = cg.deepCopyBFS(a);

        System.out.println(copydfs.val);
        System.out.println(copybfs.val);
    }
}
