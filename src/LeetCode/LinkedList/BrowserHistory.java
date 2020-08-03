package LeetCode.LinkedList;

import java.util.Deque;
import java.util.LinkedList;

class BNode {
  String val;
  BNode next;
  BNode prev;

  BNode(String val){
    this.val = val;
  }
}
public class BrowserHistory {

  BNode cur;
  BNode head;
  public BrowserHistory(String homepage){
    head = new BNode(homepage);
    cur = head;
  }

  public void visit(String url){
    BNode temp = cur != null ? cur.next : null;
    if(temp != null) temp.prev = null;

    BNode newNode = new BNode(url);
    newNode.prev = cur;
    cur.next = newNode;
    cur = newNode;

  }

  public String back(int steps){
    int count = 0;
    while (cur.prev != null && count < steps){
      cur = cur.prev;
      count++;
    }
    return cur.val;
  }

  public String forward(int steps){
    int count = 0;
    while (cur.next != null && count < steps){
      cur = cur.next;
      count++;
    }
    return cur.val;
  }

  public static void main(String[] args){
    BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
    browserHistory.visit("google.com");
    browserHistory.visit("facebook.com");
    browserHistory.visit("youtube.com");
    System.out.println(browserHistory.back(1));
    System.out.println(browserHistory.back(1));
    System.out.println(browserHistory.forward(1));
    browserHistory.visit("linkedin.com");
    System.out.println(browserHistory.forward(2));
    System.out.println(browserHistory.back(2));
    System.out.println(browserHistory.back(7));
  }
}
