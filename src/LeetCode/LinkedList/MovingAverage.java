package LeetCode.LinkedList;

import java.util.Deque;
import java.util.LinkedList;

public class MovingAverage {
  int sz, sum;
  Deque<Integer> l;

  public MovingAverage(int size){
    this.sz = size;
    this.sum = 0;
    l = new LinkedList<>();
  }

  public double next(int val){
    if(l.size() == this.sz)
      sum -= this.l.removeFirst();
    l.addLast(val);
    sum += val;
    return (double)sum / (double)l.size();
  }
  public static void main(String[] args){
    MovingAverage m = new MovingAverage(3);
    System.out.print(m.next(1));
    System.out.print('\t');
    System.out.print(m.next(10));
    System.out.print('\t');
    System.out.print(m.next(3));
    System.out.print('\t');
    System.out.print(m.next(5));
    System.out.print('\t');
  }
}
