package LeetCode.DynamicProgramming;

public class DivideChocolate {
  // find low and max possible sweetness I can get. then do a binary search in that range.
  // each time we loop over the sweetness array and find the number of chunks that satisfies the condition.
  // the condition is, running sum should be less than the mid value
  public int maximumSweetness(int[] sweetness, int K){

    int sum = 0;
    for(int i : sweetness)
      sum += i;

    int low = 1; // the problem says the value range from 1 to 10^5
    int high = sum / (K+1); // the maximum value of high will be sum / k+1

    while(low < high) {
      int mid = low + (high - low)/2 + 1;

      int tmpSum = 0, count = 0;
      for(int i : sweetness) {
        tmpSum += i;
        if(tmpSum >= mid){
          count++;
          tmpSum = 0;
        }
      }
      if(count >= K+1){
        low = mid;
      } else {
        high = mid-1;
      }
    }
    return low;
  }
  public static void main(String[] args){
    DivideChocolate d = new DivideChocolate();
    int[] sweetness = {1,2,3,4,5,6,7,8,9};
    System.out.print(d.maximumSweetness(sweetness, 5));
  }
}
