package LeetCode.Trees;

import java.util.*;

public class CourseSchedule2 {
  int WHITE = 0, GRAY = 1, BLACK = 2;

  boolean isPossible = true;
  List<Integer> topologicalSort = new ArrayList<>();
  HashMap<Integer, Integer> color = new HashMap<>();
  HashMap<Integer, List<Integer>> adjList = new HashMap<>();

  public int[] findOrder(int numCourses, int[][] prerequisites){
    // put all initial values as white
    for(int i = 0; i < numCourses; i++){
      color.put(i, WHITE);
    }

    for(int i = 0; i < prerequisites.length; i++){
      if(adjList.containsKey(prerequisites[i][1])) {
        adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
      } else {
        adjList.put(prerequisites[i][1], new ArrayList<>(Arrays.asList(prerequisites[i][0])));
      }
    }

    for (int i = 0; i < numCourses; i++) {
      if(color.get(i) == WHITE)
        dfs(i);
    }

    int[] order;
    if(isPossible){
      order = new int[numCourses];
      for (int i = 0; i < numCourses; i++){
        order[i] = topologicalSort.get(numCourses-1-i);
      }
    } else
      order = new int[0];

    return order;
  }

  public void dfs(int node){
    if(!isPossible)
      return;

    color.put(node, GRAY);
    for (Integer value : adjList.getOrDefault(node, new ArrayList<>())){
      if(color.get(value) == WHITE){
        dfs(value);
      } else if (color.get(value) == GRAY)
        isPossible = false;
    }

    color.put(node, BLACK);
    topologicalSort.add(node);
  }

  public static void main(String[] args){
//    int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
//    int[][] prerequisites = {{1,0}};
    int[][] prerequisites = {};
    CourseSchedule2 c = new CourseSchedule2();
    int[] res = c.findOrder(1, prerequisites);
    for(int i = 0; i < res.length; i++){
      System.out.print(res[i]);
      System.out.print('\t');
    }
  }
}
