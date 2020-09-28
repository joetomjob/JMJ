package LeetCode.Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CourseSchedule {
  int WHITE = 0, GRAY = 1, BLACK = 2;
  HashMap<Integer, List<Integer>> map;
  int[] courses;
  boolean isPossible;
  public boolean canFinish(int numCourses, int[][] prerequisites){
    isPossible = true;
    map = new HashMap<>();
    courses = new int[numCourses];

    // initially set all courses as white as we have not taken any courses (visited any node)
    for(int i = 0; i < numCourses; i++) courses[i] = this.WHITE;

    // create the adjacency list
    for(int[] pre : prerequisites){
      if(map.containsKey(pre[1])) map.get(pre[1]).add(pre[0]);
      else map.put(pre[1], new ArrayList<>(Arrays.asList(pre[0])));
    }

    // now do a dfs for each course and mark the courses with appropriate colors.
    // If a node is visited while doing dfs, it is marked as gray so that if we visit it again while doing
    // the same dfs (cyclic dependency), then we cannot perform a topological sort and we return immediately.

    for (int i = 0; i < numCourses; i++) {
      if(courses[i] == this.WHITE) dfs(i);
    }

    return isPossible;
  }

  public void dfs(int course) {
    if(!isPossible) return;

    courses[course] = this.GRAY;


    for(Integer child : this.map.getOrDefault(course, new ArrayList<>())) {
      if(this.courses[child] == this.WHITE) dfs(child);
      else if(this.courses[child] == this.GRAY) this.isPossible = false;
    }

    courses[course] = this.BLACK;
  }
  public static void main(String[] args){
    int[][] prerequisites1 = {{1,0}};
    int[][] prerequisites2 = {{1,0}, {0,1}};
    int[][] prerequisites3 = {{0,1}, {3,1}, {1,3}, {3,2}};
    CourseSchedule c = new CourseSchedule();
//    System.out.println(c.canFinish(2, prerequisites1));
//    System.out.println(c.canFinish(2, prerequisites2));
    System.out.println(c.canFinish(4, prerequisites3));
  }
}
