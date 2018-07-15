package LeetCode.LeetCode_Easy;
/*
            11
           /  \
          5    30
         /\    /\
        3 10  20 40
*/
/**
 * Created by joetomjob on 7/14/18.
 */
public class MinimalTree {

    public static void traverse(TreeNode node){
        if(node == null)
            return;
        traverse(node.left);
        System.out.print(node.val);
        System.out.print('\t');
        traverse(node.right);
    }

    public static void createMinimalBST(int[] arr){
        TreeNode n = _createMinimalBST(arr, 0, arr.length-1);
        traverse(n);
    }

    public static TreeNode _createMinimalBST(int[] arr, int start, int end){
        if(end < start)
            return null;
        int mid = (start+end)/2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = _createMinimalBST(arr, start, mid-1);
        node.right = _createMinimalBST(arr, mid+1, end);
        return node;
    }

    public static void main(String[] args) {

        int[] arr = {3,5,10,11,20,30};
        createMinimalBST(arr);
    }
}
