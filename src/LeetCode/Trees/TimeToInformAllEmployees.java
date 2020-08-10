package LeetCode.Trees;

import java.util.*;
class NodeTime{
  int val;
  int w;
  NodeTime(int v, int w){
    this.val = v;
    this.w = w;
  }
}
public class TimeToInformAllEmployees {
  public int numOfMinutes(int n, int headID, int[] manager, int[] informTime){
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    for(int i = 0; i< n; i++){
      if(!map.containsKey(manager[i]))
        map.put(manager[i], new ArrayList<>());
      map.get(manager[i]).add(i);
    }

    Queue<NodeTime> q = new LinkedList<>();
    q.add(new NodeTime(headID, informTime[headID]));
    int max = 0;
    while (!q.isEmpty()){
      NodeTime v = q.poll();
      max = Math.max(max, v.w);
      if(map.containsKey(v.val)){
        for(Integer i : map.get(v.val)) {
          q.add(new NodeTime(i, v.w + informTime[i]));
        }
      }
    }
    return max;
  }

  public static void main(String[] args){
    TimeToInformAllEmployees t = new TimeToInformAllEmployees();
    int n = 15;
    int headID = 0;
    int[] manager = {-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6};
    int[] informTime = {1,1,1,1,1,1,1,0,0,0,0,0,0,0,0};
    System.out.print(t.numOfMinutes(n, headID, manager, informTime));
  }
}
