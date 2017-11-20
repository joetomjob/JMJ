package IB;

/**
 * Created by joetomjob on 4/20/17.
 */
public class pathsum {
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

        pathsum p = new pathsum();
        boolean x = p.hspathsum(a,39);
        System.out.println(x);
    }
    public boolean hspathsum(TreeNode a,int sum){
        if(a==null){
            return false;
        }
        if(a.left == null && a.right == null && a.val - sum == 0){
            return true;
        }
        return hspathsum(a.left,sum-a.val) || hspathsum(a.right,sum-a.val);
    }
}
