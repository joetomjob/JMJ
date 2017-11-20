package IB;

import java.util.ArrayList;

/**
 * Created by joetomjob on 4/21/17.
 */
public class RoottoLeafPathsWithSum {
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

        RoottoLeafPathsWithSum bal = new RoottoLeafPathsWithSum();
        bal.pathSum(a,22);
        System.out.println("1");
    }
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> curresult = new ArrayList<Integer>();
        PathSum(root,sum,curresult,result);
        return result;
    }

    public void PathSum(TreeNode root, int sum, ArrayList<Integer> curresult, ArrayList<ArrayList<Integer>> result){
        if(root == null)
            return;
        curresult.add(root.val);
        if(root.left == null && root.right == null && root.val == sum){
            result.add(new ArrayList<>(curresult));
            curresult.remove(curresult.size()-1);
            return;
        }
        else{
            PathSum(root.left, sum-root.val, curresult, result);
            PathSum(root.right, sum-root.val, curresult, result);
        }
        curresult.remove(curresult.size()-1);
    }
}
