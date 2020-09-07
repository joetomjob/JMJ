package LeetCode.DynamicProgramming;

import java.util.HashMap;

public class NumRollsToTarget {
  // iterative
  int mod = 1000000007;
  public int numRollsToTarget(int d, int f, int target){
    int col = d*f;
    if(target > col || target < 1 || target < d) return 0;
    if(d==1) return target<=f ? 1:0;
    long[][] dp = new long[d][col+1];
    for(int i = 0; i < d; i++){
      for(int j = 0; j <= target; j++){
        if(i == 0)
          for(int k = 1; k <= f; k++) dp[i][k] = 1;
        else{
          dp[i][j] = 0;
          for(int k = j-1; k >=0 && k >= j-f; k--)
            dp[i][j] += dp[i-1][k];
          dp[i][j] = dp[i][j]%mod;
        }
      }
    }
    return (int)(dp[d-1][target]%mod);
  }

  // recursive solution
  HashMap<String, Integer> map = new HashMap<>();
  public int numRollsToTargetRec(int d, int f, int target){
    if(target > d*f || target < 1 || target < d) return 0;
    if(d==1) return target<=f ? 1:0;
    String key = ""+d+f+target;
    if(!map.containsKey(key)) {
      int sum = 0;
      for (int i = 1; i <= f; i++) {
        sum += numRollsToTargetRec(d - 1, f, target - i);
        sum = sum%mod;
      }
      map.put(key, sum);
    }
    return map.get(key);
  }

  public static void main(String[] args){
    NumRollsToTarget n = new NumRollsToTarget();
//    System.out.println(n.numRollsToTarget(30,30,500));
    System.out.println(n.numRollsToTargetRec(30,30,500));
  }
}
