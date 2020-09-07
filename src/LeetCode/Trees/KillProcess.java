package LeetCode.Trees;

import java.util.*;

public class KillProcess {
  public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill){
    Map<Integer, List<Integer>> map = new HashMap<>();
    for(int i = 0; i < ppid.size(); i++){
      if(!map.containsKey(ppid.get(i)))
        map.put(ppid.get(i), new ArrayList<>());
      map.get(ppid.get(i)).add(pid.get(i));
    }

    List<Integer> res = new ArrayList<>();
    Queue<Integer> q = new LinkedList<>();

    q.add(kill);
    while (!q.isEmpty()){
      int val = q.poll();
      res.add(val);
      if(map.containsKey(val)){
        for(Integer i : map.get(val)){
          q.add(i);
        }
      }
    }
    return res;
  }

  public static void main(String[] args){
    KillProcess k = new KillProcess();
    List<Integer> pid = new ArrayList<>(Arrays.asList(1,3,10,5));
    List<Integer> ppid = new ArrayList<>(Arrays.asList(3,0,5,3));
    List<Integer> res = k.killProcess(pid, ppid, 5);
  }
}
