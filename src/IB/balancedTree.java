package IB;

/**
 * Created by joetomjob on 4/17/17.
 */

public class balancedTree {
    int balanced = 1;
    public static void main(String[] args) {
        TreeNode a = new TreeNode(9);
        TreeNode b = new TreeNode(7);
        TreeNode c = new TreeNode(11);
        TreeNode d = new TreeNode(6);
        TreeNode e = new TreeNode(8);
        TreeNode f = new TreeNode(10);
        TreeNode g = new TreeNode(12);

        a.left = b;
        b.right = e;
        b.left = d;
        a.right = c;
        c.left = f;
        c.right = g;

        balancedTree bal = new balancedTree();
        bal.isBalanced(a);
        //System.out.println(bal.isBalanced(a));

    }
    public int isBalanced(TreeNode root) {

        if(root==null){
            return 1;
        }
        ///////First Method
        balanced(root);

        //////second method

        if(height(root)==-1){
            return 0;
        }
        else{
            return 1;
        }


    }

    public int balanced(TreeNode a){
        if(a==null){
            return 0;
        }
        int lh = 1+balanced(a.left);
        int rh = 1+balanced(a.right);

        if(Math.abs(lh-rh) > 1){
            balanced = 0;
        }
        return Math.max(lh,rh);
    }

    public int height(TreeNode node){
        if(node==null){
            return 0;
        }
        int lH=height(node.left);
        if(lH==-1){
            return -1;
        }
        int rH=height(node.right);
        if(rH==-1){
            return -1;
        }
        if(lH-rH<-1 || lH-rH>1){
            return -1;
        }
        return Math.max(lH,rH)+1;
    }
}
