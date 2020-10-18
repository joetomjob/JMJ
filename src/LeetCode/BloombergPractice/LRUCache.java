package LeetCode.BloombergPractice;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
  class DNode {
    int key;
    int val;
    DNode prev;
    DNode next;

    DNode(){}
    DNode(int key, int val) {
      this.key = key;
      this.val = val;
    }
  }

  public void removeNode(DNode node){
    DNode nx = node.next;
    DNode pr = node.prev;

    pr.next = nx;
    nx.prev = pr;
  }


  // always add node to head
  public void addNode(DNode node){
    node.next = head.next;
    node.prev = head;

    head.next.prev = node;
    head.next = node;
  }

  public void moveToHead(DNode node){
    removeNode(node);
    addNode(node);
  }

  public DNode popTail(){
    DNode pr = tail.prev;
    removeNode(pr);
    return pr;
  }

  HashMap<Integer, DNode> map = new HashMap<>();
  DNode head, tail;
  int size, capacity;

  public LRUCache(int capacity) {
    head = new DNode();
    tail = new DNode();

    head.next = tail;
    tail.prev = head;

    this.capacity = capacity;
    this.size = 0;
  }

  public int get(int key) {
    DNode node = map.get(key);
    if(node == null) return -1;

    moveToHead(node);
    return node.val;
  }

  public void put(int key, int value) {
    DNode node = map.get(key);

    if(node == null) {
      DNode n = new DNode(key, value);
      map.put(key, n);
      addNode(n);
      ++size;

      if(size > capacity) {
        DNode del = popTail();
        map.remove(del.key);
        --size;
      }
    } else {
      node.val = value;
      moveToHead(node);
    }
  }
}
