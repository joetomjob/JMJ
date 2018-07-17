package LeetCode.LeetCode_Easy;

/*              10
               /  \
              5   20
             / \    \
            3   7   30
*/

/**
 * Created by joetomjob on 6/22/18.
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

public class TreeTraversal {
    public void inorder(TreeNode node){
        if(node == null)
            return;
        inorder(node.left);
        System.out.println(node.val);
        inorder(node.right);
    }

    public void preorder(TreeNode node){
        if(node == null)
            return;
        System.out.println(node.val);
        preorder(node.left);
        preorder(node.right);
    }

    public void postorder(TreeNode node){
        if(node == null)
            return;
        postorder(node.left);
        postorder(node.right);
        System.out.println(node.val);

    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(10);
        TreeNode b = new TreeNode(5);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(7);
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

        TreeTraversal t = new TreeTraversal();
        System.out.println("Inorder");
        t.inorder(a);
        System.out.println("Preorder");
        t.preorder(a);
        System.out.println("Postorder");
        t.postorder(a);

    }
}
