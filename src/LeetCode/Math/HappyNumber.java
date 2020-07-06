package LeetCode.Math;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
  public int getValue(int number) {
    int res = 0;
    while (number > 0) {
      int rem = number % 10;
      number /= 10;
      res += (rem * rem);
    }
    return res;
  }

  public boolean isHappy(int n) {
    Set<Integer> set = new HashSet<>();
    int res = getValue(n);
    while (res != 1 && !set.contains(res)) {
      set.add(res);
      res = getValue(res);
    }
    return res == 1;
  }

  // slow runner fast runner method
  public boolean isHappy2(int n) {
    int slow = n;
    int fast = getValue(n);

    while (fast != 1 && slow != fast) {
      slow = getValue(slow);
      fast = getValue(getValue(fast));
    }
    return fast == 1;
  }



  public static void main(String[] args) {
    HappyNumber h = new HappyNumber();
    System.out.println(h.isHappy(7));
  }
}
