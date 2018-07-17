package LeetCode.LeetCode_Easy;

import apple.laf.JRSUIUtils;

/**
 * Created by joetomjob on 7/17/18.
 */
public class SymmetricTree {
    public boolean symmetricTree(TreeNode root){
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null)
            return true;
        if (t1 == null || t2 == null)
            return false;
        return (t1.val==t2.val && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left));
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(3);
        TreeNode g = new TreeNode(4);

        TreeNode h = new TreeNode(1);
        TreeNode i = new TreeNode(2);
        TreeNode j = new TreeNode(3);
        TreeNode k = new TreeNode(2);
        TreeNode l = new TreeNode(3);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = g;
        c.right = f;

        h.left = i;
        h.right = k;
        i.right = j;
        k.right = l;

        SymmetricTree s = new SymmetricTree();
        System.out.println(s.symmetricTree(a));
        System.out.println(s.symmetricTree(h));

    }
}
