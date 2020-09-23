package LeetCode.ArraysAndStrings;

import java.util.*;

public class SubdomainVisitCount {
  public List<String> subdomainVisits(String[] cpdomains){
    List<String> res = new ArrayList<>();
    HashMap<String, Integer> map = new HashMap<>();
    for(String s : cpdomains){
      String[] str = s.split("\\s");
      String[] split = str[1].split("\\.");
      String k = "";
      for(int i = split.length-1; i >= 0; i--){
        k = k == "" ? split[i]+k : split[i]+"."+k;
        map.put(k, map.getOrDefault(k, 0) + Integer.parseInt(str[0]));
      }
    }
    for(Map.Entry<String, Integer> entry : map.entrySet()){
      res.add("" + entry.getValue() + " " + entry.getKey());
    }
    return res;
  }

  public static void main(String[] args){
    String[] str = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
    SubdomainVisitCount s = new SubdomainVisitCount();
    List<String> res = s.subdomainVisits(str);
    for(String r : res) {
      System.out.println(r);
    }
  }
}
