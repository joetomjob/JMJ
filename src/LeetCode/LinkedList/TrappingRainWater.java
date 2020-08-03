package LeetCode.LinkedList;

public class TrappingRainWater {
  // O(n) time and O(n) space
  public int trap(int[] height){
    int[] maxl = new int[height.length];
    int[] maxr = new int[height.length];
    int max = 0, res = 0;

    for (int i = 0; i < height.length; i++) {
      max = Math.max(max, height[i]);
      maxr[i] = max;
    }
    max = 0;
    for(int i = height.length - 1; i >= 0; i--){
      max = Math.max(max, height[i]);
      maxl[i] = max;
    }
    for(int i = 0; i < height.length; i++){
      res += Math.min(maxl[i], maxr[i]) - height[i];
    }
    return res;
  }

  // O(n) time and O(1) space
  public int trap2(int[] height){
    if(height.length < 3)
      return 0;
    int i = 0, j = height.length-1;
    int lm = height[i], rm = height[j];
    int tot = 0;
    while (i <= j){
      lm = Math.max(lm, height[i]);
      rm = Math.max(rm, height[j]);

      if(lm <= rm){
        tot += lm - height[i];
        i++;
      } else {
        tot += rm - height[j];
        j--;
      }
    }
    return tot;
  }

  public static void main(String[] args) {
    int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
//    int[] height = {4,2,3};
//    int[] height = {2,0,2};
    TrappingRainWater t = new TrappingRainWater();
//    System.out.println(t.trap(height));
    System.out.println(t.trap2(height));
  }
}
