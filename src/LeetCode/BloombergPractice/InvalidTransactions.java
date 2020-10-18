package LeetCode.BloombergPractice;

import java.util.*;

public class InvalidTransactions {
  class Transaction{
    String name;
    int time;
    int amount;
    String city;
    String transactionName;

    Transaction(String n, int t, int a, String c, String tn){
      this.name = n;
      this.time = t;
      this.amount = a;
      this.city = c;
      this.transactionName = tn;
    }

  }
  public List<String> invalidTransactions(String[] transactions) {
    HashMap<String, List<Transaction>> map = new HashMap<>();
    Set<String> res = new HashSet<>();

    for(String s : transactions) {
      String[] t = s.split(",");
      Transaction tr = new Transaction(t[0], Integer.parseInt(t[1]), Integer.parseInt(t[2]), t[3], s);

      if(tr.amount > 1000) res.add(tr.transactionName);

      List<Transaction> list = map.get(tr.name);
      if(list == null) {
        list = new ArrayList<>();
        list.add(tr);
        map.put(tr.name, list);
      } else {
        for(Transaction ts : list) {
          if(!tr.city.equals(ts.city) && Math.abs(tr.time - ts.time) <= 60) {
            res.add(tr.transactionName);
            res.add(ts.transactionName);
          }
        }
        list.add(tr);
      }
    }
    return new ArrayList<String>(res);
  }

  public static void main(String[] args) {

  }
}
