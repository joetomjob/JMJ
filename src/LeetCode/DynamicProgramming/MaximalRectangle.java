package LeetCode.DynamicProgramming;

import java.util.Stack;

public class MaximalRectangle {
  public int maximumAreaHistogram(int[] heights){
    Stack<Integer> s = new Stack();
    int area = 0, max = 0, i = 0;
    for(i = 0; i < heights.length;){
      if (s.isEmpty() || heights[i] >= heights[s.peek()]){
        s.push(i);
        i++;
      } else {
        int ind = s.pop();
        if(s.isEmpty())
          area = heights[ind] * i;
        else
          area = heights[ind] * (i - s.peek() -1);
        max = Math.max(max, area);
      }
    }
    while(!s.isEmpty()){
      int ind = s.pop();
      if(s.isEmpty())
        area = heights[ind] * i;
      else
        area = heights[ind] * (i - s.peek() -1);
      max = Math.max(max, area);
    }
    return max;
  }
  public int maximalRectangle(char[][] s){
    if (s == null || s.length == 0 || s[0].length == 0) return 0;
    int m = s.length, n = s[0].length, max = 0;
    int[] temp = new int[n];
    for(int i = 0; i < m; i++){
      for(int j = 0; j < n; j++){
        if(s[i][j] == '0')
          temp[j] = 0;
        else
          temp[j] += s[i][j] - '0';
      }
      int res = maximumAreaHistogram(temp);
      max = Math.max(res, max);
    }
    return max;
  }
  public static void main(String[] args){
    MaximalRectangle m = new MaximalRectangle();
    char[][] s = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
    System.out.println(m.maximalRectangle(s));
  }
}
