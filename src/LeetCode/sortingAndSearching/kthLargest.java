package LeetCode.sortingAndSearching;

import java.util.PriorityQueue;
import java.util.Queue;

public class kthLargest {
    public int findKthLargest(int[] nums, int k) {
      Queue<Integer> q = new PriorityQueue<Integer>();
      for (int i = 0; i < nums.length; i++) {
        q.add(nums[i]);
        if(q.size() > k) q.poll();
      }
      return q.poll();
    }

  public int findKthLargest2(int[] nums, int k) {
      quickSelect(nums, 0, nums.length-1, nums.length - k);
      return nums[nums.length-k];
  }

  public void quickSelect(int[] nums, int l, int r, int k) {
      if(l == r) return;

      int index = partitionIndex(nums, l , r);
      if(index == k){
        return;
      } else if (index > k) {
        quickSelect(nums, l, index-1, k);
      } else {
        quickSelect(nums, index+1, r, k);
      }
  }

  public int partitionIndex(int[] nums, int l, int r) {
      int pivot = r;
      int base = l;
      for (int i = l; i < r; i++) {
        if(nums[i] < nums[pivot]) {
          swap(nums, i, base);
          base++;
        }
      }
      swap(nums, base, pivot);
      return base;
  }

  public void swap(int[] nums, int a, int b) {
      int temp = nums[a];
      nums[a] = nums[b];
      nums[b] = temp;
  }

  public static void main(String[] args) {
    int[] nums = {3,2,1,5,6,4};
    kthLargest k = new kthLargest();
    System.out.println(k.findKthLargest(nums, 3));
    System.out.println(k.findKthLargest2(nums, 2));
  }
}
