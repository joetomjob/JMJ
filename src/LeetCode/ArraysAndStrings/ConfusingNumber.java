package LeetCode.ArraysAndStrings;

import java.util.HashMap;

public class ConfusingNumber {
  HashMap<Integer, Integer> map = new HashMap<>();
  int res;

  public int confusingNumberII(int N){
    res = 0;
    map.put(0, 0);
    map.put(1, 1);
    map.put(6, 9);
    map.put(8, 8);
    map.put(9, 6);

    helper(N, 0);
    return res;
  }

  public void helper(int N, long cur){
    if(isConfusing(cur)){
      res++;
    }

    for(Integer n : map.keySet()){
      long val = cur * 10 + n;
      if(val <= N && val != 0)
        helper(N, val);
    }
  }

  public boolean isConfusing(long n){
    long cur = n;
    long num = 0;

    while(n > 0){
      num = num*10 + map.get((int)n%10);
      n = n/10;
    }
    return cur != num;
  }

  public static void main(String[] args){
    ConfusingNumber c = new ConfusingNumber();
    System.out.print(c.confusingNumberII(100));
  }
}
