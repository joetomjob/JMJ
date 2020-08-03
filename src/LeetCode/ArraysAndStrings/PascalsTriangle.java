package LeetCode.ArraysAndStrings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PascalsTriangle {
  public List<List<Integer>> generate(int numRows){
    List<List<Integer>> res = new ArrayList<>();
    for(int i = 0; i < numRows; i++){
      res.add(new ArrayList<>(Collections.nCopies(i+1, 0)));
      res.get(i).set(0,1);
      for (int j = 1; j < i; j++) {
        res.get(i).set(j, res.get(i-1).get(j-1) + res.get(i-1).get(j));
      }
      res.get(i).set(i,1);
    }
    return res;
  }
  public static void main(String[] args){
    PascalsTriangle p = new PascalsTriangle();
    List<List<Integer>> res = p.generate(5);
    for (int i = 0; i < res.size(); i++) {
      for (int j = 0; j < res.get(i).size(); j++) {
        System.out.print(res.get(i).get(j));
        System.out.print('\t');
      }
      System.out.print('\n');
    }
  }
}
