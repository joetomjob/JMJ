package LeetCode.Trees;

import java.util.*;

public class VerticalOrderBinaryTree {
  List<List<Integer>> res = new ArrayList<>();
  List<int[]> pos = new ArrayList<>();
  public List<List<Integer>> verticalTraversal(TreeNode root) {
    dfs(root, 0, 0);
    Collections.sort(pos, new Comparator<int[]>(){
      @Override
      public int compare(int[] a, int[] b){
        if(a[2] == b[2] && a[1] == b[1]) return a[0]-b[0];
        else if(a[2] == b[2]) return a[1] - b[1];
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
    pos.add(new int[]{root.val, row, col});
    dfs(root.right, row+1, col+1);
  }
}
