package LeetCode.ArraysAndStrings;

public class SqrtX {
  public int mySqrt(int x){
    if(x == 0 || x == 1) return x;
    int l = 2, r = x/2;

    while(l <= r){
      int mid = l + (r-l)/2;
      long num = (long) mid * mid;
      if(num == x)
        return mid;
      else if(num < x)
        l = mid+1;
      else {
        r = mid-1;
      }
    }
    return r;
  }

  // Newtons method: x_k+1 = 1/2 (x_k + x/x_k)
  public int mySqrtII(int x) {
    if(x == 0 || x == 1) return x;
    double x0 = x;
    double x1 = (x0 + x/x0)/2.0;
    while(Math.abs(x1-x0) >= 1) {
      x0 = x1;
      x1 = (x0 + x/x0)/2.0;
    }
    return (int)x1;
  }

  public static void main(String[] args){
    SqrtX s = new SqrtX();

    System.out.println(s.mySqrt(2147395599));
    System.out.println(s.mySqrtII(2147395599));
  }
}
