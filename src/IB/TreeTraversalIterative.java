package IB;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by joetomjob on 4/15/17.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
public class TreeTraversalIterative {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(9);
        TreeNode b = new TreeNode(8);
        TreeNode c = new TreeNode(7);
        TreeNode d = new TreeNode(6);
        TreeNode e = new TreeNode(10);
        TreeNode f = new TreeNode(11);
        TreeNode g = new TreeNode(12);

        a.left = b;
        b.right = c;
        b.left = d;
        a.right = f;
        f.left = e;
        f.right = g;
        TreeTraversalIterative in = new TreeTraversalIterative();
        ArrayList<Integer> res = new ArrayList<>();
        res = in.inorderTraversal(a);
        for (Integer x:res) {
            System.out.print(x);
            System.out.print('\t');
        }
        System.out.print('\n');
        res = in.preorderTraversal(a);
        for (Integer x:res) {
            System.out.print(x);
            System.out.print('\t');
        }
        System.out.print('\n');
        res = in.postorderTraversal(a);
        for (Integer x:res) {
            System.out.print(x);
            System.out.print('\t');
        }
//        node a = new node(9);
//        node a = new node(9);

    }

    public ArrayList<Integer> inorderTraversal(TreeNode a) {
        ArrayList<Integer> result = new ArrayList<>();
        if (a == null) return result;

        Stack<TreeNode> k = new Stack<>();
        TreeNode c;
        c = a;
        while(!k.isEmpty() || c != null){
            while(c != null){
                k.push(c);
                c = c.left;
            }
            c = k.pop();
            result.add(c.val);
            c = c.right;
        }
        return result;
    }

    public ArrayList<Integer> preorderTraversal(TreeNode a) {
        ArrayList<Integer> result = new ArrayList<>();
        if (a == null) return result;

        Stack<TreeNode> k = new Stack<>();
        TreeNode c;
        c = a;
        while(!k.isEmpty() || c != null){
            while(c != null){
                k.push(c);
                result.add(c.val);
                c = c.left;
            }
            c = k.pop();
//            result.add(c.val);
            c = c.right;
        }
        return result;
    }

    public ArrayList<Integer> postorderTraversal(TreeNode a) {
        LinkedList<Integer> result = new LinkedList<Integer>();
        ArrayList<Integer> res = new ArrayList<>(result);
        if (a == null) return res;

        Stack<TreeNode> k = new Stack<>();
        TreeNode c;
        c = a;
        while(!k.isEmpty() || c != null){
            while(c != null){
                k.push(c);
                result.addFirst(c.val);
                c = c.right;
            }

            c = k.pop();
            c = c.left;
        }
        res = new ArrayList<>(result);
        return res;
    }
}
