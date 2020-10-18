package LeetCode.Trees;

public class WordDictionary {

  class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean isWord;
  }

  TrieNode head;
  public WordDictionary(){
    head = new TrieNode();
  }

  public void addWord(String word){
    TrieNode temp = head;
    for(char c : word.toCharArray()) {
      if(temp.children[c-'a'] == null) temp.children[c-'a'] = new TrieNode();
      temp = temp.children[c-'a'];
    }
    temp.isWord = true;
  }

  public boolean search(String word) {
    return search(word, head);
  }

  public boolean search(String word, TrieNode node) {
    for(int i = 0; i < word.length(); i++) {
      if(word.charAt(i) == '.' || node.children[word.charAt(i)-'a'] == null) {
        if(word.charAt(i) == '.') {
          for(int j = 0; j < 26; j++) {
            if(node.children[j] != null && search(word.substring(i+1), node.children[j])) {
              return true;
            }
          }
        }
        return false;
      } else {
        node = node.children[word.charAt(i)-'a'];
      }
    }
    return node.isWord;
  }

  public static void main(String[] args){
    WordDictionary wordDictionary = new WordDictionary();
    wordDictionary.addWord("a");
    wordDictionary.addWord("a");
    System.out.println(wordDictionary.search("."));
    System.out.println(wordDictionary.search("aa"));
    System.out.println(wordDictionary.search("a"));
    System.out.println(wordDictionary.search(".a"));
    System.out.println(wordDictionary.search("a."));
  }
}
