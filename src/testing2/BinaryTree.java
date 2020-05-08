package testing2;

import java.util.*;
import java.util.Stack;

/**
 * Created by joetomjob on 3/21/20.
 */
/*
        26
      /    \
    33      45
    / \     /\
  59   61  57 18
  /\   / \
99 10 12  63

*/

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(){}

    TreeNode(int a){
        this.data = a;
    }
}

public class BinaryTree {
    TreeNode root;

    public void traverse(){
        System.out.print("Inorder Traversal \n");
        inOrder(this.root);

        System.out.print("\nPreorder Traversal \n");
        preOrder(this.root);

        System.out.print("\nPostorder Traversal \n");
        postOrder(this.root);

        System.out.print("\nInorder Traversal \n");
        inOrderIterative(root);

        System.out.print("\nPreorder Traversal \n");
        preOrderIterative(root);

        System.out.print("\nPostorder Traversal \n");
        postOrderIterative(root);

        System.out.print("\n");
    }

    public void inOrder(TreeNode node) {
        if(node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.data);
        System.out.print('\t');
        inOrder(node.right);
    }

    public void preOrder(TreeNode node) {
        if(node == null) {
            return;
        }

        System.out.print(node.data);
        System.out.print('\t');
        preOrder(node.left);
        preOrder(node.right);
    }

    public void postOrder(TreeNode node) {
        if(node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data);
        System.out.print('\t');
    }

    public void inOrderIterative(TreeNode node) {
        TreeNode n = root;
        Stack<TreeNode> s = new Stack<>();

        while (!s.isEmpty() || n != null) {
            while(n != null){
                s.push(n);
                n = n.left;
            }
            n = s.pop();
            System.out.print(n.data);
            System.out.print('\t');
            n = n.right;
        }
    }

    public void preOrderIterative(TreeNode node) {
        TreeNode n = root;
        Stack<TreeNode> s = new Stack<>();

        while (!s.isEmpty() || n != null) {
            while(n != null){
                s.push(n);
                System.out.print(n.data);
                System.out.print('\t');
                n = n.left;
            }
            n = s.pop();
            n = n.right;
        }
    }

    public void postOrderIterative(TreeNode node) {
        TreeNode n = root;
        LinkedList<Integer> l = new LinkedList<>();
        Stack<TreeNode> s = new Stack<>();

        while (!s.isEmpty() || n != null) {
            while(n != null){
                s.push(n);
                l.addFirst(n.data);
                n = n.right;
            }
            n = s.pop();
            n = n.left;
        }
        for (int i = 0; i < l.size(); i++) {
            System.out.print(l.get(i));
            System.out.print('\t');
        }

    }

    public int height() {
        return heightOfTree(root);
    }

    public int heightOfTree(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int l = heightOfTree(node.left);
        int r = heightOfTree(node.right);

        return Math.max(l,r) + 1;
    }



    public static void main(String[] args) {
        TreeNode a = new TreeNode(26);
        TreeNode b = new TreeNode(33);
        TreeNode c = new TreeNode(45);
        TreeNode d = new TreeNode(59);
        TreeNode e = new TreeNode(61);
        TreeNode f = new TreeNode(57);
        TreeNode g = new TreeNode(18);
        TreeNode h = new TreeNode(99);
        TreeNode i = new TreeNode(10);
        TreeNode j = new TreeNode(12);
        TreeNode k = new TreeNode(63);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        d.left = h;
        d.right = i;
        e.left = j;
        e.right = k;

        BinaryTree bt = new BinaryTree();
        bt.root = a;
        bt.traverse();
        System.out.println(bt.height());
    }
}
