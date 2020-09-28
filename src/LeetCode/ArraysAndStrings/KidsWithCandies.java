package LeetCode.ArraysAndStrings;

import java.util.ArrayList;
import java.util.List;

public class KidsWithCandies {
  public List<Boolean> kidsWithCandies(int[] candies, int extracandies){
    int max = Integer.MIN_VALUE;
    List<Boolean> res = new ArrayList<>();
    for(int i : candies) max = Math.max(max, i);

    for(int i : candies) {
      if(i+extracandies >= max) res.add(true);
      else res.add(false);
    }
    return res;
  }
  public static void main(String[] args){
    int[] candies = {2,3,5,1,3};
    int extracandies = 3;
    KidsWithCandies k = new KidsWithCandies();
    List<Boolean> res = k.kidsWithCandies(candies, extracandies);
    for(Boolean b : res){
      System.out.print(b);
      System.out.print('\t');
    }
  }
}
