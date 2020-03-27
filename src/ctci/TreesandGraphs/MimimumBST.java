package ctci.TreesandGraphs;

/**
 * Created by joetomjob on 8/20/19.
 */
public class MimimumBST {
    static TreeNode CreateMinBST(int[] array) {
        return CreateMinBST(array, 0, array.length-1);
    }

    static TreeNode CreateMinBST(int[] array, int start, int end) {
        if(end < start) {
            return null;
        }
        int mid = (end + start)/2;
        TreeNode n = new TreeNode(array[mid]);
        n.left = CreateMinBST(array, start, mid -1);
        n.right = CreateMinBST(array, mid+1, end);
        return n;
    }
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8};
        TreeNode n = CreateMinBST(a);
        System.out.println(n.val);
    }
}
