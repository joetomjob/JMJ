package LeetCode.Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class TrieNode1 implements Comparable<TrieNode1>{
  TrieNode1[] children;
  String s;
  int times;
  List<TrieNode1> hot;

  TrieNode1(){
    children = new TrieNode1[128];
    s = null;
    times = 0;
    hot = new ArrayList<>();
  }

  public int compareTo(TrieNode1 node){
    if(node.times == this.times){
      return this.s.compareTo(node.s);
    }
    return node.times - this.times;
  }

  public void update(TrieNode1 node){
    if(!hot.contains(node))
      hot.add(node);

    Collections.sort(hot);

    if(hot.size() > 3)
      hot.remove(hot.size() - 1);
  }
}

public class AutocompleteSystem {
  TrieNode1 root;
  TrieNode1 cur;
  StringBuilder sb;

  public AutocompleteSystem(String[] sentences, int[] times){
    root = new TrieNode1();
    cur = root;
    sb = new StringBuilder();
    for(int i = 0; i < times.length; i++ ){
      add(sentences[i], times[i]);
    }
  }

  public void add(String s, int times) {
    TrieNode1 temp = this.root;
    List<TrieNode1> visited = new ArrayList<>();
    for(char c : s.toCharArray()){
      if(temp.children[c] == null){
        temp.children[c] = new TrieNode1();
      }
      temp = temp.children[c];
      visited.add(temp);
    }
    temp.s = s;
    temp.times += times;

    for(TrieNode1 node : visited){
      node.update(temp);
    }
  }

  public List<String> input(char c){
    List<String> res = new ArrayList<>();
    if(c == '#'){
      cur = root;
      add(this.sb.toString(), 1);
      sb = new StringBuilder();
      return res;
    }

    sb.append(c);
    if(cur != null) {
      cur = cur.children[c];
    }

    if(cur == null) return res;

    for (TrieNode1 node : cur.hot) {
      res.add(node.s);
    }
    return res;
  }

  public static void main(String[] args) {

  }
}
