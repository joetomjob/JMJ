package LeetCode.sortingAndSearching;

import java.util.*;

public class TopKElements {
  public int[] topKFrequent(int[] nums, int k) {
    if(nums.length == k) return nums;
    HashMap<Integer, Integer> count = new HashMap<>();
    for(int a : nums) {
      count.put(a, count.getOrDefault(a, 0)+1);
    }

    Queue<Integer> q = new PriorityQueue<>((n1, n2) -> count.get(n1) - count.get(n2));

    for(int i : count.keySet()) {
      q.add(i);
      if(q.size() > k) q.poll();
    }

    int[] res = new int[k];
    for (int i = 0; i < k; i++) {
      res[i] = q.poll();
    }
    return res;
  }

  int[] unique;
  HashMap<Integer, Integer> count = new HashMap<>();
  public int[] partitionMethod(int[] nums, int k) {
    if(nums.length == k) return nums;
    for(int a : nums) {
      count.put(a, count.getOrDefault(a, 0)+1);
    }
    int n = count.size();
    unique = new int[n];
    int i = 0;
    for(int a : count.keySet()) {
      unique[i] = a;
      i++;
    }

    quickSelect(0, n-1, n-k);
    return Arrays.copyOfRange(unique, n-k, n);
  }

  public void quickSelect(int l, int r, int k) {
    if(l == r) return;

    int index = quickIndex(l, r);
    if(index == k) {
      return;
    } else if (index > k) {
      quickSelect(l, index -1, k);
    } else {
      quickSelect(index+1, r, k);
    }
  }

  public int quickIndex(int l, int r) {
    int pivotIndex = r;
    int base = l;
    for(int i = l; i < r; i++) {
      if(count.get(unique[i]) < count.get(unique[pivotIndex])) {
        swap(i, base);
        base++;
      }
    }
    swap(pivotIndex, base);
    return base;
  }

  public void swap(int a, int b) {
    int temp = unique[a];
    unique[a] = unique[b];
    unique[b] = temp;
  }

  public static void main(String[] args) {
    TopKElements t = new TopKElements();
    int[] a = {2,1,2,1,3,1};
    int[] res = t.topKFrequent(a, 2);
    for (int i = 0; i < res.length; i++) {
      System.out.print(res[i]);
      System.out.print('\t');
    }

    int[] res1 = t.partitionMethod(a, 2);
    System.out.print('\n');
    for (int i = 0; i < res.length; i++) {
      System.out.print(res[i]);
      System.out.print('\t');
    }
  }
}
