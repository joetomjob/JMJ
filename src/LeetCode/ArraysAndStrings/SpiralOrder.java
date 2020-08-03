package LeetCode.ArraysAndStrings;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
  public List<Integer> spiralOrder(int[][] matrix){
    List<Integer> res = new ArrayList<>();
    if(matrix == null || matrix.length == 0) return res;

    int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
    int size = matrix.length * matrix[0].length;

    while (res.size() < size){
      for(int i = left; i <= right && res.size() < size;  i++)
        res.add(matrix[top][i]);
      top++;
      for(int i = top; i <= bottom && res.size() < size; i++ )
        res.add(matrix[i][right]);
      right--;
      for(int i = right; i >= left && res.size() < size; i--)
        res.add(matrix[bottom][i]);
      bottom--;
      for(int i = bottom; i >= top && res.size() < size; i--)
        res.add(matrix[i][left]);
      left++;
    }
    return res;
  }
  public static void main(String[] args) {
    SpiralOrder s = new SpiralOrder();
//    int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
    int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
    List<Integer> res = s.spiralOrder(matrix);
    for(int i = 0; i < res.size(); i++){
      System.out.print(res.get(i));
      System.out.print('\t');
    }
  }
}
