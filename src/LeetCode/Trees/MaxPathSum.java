package LeetCode.Trees;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}
public class MaxPathSum {
    int max_sum = Integer.MIN_VALUE;

    public int maxSum(TreeNode root) {
        max_gain(root);
        return max_sum;
    }

    public int max_gain(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left_sum = Math.max(max_gain(root.left),0);
        int right_sum = Math.max(max_gain(root.right),0);

        int price_newpath = root.val + left_sum + right_sum;

        max_sum = Math.max(price_newpath, max_sum);

        return root.val + Math.max(left_sum, right_sum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        MaxPathSum m = new MaxPathSum();
        System.out.println(m.maxSum(root));
    }
}
