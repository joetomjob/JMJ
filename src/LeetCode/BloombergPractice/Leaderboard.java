package LeetCode.BloombergPractice;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

public class Leaderboard {
  class Pdetail{
    int id;
    int score;

    Pdetail(int id, int score){
      this.id = id;
      this.score = score;
    }
  }

  HashMap<Integer, Pdetail> map;
  TreeSet<Pdetail> set;

  public Leaderboard(){
    map = new HashMap<>();
    set = new TreeSet<>(new Comparator<Pdetail>() {
      @Override
      public int compare(Pdetail o1, Pdetail o2) {
        if(o1.score == o2.score) return o1.id - o2.id;
        else return o2.score - o1.score;
      }
    });
  }

  public void addScore(int playedId, int score){
    Pdetail p;
    if(map.containsKey(playedId)) {
      p = map.get(playedId);
      set.remove(p);
      p.score += score;
      set.add(p);
    } else {
      p = new Pdetail(playedId, score);
      map.put(playedId, p);
      set.add(p);
    }
  }
  public int top(int K){
    int sum = 0;
    Iterator<Pdetail> i = set.iterator();
    while (K-- > 0 && i.hasNext()) {
      sum+=i.next().score;
    }
    return sum;
  }

  public void reset(int playerId) {
    Pdetail p = map.get(playerId);
    set.remove(p);
    p.score = 0;
  }
  public static void main(String[] args) {

  }
}
