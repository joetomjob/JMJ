package LeetCode.ArraysAndStrings;

public class RangeSum2DImmutable {
  int rows, cols;
  int[][] prefix;
  public RangeSum2DImmutable(int[][] matrix){
    this.rows = matrix.length;
    this.cols = rows > 0 ? matrix[0].length : 0;
    this.prefix = new int[rows][cols+1];
    for(int i = 0; i < rows; i++){
      for(int j = 1; j < cols+1; j++){
        prefix[i][j] = matrix[i][j-1] + prefix[i][j-1];
      }
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2){
    if(this.rows == 0 || this.cols == 0) return 0;
    int sum = 0;
    for(int i = row1; i <= row2; i++){
     sum += this.prefix[i][col2+1] - this.prefix[i][col1];
    }
    return sum;
  }
  public static void main(String[] args){
    int[][] matrix =
        {{3, 0, 1, 4, 2},
        {5, 6, 3, 2, 1},
        {1, 2, 0, 1, 5},
        {4, 1, 0, 1, 7},
        {1, 0, 3, 0, 5}};
    int[][] matrix1 = {{}};
//    RangeSum2DImmutable r = new RangeSum2DImmutable(matrix);
    RangeSum2DImmutable r = new RangeSum2DImmutable(matrix1);
    System.out.println(r.sumRegion(2, 1, 4, 3));
    System.out.println(r.sumRegion(1, 1, 2, 2));
    System.out.println(r.sumRegion(1, 2, 2, 4));
  }
}
