package LeetCode.Trees;

import java.util.HashMap;

public class BinaryFromPreAndInorder {
  int[] preorder;
  int[] inorder;
  HashMap<Integer, Integer> tree_map = new HashMap<>();
  int pre_index = 0;

  public TreeNode buildTreeHelper(int left, int right) {
    if(left == right) {
      return null;
    }

    int node_val = this.preorder[pre_index];
    TreeNode treeNode = new TreeNode(node_val);

    int index = this.tree_map.get(node_val);

    pre_index++;
    treeNode.left = buildTreeHelper(left, index);
    treeNode.right = buildTreeHelper(index+1, right);

    return treeNode;
  }

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    this.preorder = preorder;
    this.inorder = inorder;
    for (int i = 0; i < inorder.length; i++) {
      this.tree_map.put(inorder[i], i);
    }
    return buildTreeHelper(0, preorder.length);
  }

  public static void main(String[] args) {
    int[] pre = {3,9,20,15,7};
    int[] in = {9,3,15,20,7};

    BinaryFromPreAndInorder b = new BinaryFromPreAndInorder();
    TreeNode root = b.buildTree(pre, in);
  }
}
