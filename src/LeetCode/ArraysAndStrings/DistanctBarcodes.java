package LeetCode.ArraysAndStrings;

import java.util.*;

public class DistanctBarcodes{
  class Barcode implements Comparable<Barcode>{
    int code;
    int count;

    Barcode(int code, int count){
      this.code = code;
      this.count = count;
    }

    public int compareTo(Barcode a){
      return a.count - this.count;
    }
  }
  public int[] rearrangeBarcodes(int[] barcodes){
    int[] res = new int[barcodes.length];
    if(barcodes.length == 1) return barcodes;

    HashMap<Integer, Barcode> map = new HashMap<>();
    for(int b : barcodes){
      if(map.containsKey(b)) map.get(b).count++;
      else map.put(b, new Barcode(b, 1));
    }

    List<Barcode> list = new ArrayList<Barcode>(map.values());
    Collections.sort(list);

    int index = 0;
    while(list.get(1).count > 0){
      Barcode b1 = list.get(0);
      Barcode b2 = list.get(1);

      res[index++] = b1.code;
      res[index++] = b2.code;

      b1.count--; b2.count--;
      Collections.sort(list);
    }

    if(list.get(0).count!=0) res[index] = list.get(0).code;

    return res;
  }

  public int[] rearrangeBarcodesII(int[] barcodes){
    int[] res = new int[barcodes.length];
    if(barcodes.length == 1) return barcodes;

    HashMap<Integer, Integer> map = new HashMap<>();
    for(int b : barcodes) map.put(b, map.getOrDefault(b, 0) +1);

    PriorityQueue<Integer> q = new PriorityQueue<>((a,b)-> map.get(b) - map.get(a));
    for(Integer b : map.keySet()) q.add(b);

    int index = 0;
    while (!q.isEmpty()){
      Integer i = q.poll();
      int count = map.get(i);
      while(count > 0){
        res[index] = i;
        index = index+2;
        if(index >= barcodes.length) index = 1;
        count--;
      }
    }
    return res;
  }

  public int[] rearrangeBarcodesIII(int[] barcodes){
    int[] res = new int[barcodes.length];
    if(barcodes.length == 1) return barcodes;

    HashMap<Integer, Integer> map = new HashMap<>();
    for(int b : barcodes) map.put(b, map.getOrDefault(b, 0) +1);

    PriorityQueue<Barcode> q = new PriorityQueue<>((a,b)-> b.count - a.count);
    for(Integer b : map.keySet()) q.add(new Barcode(b, map.get(b)));

    int index = 0;
    while (!q.isEmpty()){
      Barcode i = q.poll();
      Barcode j = q.poll();

      if(i != null){
        res[index++] = i.code;
        if(--i.count > 0) q.add(i);
      }

      if(j != null){
        res[index++] = j.code;
        if(--j.count > 0) q.add(j);
      }
    }
    return res;
  }

  public static void main(String[] args){
    int[] barcodes = {1,1,1,2,2,3,3};
    DistanctBarcodes d = new DistanctBarcodes();
//    int[] res = d.rearrangeBarcodes(barcodes);
//    int[] res = d.rearrangeBarcodesII(barcodes);
    int[] res = d.rearrangeBarcodesIII(barcodes);
    for(int i = 0; i < res.length; i++){
      System.out.print(res[i]);
      System.out.print('\t');
    }
  }
}
