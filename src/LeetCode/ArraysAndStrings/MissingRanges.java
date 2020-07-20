package LeetCode.ArraysAndStrings;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
  List<String> res = new ArrayList<>();
  public List<String> findMissingRanges(int[] nums, int lower, int upper) {
    long l = (long) lower;
    long u = (long) upper;
    int n = nums.length;
    if (n == 0 ) {
      add(l - 1, u + 1);
      return res;
    }

    add(l-1, nums[0]);
    for (int i = 1; i < n; i++) {
      add(nums[i-1], nums[i]);
    }
    add(nums[n-1], u+1);

    return res;
  }

  public void add(long l, long h) {
    if(l==h)
      return;
    else if (l+1 == h)
      return;
    else if(l+1 == h-1)
      res.add(String.valueOf(l+1));
    else {
      StringBuilder sb = new StringBuilder();
      sb.append(l+1);
      sb.append("->");
      sb.append(h-1);
      res.add(sb.toString());
    }
  }

  public static void main(String[] args) {
    int[] nums = { 0, 1, 3, 50, 75 };
    int l = 0, u = 99;
    MissingRanges m = new MissingRanges();
    List<String> res = m.findMissingRanges(nums, l, u);
    for (int i = 0; i < res.size(); i++) {
      System.out.println(res.get(i));
    }
  }
}
