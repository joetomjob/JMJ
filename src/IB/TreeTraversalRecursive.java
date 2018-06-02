package IB;

import java.util.ArrayList;

/**
 * Created by joetomjob on 3/8/18.
 */
public class TreeTraversalRecursive {

    public void inorderTraversal1(TreeNode a, ArrayList<Integer> res){
        if(a==null) {
            return;
        }
        inorderTraversal1(a.left,res);
        res.add(a.val);
        inorderTraversal1(a.right,res);
    }

    public void preorderTraversal1(TreeNode a, ArrayList<Integer> res){
        if(a==null) {
            return;
        }
        res.add(a.val);
        preorderTraversal1(a.left,res);
        preorderTraversal1(a.right,res);
    }

    public void postorderTraversal1(TreeNode a, ArrayList<Integer> res){
        if(a==null) {
            return;
        }
        postorderTraversal1(a.left,res);
        postorderTraversal1(a.right,res);
        res.add(a.val);
    }

    public ArrayList<Integer> inorderTraversal(TreeNode a){
        ArrayList<Integer> res = new ArrayList<>();
        inorderTraversal1(a,res);
        return res;
    }

    public ArrayList<Integer> preorderTraversal(TreeNode a){
        ArrayList<Integer> res = new ArrayList<>();
        preorderTraversal1(a,res);
        return res;
    }

    public ArrayList<Integer> postorderTraversal(TreeNode a){
        ArrayList<Integer> res = new ArrayList<>();
        postorderTraversal1(a,res);
        return res;
    }


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
        TreeTraversalRecursive in = new TreeTraversalRecursive();
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
}
