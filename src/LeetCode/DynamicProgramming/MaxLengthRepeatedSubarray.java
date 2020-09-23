package LeetCode.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// Maximum length of repeated subarray
public class MaxLengthRepeatedSubarray {

  // brute force
  public int findLength(int[] A, int[] B){
    int ans = 0;
    for(int i = 0; i < A.length; i++){
      for(int j =0; j < B.length; j++){
        int k = 0;
        while (i+k < A.length && j+k < B.length && A[i+k] == B[j+k]) k++;
        ans = Math.max(k, ans);
      }
    }
    return ans;
  }

  // use hasMap - one loop
  public int findLengthII(int[] A, int[] B){

    // create a hashmap with key as the element in the array B and value and the index of the element.
    // Since the same value can occur more than once, one key can have many indices. Therefore the value of
    // the hashmap is arraylist.
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    for(int i = 0; i < B.length; i++){
      if(map.containsKey(B[i])) map.get(B[i]).add(i);
      else map.put(B[i], new ArrayList<>(Arrays.asList(i)));
    }

    int ans = 0;
    for(int i = 0; i < A.length; i++){
      if(map.containsKey(A[i])){
        for(Integer val : map.get(A[i])){
          int k = 0;
          while (i+k < A.length && val+k < B.length && A[i+k] == B[val+k]) k++;
          ans = Math.max(k, ans);
        }
      }
    }
    return ans;
  }

  public int findLengthIII(int[] A, int[] B){
    int[][] memo = new int[A.length+1][B.length+1];
    int ans = 0;
    for(int i = A.length-1; i >= 0; i--){
      for(int j = B.length-1; j >= 0; j--) {
        if(A[i] == B[j]){
          memo[i][j] = 1+memo[i+1][j+1];
          ans = Math.max(ans, memo[i][j]);
        }
      }
    }
    return ans;
  }

  public static void main(String[] args){
    int[] A = {1,2,3,2,1};
    int[] B = {3,2,1,4,7};

    MaxLengthRepeatedSubarray m = new MaxLengthRepeatedSubarray();
    System.out.println(m.findLength(A,B));
    System.out.println(m.findLengthII(A,B));
    System.out.println(m.findLengthIII(A,B));
  }
}
