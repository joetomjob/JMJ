package LeetCode.DynamicProgramming;

public class ClimbingStairs {
  public int climbingStairs(int n){
    if(n == 1) return 1;
    if(n == 2) return 2;

    int[] steps = new int[n];
    steps[0] = 1;
    steps[1] = 2;

    for(int i = 2; i < n; i++){
      steps[i] = steps[i-1] + steps[i-2];
    }

    return steps[n-1];
  }
  public static void main(String[] args){
    ClimbingStairs c = new ClimbingStairs();
    System.out.println(c.climbingStairs(1));
  }

}
