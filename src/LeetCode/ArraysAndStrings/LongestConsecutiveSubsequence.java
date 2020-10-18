package LeetCode.ArraysAndStrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestConsecutiveSubsequence {
  public int longestConsecutive(int[] nums){
//    int res = bruteForce(nums);
//    int res2 = sortingApproach(nums);
    int res3 = bestApproach(nums);
    return res3;
  }

  public int bruteForce(int[] nums) {
    int longestStreak = 1;
    for (int num : nums) {
      int currentStreak = 1;
      int curNum = num;
      while (arrayContains(nums, ++curNum)) currentStreak++;
      longestStreak = Math.max(longestStreak, currentStreak);
    }
    return longestStreak;
  }

  public boolean arrayContains(int[] nums, int num) {
    for(int n : nums) {
      if(n == num) return true;
    }
    return false;
  }

  // O(nlogn) sorted approcach. space complexity is O(1).
  public int sortingApproach(int[] nums){
    if(nums.length == 0) return 0;
    Arrays.sort(nums);
    int curStreak = 1, longestStreak = 1;

    for (int i = 1; i < nums.length; i++) {
      if(nums[i] != nums[i-1]){
        if(nums[i] == nums[i-1]+1) ++curStreak;
        else {
          longestStreak = Math.max(longestStreak, curStreak);
          curStreak = 1;
        }
      }
    }
    return Math.max(longestStreak, curStreak);
  }

  // O(n) time complexity solution.
  public int bestApproach(int[] nums){
    if(nums.length == 0) return 0;
    HashSet<Integer> set = new HashSet<>();
    for(int num : nums) set.add(num);

    int longestStreak = 1, curStreak = 1;

    for(int num : set){
      if(!set.contains(num-1)){
        int curNum = num;
        curStreak = 1;

        while (set.contains(++curNum)) curStreak += 1;

        longestStreak = Math.max(longestStreak, curStreak);
      }
    }

    return longestStreak;
  }


  public static void main(String[] args){
    int[] nums = {100,4,200,1,3,2};
    LongestConsecutiveSubsequence l = new LongestConsecutiveSubsequence();
    System.out.println(l.longestConsecutive(nums));
  }
}
