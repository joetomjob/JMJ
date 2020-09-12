package LeetCode.ArraysAndStrings;

import java.util.*;

public class TopKFrequentWords {
  class WordFreq {
    String word;
    int count;

    WordFreq(String word, int count){
      this.word = word;
      this.count = count;
    }
  }

  public List<String> topKFrequent(String[] words, int k) {
    List<String> res = new ArrayList<>();
    if(words == null || words.length == 0) return res;

    HashMap<String, WordFreq> map = new HashMap<>();
    for(String w : words){
      map.put(w, new WordFreq(w,map.getOrDefault(w, new WordFreq(w, 0)).count + 1));
    }

    List<WordFreq> list = new ArrayList<>(map.values());
    Collections.sort(list, new Comparator<WordFreq>(){
      @Override
      public int compare(WordFreq a, WordFreq b){
        if(a.count == b.count) return a.word.compareTo(b.word);
        else return b.count - a.count;
      }
    });

    for(int i = 0; i < k; i++){
      res.add(list.get(i).word);
    }

    return res;
  }

  public List<String> topKFrequentII(String[] words, int k) {
    List<String> res = new ArrayList<>();
    if(words == null || words.length == 0) return res;

    HashMap<String, Integer> map = new HashMap<>();
    for(String w : words){
      map.put(w, map.getOrDefault(w, 0) + 1);
    }

    PriorityQueue<String> q = new PriorityQueue<>(new Comparator<>(){
      @Override
      public int compare(String a, String b){
        if(map.get(a) == map.get(b)) return b.compareTo(a);
        else return map.get(a)-map.get(b);
      }
    });

    for(String word : map.keySet()){
      q.add(word);
      if(q.size() > k)
        q.poll();
    }

    while (!q.isEmpty()){
      res.add(q.poll());
    }

    Collections.reverse(res);
    return res;
  }

  public List<String> topKFrequentIII(String[] words, int k) {
    List<String> res = new ArrayList<>();
    if(words == null || words.length == 0) return res;

    HashMap<String, Integer> map = new HashMap<>();
    for(String w : words){
      map.put(w, map.getOrDefault(w, 0) + 1);
    }

    List<String> list = new ArrayList<>(map.keySet());
    Collections.sort(list, new Comparator<String>(){
      @Override
      public int compare(String a, String b){
        if(map.get(a) == map.get(b))return a.compareTo(b);
        else return map.get(b) - map.get(a);
      }
    });

    for(int i = 0; i < k; i++){
      res.add(list.get(i));
    }
    return res;
  }



  public static void main(String[] args){
    TopKFrequentWords t = new TopKFrequentWords();
    String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
    List<String> res = t.topKFrequentIII(words, 4);
    for(int i = 0; i < res.size(); i++){
      System.out.print(res.get(i));
      System.out.print('\t');
    }
  }
}
