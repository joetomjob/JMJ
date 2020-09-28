package LeetCode.Trees;

public class LCADeepestLeaves {
  class Pair{
    TreeNode node;
    int h;

    Pair(){}
    Pair(TreeNode n, int h){
      node = n;
      this.h = h;
    }
  }

  public TreeNode lcaDeepestLeaves(TreeNode root){
    Pair res = backTrack(root, 0);
    return res.node;
  }

  public Pair backTrack(TreeNode root, int h){
    if(root == null) return new Pair(null, h);

    Pair l = backTrack(root.left, h+1);
    Pair r = backTrack(root.right, h+1);

    if(l.h == r.h) return new Pair(root, l.h);
    else if(l.h > r.h) return new Pair(l.node, l.h);
    else return new Pair(r.node, r.h);
  }
  public static void main(String[] args){
    TreeNode n1 = new TreeNode(3);
    TreeNode n2 = new TreeNode(5);
    TreeNode n3 = new TreeNode(1);
    TreeNode n4 = new TreeNode(6);
    TreeNode n5 = new TreeNode(2);
    TreeNode n6 = new TreeNode(0);
    TreeNode n7 = new TreeNode(8);
    TreeNode n8 = new TreeNode(7);
    TreeNode n9 = new TreeNode(4);

    n1.left = n2;
    n1.right = n3;

    n2. left = n4;
    n2.right = n5;

    n3.left = n6;
    n3.right = n7;

    n5.left = n8;
    n5.right = n9;

    LCADeepestLeaves l = new LCADeepestLeaves();
    System.out.println(l.lcaDeepestLeaves(n1).val);
  }
}
