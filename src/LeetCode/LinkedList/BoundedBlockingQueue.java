package LeetCode.LinkedList;

import java.util.LinkedList;

public class BoundedBlockingQueue {
  LinkedList<Integer> q;
  int capacity;
  public BoundedBlockingQueue(int capacity) {
    this.q = new LinkedList<>();
    this.capacity = capacity;
  }

  public synchronized void enqueue(int element) throws InterruptedException {
    while(q.size() == capacity) {
      wait();
      continue;
    }
    q.addFirst(element);
    notifyAll();
  }

  public synchronized int dequeue() throws InterruptedException {
    while(q.isEmpty()){
      wait();
      continue;
    }

    int k = q.removeLast();
    notifyAll();
    return k;
  }

  public int size() {
    return q.size();
  }

  public static void main(String[] args){

  }
}
