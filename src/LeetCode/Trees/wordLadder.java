package LeetCode.Trees;

import java.util.*;
class Obj {
  String str;
  int len;

  Obj(String s, int len){
    this.str = s;
    this.len = len;
  }
}
public class wordLadder {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    if (beginWord.length() == 0 || endWord.length() == 0 || wordList.size() == 0)
      return 0;

    Queue<Obj> q = new LinkedList<>();
    q.add(new Obj(beginWord, 1));

    while (!q.isEmpty()) {
      Obj s = q.poll();
      ListIterator<String> itr = wordList.listIterator();
      while (itr.hasNext()){
        String next = itr.next();
        if(isAdjacent(s.str, next)){
          itr.remove();
          q.add(new Obj(next, s.len+1));
          if(next.equals(endWord))
            return s.len+1;
        }
      }
    }

    return 0;
  }

  private boolean isAdjacent(String s1, String s2){
    int count = 0;
    for(int i = 0; i < s1.length(); i++){
      if(s1.charAt(i) != s2.charAt(i)){
        count++;

        if (count > 1) {
          return false;
        }
      }
    }
    return count > 1 ? false : true;
  }

  public static void main(String[] args) {
    List<String> wordList = new ArrayList<>();
    wordList.add("hot");wordList.add("dot");wordList.add("dog");wordList.add("lot");wordList.add("log");wordList.add("cog");

    wordLadder w = new wordLadder();
    System.out.print(w.ladderLength("hot", "cog", wordList));
  }
}
