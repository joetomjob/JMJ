package LeetCode.ArraysAndStrings;

import java.util.ArrayList;
import java.util.List;

public class MaxDistance {
  public int maxDistance(List<List<Integer>> arrays) {
    return -1;
  }
  public static void main(String[] args){
    List<List<Integer>> list = new ArrayList<>();
    List l1 = new ArrayList();
    l1.add(1);l1.add(4);
    List l2 = new ArrayList();
    l2.add(0);l2.add(5);
//    List l3 = new ArrayList();
//    l3.add(1);l3.add(2);l3.add(3);

    list.add(l1);list.add(l2);
    MaxDistance m = new MaxDistance();
    System.out.println(m.maxDistance(list));
  }
}
