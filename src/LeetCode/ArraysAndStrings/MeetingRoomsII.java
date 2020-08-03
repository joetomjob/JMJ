package LeetCode.ArraysAndStrings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {
  public int minMeetingRooms(int[][] intervals){
    if(intervals.length == 0) return 0;
    if(intervals.length == 1) return 1;

    Arrays.sort(intervals, new Comparator<int[]>() {
      public int compare(int[] o1, int[] o2) {
        return o1[0] - o2[0];
      }
    });

    PriorityQueue<Integer> heap = new PriorityQueue<>();

    for (int i = 0; i < intervals.length; i++) {
      if(heap.isEmpty() || intervals[i][0] < heap.peek()){
        heap.add(intervals[i][1]);
      } else {
        heap.poll();
        heap.add(intervals[i][1]);
      }
    }
    return heap.size();
  }

  public static void main(String[] args){
    int[][] a = {{5, 8},{6, 8}};
  }
}
