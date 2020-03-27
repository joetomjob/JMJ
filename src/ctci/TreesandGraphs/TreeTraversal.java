package ctci.TreesandGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by joetomjob on 8/6/19.
                a(1)
               /   \
              b(2)  c(3)
            /    \   / \
        d(4)  e(5) f(6) g(7)
                       /   \
                     h(8) i(9)
                     /
                   j(10)
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val){
        this.val = val;
    }
}
public class TreeTraversal {


    public void inorder(TreeNode root){
        if(root != null) {
            inorder(root.left);
            System.out.print(root.val);
            System.out.print('\t');
            inorder(root.right);
        }
    }

    public void preorder(TreeNode root){
        if(root != null) {
            System.out.print(root.val);
            System.out.print('\t');
            preorder(root.left);
            preorder(root.right);
        }
    }

    public void postorder(TreeNode root){
        if(root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.val);
            System.out.print('\t');
        }
    }

    public void inorderIterative(TreeNode root){
        Stack<TreeNode> s = new Stack<>();
        TreeNode c = root;
        while (!s.isEmpty() || c != null) {
            while (c != null) {
                s.push(c);
                c = c.left;
            }
            c = s.pop();
            System.out.print(c.val);
            System.out.print('\t');
            c = c.right;
        }
    }

    public void preorderIterative(TreeNode root){
        Stack<TreeNode> s = new Stack<>();
        TreeNode c = root;
        while (!s.isEmpty() || c != null) {
            while (c != null) {
                s.push(c);
                System.out.print(c.val);
                System.out.print('\t');
                c = c.left;
            }
            c = s.pop();
            c = c.right;
        }
    }

    public void postorderIterative(TreeNode root){
        LinkedList<Integer> res = new LinkedList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode c = root;
        while (!s.isEmpty() || c != null) {
            while (c != null) {
                res.addFirst(c.val);
                s.push(c);
                c = c.right;
            }
            c = s.pop();
            c = c.left;
        }

        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i));
            System.out.print('\t');
        }
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(8);
        TreeNode i = new TreeNode(9);
        TreeNode j = new TreeNode(10);


        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        g.left = h;
        g.right = i;
        h.left = j;

        TreeTraversal t = new TreeTraversal();
        System.out.println("InOrder");
        t.inorder(a);
        System.out.println();
        System.out.println("PreOrder");
        t.preorder(a);
        System.out.println();
        System.out.println("PostOrder");
        t.postorder(a);
        System.out.println();
        System.out.println("InOrder");
        t.inorderIterative(a);
        System.out.println();
        System.out.println("PreOrder");
        t.preorderIterative(a);
        System.out.println();
        System.out.println("PostOrder");
        t.postorderIterative(a);
    }

}

