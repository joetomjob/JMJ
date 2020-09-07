package LeetCode.ArraysAndStrings;

import java.util.*;

public class Leaderboard {
  class Pdetail{
    int id;
    int score;
    int index;

    Pdetail(int id, int score){
      this.id = id;
      this.score = score;
    }
  }

  Map<Integer, Integer> map;
  List<Pdetail> list;

  public Leaderboard(){
    map = new HashMap<>();
    list = new ArrayList<>();
  }

  public void addScore(int playedId, int score){
    if(map.containsKey(playedId)) reset(list, playedId, map.get(playedId)+score);
    else list.add(new Pdetail(playedId, score));
    map.put(playedId, map.getOrDefault(playedId, 0)+score);
    sort(list);
  }

  public int top(int K){
    int sz = list.size();
    int sum = 0;
    for(int i = 0; i < sz && i < K; i++){
      sum += list.get(i).score;
    }
    return sum;
  }

  public void reset(int playedId){
    map.put(playedId, 0);
    reset(list, playedId, 0);
    sort(list);
  }

  public void sort(List<Pdetail> list){
    Collections.sort(list,  new Comparator<Pdetail>() {
      @Override
      public int compare(Pdetail a, Pdetail b){
        return b.score - a.score;
      }
    });
  }

  public void reset(List<Pdetail> list, int key,int value){
    for(Pdetail p : list){
      if(p.id == key) p.score = value;
    }
  }

  public static void main(String[] args){
    Leaderboard lb= new Leaderboard();

    lb.addScore(1,13);
    lb.addScore(2,93);
    lb.addScore(3,84);
    lb.addScore(4,6);
    lb.addScore(5,89);
    lb.addScore(6,31);
    lb.addScore(7,7);
    lb.addScore(8,1);
    lb.addScore(9,98);
    lb.addScore(10,42);
    System.out.println(lb.top(5));
    lb.reset(1);
    lb.reset(2);
    lb.addScore(3,76);
    lb.addScore(4,68);
    System.out.println(lb.top(1));
    lb.reset(3);
    lb.reset(4);
    lb.addScore(2,70);
    lb.reset(2);
  }
}
