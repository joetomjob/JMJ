package testing2;

/**
 * Created by joetomjob on 3/21/20.
 */
public class BST {
    TreeNode root;

    public void traverse() {
        inOrder(root);
        System.out.print('\n');
    }

    public void inOrder(TreeNode node) {
        if(node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.data);
        System.out.print('\t');
        inOrder(node.right);
    }

    public void insert(TreeNode a) {
        if(root == null) {
            root = a;
        } else {
            insertFrom(root, a);
        }
    }

    public void insertFrom(TreeNode root, TreeNode a) {
        if(a.data < root.data) {
            if(root.left == null) {
                root.left = a;
            } else {
                insertFrom(root.left, a);
            }
        } else {
            if(root.right == null) {
                root.right = a;
            } else {
                insertFrom(root.right, a);
            }
        }
    }

    public int height(){
        return heightOfTree(root);
    }

    public int heightOfTree(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int l = heightOfTree(node.left);
        int r = heightOfTree(node.right);

        return Math.max(l, r) + 1;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(26);
        TreeNode b = new TreeNode(33);
        TreeNode c = new TreeNode(45);
        TreeNode d = new TreeNode(59);
        TreeNode e = new TreeNode(61);
        TreeNode f = new TreeNode(57);
        TreeNode g = new TreeNode(18);
        TreeNode h = new TreeNode(99);
        TreeNode i = new TreeNode(10);
        TreeNode j = new TreeNode(12);
        TreeNode k = new TreeNode(63);

        BST bst = new BST();
        bst.insert(a);
        bst.insert(b);
        bst.insert(c);
        bst.insert(d);
        bst.insert(e);
        bst.insert(f);
        bst.insert(g);
        bst.insert(h);
        bst.insert(i);
        bst.insert(j);
        bst.insert(k);

        bst.traverse();

        System.out.println(bst.height());
    }

}

