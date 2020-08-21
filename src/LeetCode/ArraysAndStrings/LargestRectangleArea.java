package LeetCode.ArraysAndStrings;

import java.util.LinkedList;
import java.util.Stack;

public class LargestRectangleArea {
  public int largestRectangleArea(int[] heights){
    Stack<Integer> s = new Stack<>();
    int max = 0, area = 0, i = 0;
    for(i = 0; i < heights.length;){
      if(s.isEmpty() || heights[i] >= heights[s.peek()]){
        s.push(i);
        i++;
      } else {
        int ind = s.pop();
        if(s.isEmpty())
          area = heights[ind] * i;
        else
          area = heights[ind] * (i - s.peek() - 1);

        max = Math.max(max, area);
      }
    }
    while(!s.isEmpty()){
      int ind = s.pop();
      if(s.isEmpty())
        area = heights[ind] * i;
      else
        area = heights[ind] * (i - s.peek() - 1);

      max = Math.max(max, area);
    }
    return max;
  }
  public static void main(String[] args){
    int[] nums = {2,1,5,6,2,3};
    LargestRectangleArea l = new LargestRectangleArea();
    System.out.println(l.largestRectangleArea(nums));
  }
}
