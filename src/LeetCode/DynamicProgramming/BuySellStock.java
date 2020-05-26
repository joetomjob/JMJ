package LeetCode.DynamicProgramming;

public class BuySellStock {
  public int maxProfit(int[] prices) {
    int max_profit = 0;
    int min_val = Integer.MAX_VALUE;

    for(int i = 0; i < prices.length; i++) {
      if(prices[i] < min_val) {
        min_val = prices[i];
      }
      if(prices[i] - min_val > max_profit) {
        max_profit = prices[i] - min_val;
      }
    }
    return max_profit;
  }
  public static void main(String[] args) {
    BuySellStock b = new BuySellStock();
    int[] a = { 7,1,5,3,6,4 };
    System.out.println(b.maxProfit(a));
  }
}
