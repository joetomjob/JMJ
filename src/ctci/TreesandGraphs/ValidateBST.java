package ctci.TreesandGraphs;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by joetomjob on 8/6/19.
                   a(4)
                  /   \
               b(2)  c(8)
             /    \    / \
         d(1)  e(3) f(7) g(9)
                     /   \
                   h(6)  i(10)
                   /
                j(5)
 */
public class ValidateBST {

    //least efficient
    public static void validateBSTOne(TreeNode root, ArrayList<Integer> list) {
        if (root != null) {
            validateBSTOne(root.left, list);
            list.add(root.val);
            validateBSTOne(root.right, list);
        }
    }

    public static boolean isValidBSTOne(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        validateBSTOne(root, list);
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i) < list.get(i-1)) {
                return false;
            }
        }
        return true;
    }

    // least efficient but less space
    static Integer last_one = null;
    public static boolean isValidBSTTwo(TreeNode root) {
        if(root == null) return true;

        if(!isValidBSTTwo(root.left)) return false;

        if(last_one != null && root.val <= last_one) {
            return false;
        }
        last_one = root.val;
        if(!isValidBSTTwo(root.right)) return false;

        return true;
    }

    //most efficient - O(n) time and O(log(n)) space

    public static boolean isValidBSTThree(TreeNode root, Integer min, Integer max) {
        if(root == null) return true;

        if((min != null && root.val <= min) || (max != null && root.val > max)){
            return false;
        }

        if(!isValidBSTThree(root.left, min, root.val) || !isValidBSTThree(root, root.val, max)){
            return false;
        }

        return true;
    }



    public static void main(String[] args) {
        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(8);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(3);
        TreeNode f = new TreeNode(7);
        TreeNode g = new TreeNode(9);
        TreeNode h = new TreeNode(6);
        TreeNode i = new TreeNode(10);
        TreeNode j = new TreeNode(5);


        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        f.left = h;
        g.right = i;
        h.left = j;

        System.out.println(isValidBSTOne(a));
        System.out.println(isValidBSTTwo(a));
        System.out.println(isValidBSTThree(a, null, null));
    }
}
