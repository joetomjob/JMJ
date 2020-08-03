package LeetCode.ArraysAndStrings;

import java.util.*;

class Transaction{
  String name;
  int time;
  int amount;
  String city;
  String transaction;

  Transaction(String name, String time, String amount, String city, String transaction){
    this.name = name;
    this.time = Integer.parseInt(time);
    this.amount = Integer.parseInt(amount);
    this.city = city;
    this.transaction = transaction;
  }
}
public class InvalidTransactions {
  public List<String> invalidTransactions(String[] transactions){
    HashMap<String, List<Transaction>> map = new HashMap<>();
    Set<String> res = new HashSet<>();

    for (String s : transactions) {
      String[] arr = s.split(",");
      Transaction t = new Transaction(arr[0], arr[1], arr[2], arr[3], s);

      if(t.amount > 1000) {
        res.add(s);
      }

      List<Transaction> other = map.get(t.name);
      if(other == null){
        List<Transaction> newList = new ArrayList<>();
        newList.add(t);
        map.put(t.name, newList);
      } else {
        for (Transaction otherT : other) {
          if(!otherT.city.equals(t.city) && Math.abs(t.time - otherT.time) <= 60){
            res.add(otherT.transaction);
            res.add(t.transaction);
          }
        }
        other.add(t);
      }
    }
    return new ArrayList<>(res);
  }

  public String getKey(String s1, String s2){
    return s1 + "->" + s2;
  }

  public static void main(String[] args){
    InvalidTransactions i = new InvalidTransactions();
    String[] transactions = {"alice,20,800,mtv","alice,50,100,beijing"};
    List<String> res = i.invalidTransactions(transactions);
    for (String s : res) {
      System.out.println(s);
    }
  }
}
