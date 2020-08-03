package LeetCode.ArraysAndStrings;

import java.util.HashMap;

public class Logger {
  HashMap<String, Integer> map;
  public Logger(){
    map = new HashMap<>();
  }

  public boolean shouldPrintMessage(int timestamp, String message){
    if(map.containsKey(message)){
      if(timestamp - map.get(message)< 10)
        return false;
      else
        map.put(message, timestamp);
    } else
      map.put(message, timestamp);
    return true;
  }

  public static void main(String[] args){
    Logger logger = new Logger();

    System.out.println(logger.shouldPrintMessage(1, "foo"));
    System.out.println(logger.shouldPrintMessage(2,"bar"));
    System.out.println(logger.shouldPrintMessage(3,"foo"));
    System.out.println(logger.shouldPrintMessage(8,"bar"));
    System.out.println(logger.shouldPrintMessage(10,"foo"));
    System.out.println(logger.shouldPrintMessage(11,"foo"));
  }
}
