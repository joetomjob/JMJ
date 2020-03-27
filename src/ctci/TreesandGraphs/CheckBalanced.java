package ctci.TreesandGraphs;

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
public class CheckBalanced {

    // less efiicient
    public static int getHeight(TreeNode root) {
        if (root == null) return -0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    public static boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        int heightdiff = getHeight(root.left) - getHeight(root.right);
        if(Math.abs(heightdiff) > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }
    // more efficient

    public static int checkHeight(TreeNode root) {
        if(root == null) return 0;

        int leftHeight = checkHeight(root.left);
        if(leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; // pass error up

        int rightHeight = checkHeight(root.right);
        if(rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; //pass error up

        if(Math.abs(leftHeight - rightHeight) > 1){
            return Integer.MIN_VALUE; // Found error -> pass it back
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public static boolean isBalancedNew(TreeNode root) {
        return (checkHeight(root) != Integer.MIN_VALUE);
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

        System.out.println(isBalanced(a));
        System.out.println(isBalancedNew(a));
    }
}
