package LeetCode.ArraysAndStrings;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BrokenCalculator {
  public int brokenCalc(int X, int Y){
    if(X == Y) return 0;
    if(Y < X) return X - Y;
    return BFS(X, Y);
  }

  public int BFS(int start, int dest){
    Queue<int[]> q = new LinkedList<>();
    HashSet<Integer> visited = new HashSet<>();

    q.add(new int[] {start, 0});
    visited.add(start);
    while (!q.isEmpty()){
      int[] val = q.poll();

      if(val[0] == dest) return val[1];
      if(!visited.contains(val[0]*2)) { q.add(new int[] {val[0] * 2, val[1]+1}); }
      if(!visited.contains(val[0]-1)) { q.add(new int[] {val[0] - 1, val[1]+1}); };
    }

    return -1;
  }

  //work backward: advantage: if the number is not divisible by 2, don't consider it;
  public int BFSII(int start, int dest){
    Queue<int[]> q = new LinkedList<>();
    HashSet<Integer> visited = new HashSet<>();

    q.add(new int[] {dest, 0});
    visited.add(dest);
    while (!q.isEmpty()){
      int[] val = q.poll();

      if(val[0] == start) return val[1];

      // add to queue if the number is divisible by 2
      // and if the number/2 is not present in the visited set.
      if(val[0]%2 == 0 && !visited.contains(val[0]/2)) {
        q.add(new int[] {val[0]/2, val[1]+1} );
      }

      // add to queue only if the number - 1 is greater of equal to the start
      // and if the number/2 is not present in the visited set.
      if(val[0]+1 >= start && !visited.contains(val[0]+1)){
        q.add(new int[] {val[0]+1, val[1]+1} );
      }
    }

    return -1;
  }

  public int brokenCalcII(int X, int Y){
    if(X == Y) return 0;
    if(Y < X) return X - Y;
    int ans = 0;
    while (Y > X){
      ans++;
      if(Y%2==0) Y /= 2;
      else Y++;
    }
    return ans+X-Y;
  }

  public static void main(String[] args){
    BrokenCalculator b = new BrokenCalculator();
    System.out.println(b.brokenCalcII(2,3));
    System.out.println(b.brokenCalcII(5,8));
    System.out.println(b.brokenCalcII(3,10));
  }
}
