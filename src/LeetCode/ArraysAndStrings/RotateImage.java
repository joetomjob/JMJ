package LeetCode.ArraysAndStrings;

public class RotateImage {
  public void rotate(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = i; j < matrix[i].length; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }
    for (int i = 0; i < matrix.length; i++) {
      reverse(matrix[i]);
    }
    printArray(matrix);
  }

  public void reverse(int[] a) {
    for (int i = 0; i < a.length/2; i++) {
      swap(a, i, a.length - 1 - i);
    }
  }

  public void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public void printArray(int[][] a) {
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[i].length; j++) {
        System.out.print(a[i][j]);
        System.out.print('\t');
      }
      System.out.print('\n');
    }
  }

  public static void main(String[] args) {
    int[][] a = {{5, 1, 9,11}, {2, 4, 8,10}, {13, 3, 6, 7}, {15, 14, 12,16}};
    RotateImage r = new RotateImage();
    r.rotate(a);
  }
}
