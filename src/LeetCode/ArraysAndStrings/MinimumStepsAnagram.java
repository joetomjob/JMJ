package LeetCode.ArraysAndStrings;

public class MinimumStepsAnagram {
  public int minSteps(String s, String t){
    int[] arr = new int[128];
    for(char c : s.toCharArray()){
      arr[c]++;
    }

    for(char c : t.toCharArray()){
      arr[c] = arr[c] > 0 ? arr[c]-1 : arr[c];
    }

    int ans = 0;
    for(int i = 0; i < 128; i++){
      ans += arr[i];
    }

    return ans;
  }
  public static void main(String[] args){
    MinimumStepsAnagram m = new MinimumStepsAnagram();
    System.out.println(m.minSteps("bab", "aba"));
    System.out.println(m.minSteps("leetcode", "practice"));
    System.out.println(m.minSteps("anagram", "mangaar"));
    System.out.println(m.minSteps("xxyyzz", "xxyyzz"));
  }
}
