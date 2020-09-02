package LeetCode.ArraysAndStrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FizzBuzz {
  public List<String> fizzBuzz(int n){
    List<String> res = new ArrayList<>();
    if(n == 0) return res;
    for(int i = 1; i <= n; i++){
      if(i%5 == 0 && i%3== 0)
        res.add("FizzBuzz");
      else if(i%3 == 0)
        res.add("Fizz");
      else if(i%5 == 0)
        res.add("Buzz");
      else
        res.add(""+i);
    }
    return res;
  }

  public List<String> fizzBuzz2(int n){
    List<String> res = new ArrayList<>();
    if(n == 0) return res;

    for(int i = 1; i <= n; i++){
      String s = "";
      if(i%3 == 0)
        s += "Fizz";
      if(i%5 == 0)
        s += "Buzz";
      if(s == "")
        s += ""+i;

      res.add(s);
    }
    return res;
  }

  public List<String> fizzBuzz3(int n){
    List<String> res = new ArrayList<>();
    if(n == 0) return res;
    HashMap<Integer, String> map = new HashMap<>();
    map.put(3, "Fizz");
    map.put(5, "Buzz");
    for(int i = 1; i <= n; i++){
      String s = "";

      for(Integer key : map.keySet()){
        if(i%key == 0)
          s += map.get(key);
      }

      if(s == "")
        s += ""+i;

      res.add(s);
    }
    return res;
  }

  public static void main(String[] args){
    FizzBuzz f = new FizzBuzz();
//    List<String>res = f.fizzBuzz(15);
//    List<String>res = f.fizzBuzz2(15);
    List<String>res = f.fizzBuzz3(15);
    for(String s : res){
      System.out.print(s);
      System.out.print('\t');
    }
  }
}
