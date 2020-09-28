package LeetCode.ArraysAndStrings;

public class MinTimeAllPoints {
  public int minTimeToVisitAllPoints(int[][] points){
    if(points == null || points.length == 0 || points.length == 1)
      return 0;

    int res = 0;
    for(int i = 1; i < points.length; i++){
      res += Math.max(Math.abs(points[i][0] - points[i-1][0]), Math.abs(points[i][1] - points[i-1][1]));
    }
    return res;
  }
  public static void main(String[] args){
    int[][] points = {{1,1},{3,4},{-1,0}};
    int[][] points1 = {{3,2},{-2,2}};
    MinTimeAllPoints m = new MinTimeAllPoints();
    System.out.println(m.minTimeToVisitAllPoints(points));
    System.out.println(m.minTimeToVisitAllPoints(points1));
  }
}
