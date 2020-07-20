package LeetCode.ArraysAndStrings;

public class ContainerWithMostWater {
  public int maxArea(int[] height) {
    int f = 0, l = height.length -1, maxarea = 0;
    while (f < l) {
      maxarea = Math.max(maxarea, (l - f) * Math.min(height[f], height[l]));
      if(height[f] <= height[l]) f++;
      else l--;
    }
    return maxarea;
  }

  public static void main(String[] args) {
    int[] a = {1,8,6,2,5,4,8,3,7};
    ContainerWithMostWater c = new ContainerWithMostWater();
    System.out.println(c.maxArea(a));
  }
}
