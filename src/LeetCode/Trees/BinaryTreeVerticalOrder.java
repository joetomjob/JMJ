package LeetCode.Trees;

import java.util.*;

public class BinaryTreeVerticalOrder {
  List<List<Integer>> res = new ArrayList<>();
  List<int[]> pos = new ArrayList<>();
  public List<List<Integer>> verticalOrder(TreeNode root){
    dfs(root, 0, 0);
    Collections.sort(pos, new Comparator<int[]>() {
      @Override
      public int compare(int[] a, int[] b){
        if(a[2] == b[2]) return a[1] - b[1];
        else return a[2] - b[2];
      }
    });

    LinkedHashMap<Integer, List<Integer>> map = new LinkedHashMap<>();
    for(int[] p : pos){
      if(!map.containsKey(p[2]))
        map.put(p[2], new ArrayList<>());
      map.get(p[2]).add(p[0]);
    }

    res = new ArrayList<>(map.values());
    return res;
  }

  public void dfs(TreeNode root, int row, int col){
    if(root == null) return;

    dfs(root.left, row+1, col-1);
    pos.add(new int[] {root.val, row, col});
    dfs(root.right, row+1, col+1);
  }
  public static void main(String[] args){
    TreeNode root = new TreeNode(2, new TreeNode(9, new TreeNode(4, new TreeNode(3), new TreeNode(11)), null), new TreeNode(8, new TreeNode(1, null, new TreeNode(5)), new TreeNode(7)));
    BinaryTreeVerticalOrder b = new BinaryTreeVerticalOrder();
    b.verticalOrder(root);
  }
}
