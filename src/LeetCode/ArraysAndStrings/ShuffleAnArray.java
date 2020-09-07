package LeetCode.ArraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ShuffleAnArray {
  static class Solution{
    int[] original;
    Random r = new Random();
    public Solution(int[] nums){
      original = nums;
    }
    public int[] reset(){
      return original;
    }

    public int[] shuffle(){
      Random r = new Random();
      int[] res = helper();
      return res;
    }

    // O(n^2) as remove operation take O(n) time we are looping through the array.
    public int[] helper(){
      List<Integer> temp = new ArrayList<>();
      for(int i = 0; i < original.length; i++){
        temp.add(original[i]);
      }
      int[] res = new int[original.length];
      for(int i = 0; i < original.length; i++){
        int ind = r.nextInt(temp.size());
        res[i] = (int)temp.get(ind);
        temp.remove(ind);
      }
      return res;
    }

    //fisher - yates algo. O(n) time. we are not using a separate list.
    // We get and index between current index and last index and do a swap

    public int[] fisherYates(){
      int[] temp = original.clone();
      for(int i = 0; i < temp.length; i++){
        swap(temp, i, getRandom(i, temp.length));
      }
      return temp;
    }

    public int getRandom(int min, int max){
      return r.nextInt(max-min)+min;
    }
    public void swap(int[] arr, int i, int j){
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }
  }
  public static void main(String[] args){
    int[] nums = {1,2,3};
    Solution s = new Solution(nums);
    int[] res = s.shuffle();
  }
}
