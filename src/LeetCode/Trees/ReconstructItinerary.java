package LeetCode.Trees;

import java.util.*;

public class ReconstructItinerary {
  HashMap<String, List<String>> map;
  List<String> res;
  int stops;
  public List<String> findItinerary(List<List<String>> tickets){
    map = new HashMap<>();
    res = new ArrayList<>();
    stops = tickets.size()+1;
    // create graph
    for(List<String> list : tickets){
      if(!map.containsKey(list.get(0)))
        map.put(list.get(0), new ArrayList<>());
      map.get(list.get(0)).add(list.get(1));
    }

    for(Map.Entry<String, List<String>> entry : map.entrySet()){
      Collections.sort(entry.getValue());
    }

    dfs("JFK");

    return res;
  }

  public List<String> dfs(String curr) {
    res.add(curr);
    if(res.size() == stops){
      return res;
    }

    if(map.containsKey(curr)) {
      for(String s : map.get(curr)){
        return dfs(s);
      }
    }
    res.remove(res.size()-1);
    return res;
  }

  public static void main(String[] args){
    List<List<String>> tickets = new ArrayList<>();
//    List<String> a = new ArrayList<>(Arrays.asList(new String[] {"MUC","LHR"}));
    List<String> a = new ArrayList<>(Arrays.asList(new String[] {"JFK","KUL"}));
    List<String> b = new ArrayList<>(Arrays.asList(new String[] {"JFK","NRT"}));
    List<String> c = new ArrayList<>(Arrays.asList(new String[] {"NRT","JFK"}));

    tickets.add(a);tickets.add(b);tickets.add(c);

    ReconstructItinerary r = new ReconstructItinerary();
    r.findItinerary(tickets);
  }
}
