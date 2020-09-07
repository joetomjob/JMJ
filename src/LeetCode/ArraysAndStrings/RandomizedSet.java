package LeetCode.ArraysAndStrings;

import java.util.*;

public class RandomizedSet {

  HashMap<Integer, Integer> map;
  List<Integer> list;
  Random r = new Random();

  /** Initialize your data structure here. */
  public RandomizedSet() {
    map = new HashMap<>();
    list = new ArrayList<>();
  }

  /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
  public boolean insert(int val) {
    if(map.containsKey(val))
      return false;
    list.add(val);
    map.put(val,list.size()-1);
    return true;
  }

  /** Removes a value from the set. Returns true if the set contained the specified element. */
  public boolean remove(int val) {
    if(!map.containsKey(val))
      return false;

    // delete from an arraylist is o(n) operation. so what we do here is, get the index of element to be deleted from the map
    // and then move the last element to that index, update the map to update the index of the moved element and
    // then delete the last element. This process takes o(1) time.
    int index = map.get(val);
    int sz = list.size();
    // move last element to index pos and update the map
    int temp = list.get(sz-1);
    list.set(index, temp);
    map.put(temp, index);

    //remove last element and remove that element from the map
    list.remove(sz-1);
    map.remove(val);
    return true;
  }

  /** Get a random element from the set. */
  public int getRandom() {
    int random = r.nextInt(list.size());
    return list.get(random);
  }
  public static void main(String[] args){

  }
}
