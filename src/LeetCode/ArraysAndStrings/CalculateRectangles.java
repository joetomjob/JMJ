package LeetCode.ArraysAndStrings;

import java.util.ArrayList;
import java.util.List;

public class CalculateRectangles {
  public int[] calculateRectangle(int[][] input){
    int rows = input.length;
    int cols = input[0].length;

    int[] res = new int[4];
    for(int i = 0; i < rows; i++){
      for(int j = 0; j < cols; j++){
        if(input[i][j] == 0){
          int width = 0, height = 0, tempJ = j, tempI = i;
          while(tempJ < cols && input[i][tempJ] == 0){
            width++;
            tempJ++;
          }
          while(tempI < rows && input[tempI][j] == 0){
            height++;
            tempI++;
          }
          return new int[]{i, j, width, height};
        }
      }
    }
    return res;
  }

  public List<int[]> calculateRectangleII(int[][] input){
    int rows = input.length;
    int cols = input[0].length;

    List<int[]> res = new ArrayList<>();

    for(int i = 0; i < rows; i++){
      for(int j = 0; j < cols; j++){
        if(input[i][j] == 0){
          if(i == 0 && j == 0
              ||(i == 0 && j > 0 && input[i][j-1] == 1)
              ||(j == 0 && i > 0 && input[i-1][j] == 1)
              ||(i > 0 && j > 0 && input[i-1][j] == 1 && input[i][j-1] == 1))
          {
            int width = 0, height = 0, tempJ = j, tempI = i;
            while(tempJ < cols && input[i][tempJ] == 0){
              width++;
              tempJ++;
            }
            while(tempI < rows && input[tempI][j] == 0){
              height++;
              tempI++;
            }
            res.add(new int[]{i, j, width, height});
          }
        }
      }
    }
    return res;
  }
}
