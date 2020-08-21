package LeetCode.DynamicProgramming;

// wrong
public class TilingRectangle {
  int res = 0;
  public int tilingRectangle(int n, int m){
    while(n > 0 && m > 0){
      if(n > m)
        n = n-m;
      else
        m = m - n;
      res++;
    }
    return res;
  }

  public static void main(String[] args){
    TilingRectangle t = new TilingRectangle();
    System.out.print(t.tilingRectangle(11,13));
  }
}
