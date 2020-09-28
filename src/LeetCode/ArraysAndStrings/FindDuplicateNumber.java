package LeetCode.ArraysAndStrings;

import java.util.HashSet;

public class FindDuplicateNumber {
  // O(n) time and O(n) space
  public int findDuplicate(int[] nums){
    HashSet<Integer> set = new HashSet<>();
    for(int i : nums) {
      if(set.contains(i)) return i;
      else set.add(i);
    }
    return -1;
  }

  
  public static void main(String[] args){

  }
}
