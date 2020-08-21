package LeetCode.Backtracking;

public class TwentyFourGame {

  public boolean judgePoint24(int[] nums){
    double[] a = new double[]{nums[0], nums[1], nums[2], nums[3]};
    return helper(a);
  }

  public boolean helper(double[] a){
    if(a.length == 1) return Math.abs(a[0]-24) < 0.001;

    for(int i = 0; i <  a.length; i++){
      for(int j = i+1; j < a.length; j++){
        double[] b = new double[a.length-1];
        for(int k = 0, index = 0; k < a.length; k++){
          if(k != i && k != j)
            b[index++] = a[k];
        }
        for(double d : compute(a[i], a[j])){
          b[b.length-1] = d;
          if(helper(b)) return true;
        }
      }
    }
    return false;
  }

  public double[] compute(double x, double y){
    return new double[]{x-y, y-x, x+y, x*y, x/y, y/x};
  }

  public static void main(String[] args){
    int[] nums = {4,1,8,7};
    TwentyFourGame t = new TwentyFourGame();
    System.out.print(t.judgePoint24(nums));
  }
}
