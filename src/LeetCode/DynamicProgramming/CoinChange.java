package LeetCode.DynamicProgramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CoinChange {
  public int coinChange(int[] coins, int amount){
    int[] dp = new int[amount+1];

    // fill the array with invalid value
    Arrays.fill(dp, amount+1);

    dp[0] = 0;
    // the index in the array dp represents the amount and the value in the index represents the minimum
    // number of coins required to reach the amount.

    for(int i = 0; i <= amount; i++){

      // sub problem: if adding coin exceeds the amount (here i is the amount), do not add that coin, else, add that coin.
      // after adding the coin, to find the min number of coins required to reach the amount => 1+dp[i-j]
      // take an example where coins are [2] and the sum is 3. The sum 3 cannot be formed by the coin 2. we can go through
      // our dp array. dp[0] is 0. dp[1] will remain amount+1 since the no coin add up to 1. The dp[2] will be 1.
      // dp[3] = 1+dp[3-2] = 1+ amount+1. at the end we return -1 if the value of d[amount] > amount;
      for(int j = 0; j < coins.length; j++){
        if(coins[j] <= i){
          dp[i] = Math.min(dp[i], 1+dp[i-coins[j]]);
        }
      }
    }

    return dp[amount] > amount ? -1 : dp[amount];
  }

  public static void main(String[] args){
//    int[] coins = {1,2,5};
//    int sum = 11;
    int[] coins = {2};
    int sum = 4;
    CoinChange c = new CoinChange();
    System.out.print(c.coinChange(coins, sum));
  }
}
