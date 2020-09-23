package LeetCode.Trees;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumKnightMoves {
  public int minKnightMoves(int x, int y){

    int[] rows = {1, 2, -1, -2, -2, -1, 1, 2};
    int[] cols = {2, 1, 2, 1, -1, -2, -2, -1};
    Queue<int[]> q = new LinkedList<>();
    HashSet<String> visited = new HashSet<>();
    q.add(new int[]{0,0,0});
    visited.add("0_0");
    while (!q.isEmpty()) {
      int[] val = q.poll();
      if(val[0] == x && val[1] == y) {
        return val[2];
      }
      for(int i = 0; i < 8; i++){
        if(!visited.contains(""+val[0]+rows[i] + "_"+val[1]+cols[i])) {
          q.add(new int[]{val[0] + rows[i], val[1] + cols[i], val[2] + 1});
          visited.add(""+val[0]+rows[i] + "_"+val[1]+cols[i]);
        }
      }
    }
    return -1;
  }
  public static void main(String[] args){
    MinimumKnightMoves m = new MinimumKnightMoves();
//    System.out.println(m.minKnightMoves(2,1));
//    System.out.println(m.minKnightMoves(5,5));
    System.out.println(m.minKnightMoves(2,112));
  }
}
