package LeetCode.Trees;

import java.util.HashSet;

interface Robot{
  void clean();
  void turnLeft();
  void turnRight();
  boolean move();

}
public class RobotRoomCleaner {
  public static void main(String[] args) {
    RobotRoomCleaner r = new RobotRoomCleaner();
    Robot robot;
//    r.cleanRoom(robot);
  }



  HashSet<String> visited = new HashSet<>();
  int row[] = {-1, 0, 1, 0};
  int col[] = {0, 1, 0, -1};
  Robot robot;

  public void cleanRoom(Robot robot) {
    this.robot = robot;
    dfs(0, 0, 0);
  }

  public void dfs(int x, int y, int pos){
    visited.add(x +"_"+ y);
    this.robot.clean();

    for(int i = 0; i < 4; i++){
      int newpos = (i+pos)%4;
      int newX = x + row[pos];
      int newY = y + col[pos];

      if(!visited.contains(newX + "_" + newY) && this.robot.move()){
        dfs(newX, newY, newpos);
        goBack();
      }
      this.robot.turnRight();
    }
  }

  public void goBack(){
    this.robot.turnLeft();
    this.robot.turnLeft();
    this.robot.move();
    this.robot.turnLeft();
    this.robot.turnLeft();
  }

}