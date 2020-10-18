package LeetCode.BloombergPractice;

import java.lang.reflect.Array;
import java.util.*;

public class VerticalOrder {
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
  List<int[]> list = new ArrayList<>();
  public List<List<Integer>> verticalTraversal(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    backTrack(root, 0, 0);
    Collections.sort(list, new Comparator<int[]>() {
      @Override
      public int compare(int[] a, int[] b){
        if(a[1] == b[1] && a[2] == b[2]) return a[0]-b[0];
        if(a[2] == b[2]) return a[1] - b[1];
        else return a[2] - b[2];
      }
    });

    LinkedHashMap<Integer, List<Integer>> map = new LinkedHashMap<>();
    for(int[] p : list){
      if(map.containsKey(p[2])) map.get(p[2]).add(p[0]);
      else map.put(p[2], new ArrayList<>(Arrays.asList(p[0])));
    }

    return new ArrayList<>(map.values());
  }

  public void backTrack(TreeNode node, int row, int col){
    if(node == null) return;
    backTrack(node.left, row+1, col-1);
    list.add(new int[]{node.val, row, col});
    backTrack(node.right, row+1, col+1);
  }

  public static void main(String[] args){}
}
