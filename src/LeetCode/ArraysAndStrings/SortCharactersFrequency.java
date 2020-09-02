package LeetCode.ArraysAndStrings;

import java.util.*;

public class SortCharactersFrequency {
  class CharFreq implements Comparable<CharFreq>{
    char c;
    int count;

    CharFreq(char c, int count) {
      this.c = c;
      this.count = count;
    }

    public int compareTo(CharFreq a){
      return a.count - this.count;
    }
  }

  public String frequencySort(String s){
    HashMap<Character, Integer> map = new HashMap<>();
    for(char c : s.toCharArray()){
     map.put(c, map.getOrDefault(c, 0)+1);
    }

    List<CharFreq> freq = new ArrayList();
    for(Map.Entry<Character, Integer> entry : map.entrySet()){
      freq.add((new CharFreq(entry.getKey(), entry.getValue())));
    }
    Collections.sort(freq);

    StringBuilder sb = new StringBuilder();
    for (CharFreq c : freq){
      for(int i = 0; i < c.count; i++){
        sb.append(c.c);
      }
    }
    return sb.toString();
  }

  // using heap
  public String frequencySort2(String s){
    HashMap<Character, Integer> map = new HashMap<>();
    for(char c : s.toCharArray()){
      map.put(c, map.getOrDefault(c, 0)+1);
    }

    PriorityQueue<CharFreq> heap = new PriorityQueue<CharFreq>(new Comparator<CharFreq>() {
      @Override
      public int compare(CharFreq a, CharFreq b){
        return b.count - a.count;
      }
    });

    for(Map.Entry<Character, Integer> entry : map.entrySet()){
      heap.add(new CharFreq(entry.getKey(), entry.getValue()));
    }

    StringBuilder sb = new StringBuilder();
    while (!heap.isEmpty()){
      CharFreq c = heap.remove();
      for(int i = 0; i < c.count; i++){
        sb.append(c.c);
      }
    }
    return sb.toString();
  }

  public String frequencySort3(String s){
    HashMap<Character, Integer> map = new HashMap<>();
    for(char c : s.toCharArray()){
      map.put(c, map.getOrDefault(c, 0)+1);
    }

    List<Character> l = new ArrayList<>(map.keySet());
    Collections.sort(l, (a,b) -> map.get(b) - map.get(a));

    StringBuilder sb = new StringBuilder();
    for (Character c : l){
      int count = map.get(c);
      for(int i = 0; i < count; i++){
        sb.append(c);
      }
    }
    return sb.toString();
  }

  // bucket sort
  public String frequencySort4(String s){
    if (s == null || s.isEmpty()) return s;
    HashMap<Character, Integer> map = new HashMap<>();
    for(char c : s.toCharArray()){
      map.put(c, map.getOrDefault(c, 0)+1);
    }

    int max = Collections.max(map.values());
    List<List<Character>> l = new ArrayList<>();
    for(int i = 0; i <= max; i++){
      l.add(new ArrayList<>());
    }

    for(Map.Entry<Character, Integer> entry : map.entrySet()){
      l.get(entry.getValue()).add(entry.getKey());
    }

    StringBuilder sb = new StringBuilder();
    for(int i = max; i > 0; i--){
      for(Character c : l.get(i)){
        for (int j = 0; j < i; j++) {
          sb.append(c);
        }
      }
    }
    return sb.toString();
  }



  public static void main(String[] args){
    SortCharactersFrequency sf = new SortCharactersFrequency();
    String s = "joetomjob";
//    System.out.print(sf.frequencySort(s));
//    System.out.print(sf.frequencySort2(s));
//    System.out.print(sf.frequencySort3(s));
    System.out.print(sf.frequencySort4(s));
  }
}
