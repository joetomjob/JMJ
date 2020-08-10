package LeetCode.Trees;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpenTheLock {
  public int openLock(String[] deadends, String target){
    int[][] dp = {{1,0,0,0}, {0,1,0,0}, {0,0,1,0}, {0,0,0,1},
                  {-1,0,0,0}, {0,-1,0,0}, {0,0,-1,0}, {0,0,0,-1}};
    int level = 0;
    Set<String> visited = new HashSet<>();
    for(String s : deadends) visited.add(s);

    Queue<String> q = new LinkedList<>();
    q.add("0000");
    while(!q.isEmpty()){
     int sz = q.size();
     for(int i = 0; i < sz; i++){
       String s = q.poll();
       if(visited.contains(s))
         continue;
       if(s.equals(target))
         return level;
       visited.add(s);
       for(int j = 0; j < dp.length; j++){
         int[] num = {s.charAt(0)-'0', s.charAt(1)-'0', s.charAt(2)-'0', s.charAt(3)-'0'};
         for(int k = 0; k < 4; k++){
           num[k] += dp[j][k];
           num[k] = num[k] > 9 ? 0 : num[k];
           num[k] = num[k] < 0 ? 9 : num[k];
           String numS = ""+num[0]+num[1]+num[2]+num[3];
           if(!visited.contains(numS))
             q.add(numS);
         }
       }
     }
    level++;
    }
    return -1;
  }

  public static void main(String[] args){
    OpenTheLock o = new OpenTheLock();
    String[] deadends = {"0201","0101","0102","1212","2002"};
    String target = "0202";
    System.out.print(o.openLock(deadends, target));
  }
}
