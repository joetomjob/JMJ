package LeetCode.Trees;
class TrieNode {
  final int R = 26;
  boolean isEnd = false;

  TrieNode[] links;

  public TrieNode(){
    links = new TrieNode[R];
  }

  public boolean containsKey(char c) {
    return this.links[c - 'a'] != null;
  }

  public TrieNode get(char c){
    return this.links[c - 'a'];
  }

  public void put(char c, TrieNode node){
    this.links[c - 'a'] = node;
  }

  public void setEnd(){
    this.isEnd = true;
  }

  public boolean isEnd(){
    return isEnd;
  }
}
public class Trie {
  TrieNode root;

  public Trie(){
    root = new TrieNode();
  }

  public void insert(String s){
    int n = s.length();
    TrieNode node = root;
    for(int i = 0; i < n; i++){
      char c = s.charAt(i);
      if(!node.containsKey(c)) {
        node.put(c, new TrieNode());
      }
      node = node.get(c);
    }
    node.setEnd();
  }

  public boolean search(String word){
    TrieNode node = searchPrefix(word);
    return node != null && node.isEnd();
  }

  public TrieNode searchPrefix(String word){
    int n = word.length();
    TrieNode node = root;

    for(int i = 0; i < n; i++){
      char c = word.charAt(i);
      if(node.containsKey(c)){
        node = node.get(c);
      } else {
        return null;
      }
    }
    return node;
  }

  public boolean startsWith(String word){
    TrieNode node = searchPrefix(word);
    return node != null;
  }
}
