package LeetCode.Trees;

import java.util.*;

public class SkylineProblem{
  class BPoint implements Comparable<BPoint> {
    int x;
    boolean isStart;
    int height;

    BPoint(int x, boolean isStart, int height){
      this.x = x;
      this.isStart = isStart;
      this.height = height;
    }

    public int compareTo(BPoint b){
      if(this.x != b.x)
        return this.x - b.x;
      else {
        // If both are start: higher building should come first. If both are end: lower building should come first. if one start and
        // other end: the one with higher the start should come first
        return (this.isStart ? -this.height : this.height) - (b.isStart ? -b.height : b.height);
      }
    }
  }
  public List<List<Integer>> getSkyline(int[][] buildings){
    List<BPoint> bPoints = new ArrayList<>();
    for(int[] building : buildings){
      bPoints.add(new BPoint(building[0], true, building[2]));
      bPoints.add(new BPoint(building[1], false, building[2]));
    }
    Collections.sort(bPoints);

    List<List<Integer>> result = new ArrayList<>();
    PriorityQueue<Integer> q = new PriorityQueue<>((a,b)-> b-a); // key is the height and value is the number of time the height occurs in the array
    q.add(0);
    int prevMaxHeight = 0;
    for(BPoint b : bPoints) {
      if(b.isStart) q.add(b.height);
      else q.remove(b.height);

      int curMaxH = q.peek();
      if(q.peek() != prevMaxHeight){
        result.add(new ArrayList<>(Arrays.asList(b.x, curMaxH)));
        prevMaxHeight = curMaxH;
      }
    }
    return result;
  }

  public static void main(String[] args){
    int[][] inp = {{1,3,4}, {3,4,4}, {2,6,2}, {8,11,4}, {7,9,3}, {10,11,2}};
    SkylineProblem s = new SkylineProblem();
    List<List<Integer>> res  = s.getSkyline(inp);
    for(List<Integer> l : res){
      for(Integer i : l){
        System.out.print(i);
        System.out.print('\t');
      }
      System.out.print('\n');
    }
  }
}
