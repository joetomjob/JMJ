package LeetCode.Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class TrieNode {
  HashMap<Character, TrieNode> children = new HashMap<>();
  String word = null;
  public TrieNode(){}
}

public class WordSearchII {
  List<String> res = new ArrayList<>();
  char[][] brd;
  TrieNode root = new TrieNode();
  int n, m;
  public List<String> findWords(char[][] board, String[] words) {
    // create trie from words
    this.brd = board;
    for (String word : words) {
      TrieNode node = root;
      for (char c : word.toCharArray()) {
        if(!node.children.containsKey(c)){
          node.children.put(c, new TrieNode());
        }
        node = node.children.get(c);
      }
      node.word = word;
    }

    this.n = board.length;
    this.m = board[0].length;

    for(int i = 0; i < this.n; i++){
      for(int j = 0; j < this.m; j++){
        if(this.root.children.containsKey(this.brd[i][j]))
          backtrack(i, j, this.root);
      }
    }
    return this.res;
  }

  public void backtrack(int r, int c, TrieNode parent){
    char ch = this.brd[r][c];
    TrieNode curNode = parent.children.get(ch);

    if(curNode.word != null){
      this.res.add(curNode.word);
      curNode.word = null;
    }

    int[] roff = {0, 1, 0, -1};
    int[] coff = {1, 0, -1, 0};

    //mark current letter before exploration
    this.brd[r][c] = '#';

    for(int i = 0; i < 4; i++){
      int newr = r + roff[i];
      int newc = c + coff[i];

      if(newr < 0 || newc < 0 || newr >= this.n || newc >= this.m){
        continue;
      }
      char curC =  this.brd[newr][newc];
      if(curNode.children.containsKey(curC))
        backtrack(newr, newc, curNode);
    }
    this.brd[r][c] = ch;

    if(curNode.children == null)
      parent.children.remove(ch);
  }

  public static void main(String[] args) {
    char[][] bd = {{'o','a','a','n'}, {'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
    String[] words = {"oath","pea","eat","rain"};
    WordSearchII w = new WordSearchII();
    List<String> res = w.findWords(bd, words);
    for (String s : res) {
      System.out.println(s);
    }
  }
}
