package LeetCode.BloombergPractice;

public class BrowserHistory {
  class BNode {
    String val;
    BNode next;
    BNode prev;

    BNode(){}
    BNode(String val){ this.val = val; }
  }

  BNode head, cur;
  BrowserHistory(String s){
    head = new BNode(s);
    cur = head;
  }
  public void visit(String url){
    BNode temp = cur != null ? cur.next : null;
    if(temp != null) temp.prev = null;

    temp = new BNode(url);
    cur.next = temp;
    temp.prev = cur;
    cur = temp;
  }

  public String back(int steps){
    while(cur.prev != null && steps > 0) {
      cur = cur.prev;
      steps--;
    }
    return cur.val;
  }

  public String forward(int steps){
    while (cur.next != null && steps > 0){
      cur = cur.next;
      steps--;
    }
    return cur.val;
  }
  public static void main(String[] args) {

  }
}
