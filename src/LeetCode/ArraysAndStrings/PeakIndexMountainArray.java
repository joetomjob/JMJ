package LeetCode.ArraysAndStrings;

public class PeakIndexMountainArray {
  public int peakIndexMountainArray(int[] A){
    int l = 0, h = A.length - 1;
    while (l <= h) {
      int mid = (l + h) / 2;
      if(mid > 0 && mid < A.length - 1 && A[mid] > A[mid+1] && A[mid] > A[mid-1]){
        return mid;
      } else if(A[mid] < A[mid+1]){
        l = mid + 1;
      } else if(A[mid] < A[mid-1]){
        h = mid - 1;
      }
    }
    return l;
  }
  public static void main(String[] args){
    int[] A = {0, 2, 1, 0};
    PeakIndexMountainArray p = new PeakIndexMountainArray();
    System.out.print(p.peakIndexMountainArray(A));
  }
}
