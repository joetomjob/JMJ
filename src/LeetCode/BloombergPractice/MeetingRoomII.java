package LeetCode.BloombergPractice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomII {
  public int minMeetingRooms(int[][] intervals) {
    if(intervals.length < 2) return intervals.length;

    Arrays.sort(intervals, new Comparator<int[]>() {
      @Override
      public int compare(int[] a, int[] b) {
        return a[0] - b[0];
      }
    });

    PriorityQueue<Integer> heap = new PriorityQueue<>();
    for(int[] i : intervals) {
      if(heap.isEmpty() || i[1] < heap.peek()) heap.add(i[1]);
      else {
        heap.poll(); heap.add(i[1]);
      }
    }

    return heap.size();
  }
  public static void main(String[] args){

  }
}
