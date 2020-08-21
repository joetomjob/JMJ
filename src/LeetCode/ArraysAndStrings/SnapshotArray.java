package LeetCode.ArraysAndStrings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class SnapshotArray {
  List<List<Integer>> arr;
  int snap_id;

  // better to save the value in hashmap. the key will be index+"-"+snap_id;
  HashMap<String, Integer> map;
  public SnapshotArray(int length){
    arr = new ArrayList<>();
    arr.add(new ArrayList<>(Collections.nCopies(length, 0)));
    snap_id = 0;

    map = new HashMap<>();
    for (int i = 0; i < length; i++) {
      map.put(i+"-"+snap_id, 0);
    }
  }
  public void set(int index, int val){
    arr.get(snap_id).set(index, val);
  }

  public int snap(){
    arr.add(new ArrayList<>(arr.get(snap_id)));
    return snap_id++;
  }

  public int get(int index, int snap_id){
    return arr.get(snap_id).get(index);
  }

  // better Solution
  public void set1(int index, int val){
    map.put(index+"-"+snap_id, val);
  }

  public int snap1(){
    return snap_id++;
  }

  public int get1(int index, int snap_id){
    while (!map.containsKey(index+"-"+snap_id))
      snap_id--;
    return map.get(index+"-"+snap_id);
  }



  public static void main(String[] args){
    SnapshotArray snapshotArr = new SnapshotArray(1);
    snapshotArr.set(0,15);
    System.out.print(snapshotArr.snap());
    System.out.print(snapshotArr.snap());
    System.out.print(snapshotArr.snap());
    System.out.print(snapshotArr.get(0,2));
    System.out.print(snapshotArr.snap());
    System.out.print(snapshotArr.snap());
    System.out.print(snapshotArr.get(0,0));

  }
}
