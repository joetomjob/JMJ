package LeetCode.LeetCode_Easy;

/**
 * Created by joetomjob on 6/23/18.
 */
/*
            11
           /  \
          5    20
         / \    \
        3   10    30
*/
public class BinarySearchTree {
    public static TreeNode a;

    public void traverse(TreeNode node){
        if (node == null)
            return;
        traverse(node.left);
        System.out.print(node.val);
        System.out.print('\t');
        traverse(node.right);
    }

    public void insert(TreeNode node){
        if(a == null)
            a = node;
        else {
            insertfrom(a, node);
        }
    }

    public void insertfrom(TreeNode root, TreeNode node){
        if(node.val<root.val) {
            if (root.left == null)
                root.left = node;
            else
                insertfrom(root.left, node);
        } else {
            if (root.right == null)
                root.right = node;
            else
                insertfrom(root.right, node);
        }
    }

    public int height(TreeNode root){
        if(root == null)
            return 0;
        int l = height(root.left);
        int r = height(root.right);
        return Math.max(l,r)+1;
    }

    public static void main(String[] args) {
        a = new TreeNode(11);
        TreeNode b = new TreeNode(5);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(10);
        TreeNode e = new TreeNode(20);
        TreeNode f = new TreeNode(30);
        TreeNode g = new TreeNode(9);
        TreeNode h = new TreeNode(18);
        TreeNode i = new TreeNode(15);

        a.left = b;
        b.left = c;
        b.right = d;
        a.right = e;
        e.right = f;

        BinarySearchTree z = new BinarySearchTree();
        z.traverse(a);
        System.out.println();
        System.out.println(z.height(a));

        z.insert(g);
        z.insert(h);
        z.insert(i);
        z.traverse(a);
        System.out.println();
        System.out.println(z.height(a));
    }
}
