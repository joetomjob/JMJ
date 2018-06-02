package inter;
import java.io.*;
import java.util.*;

/*


1   2   4
 \ /   / \
  3   5   8
   \ / \   \
    6   7   9

Write a function that takes this data as input and returns two collections: one containing all individuals with zero known parents, and one containing all individuals with exactly one known parent.

Sample output (pseudocode):
[
  [1, 2, 4],   // Individuals with zero parents
  [5, 7, 8, 9] // Individuals with exactly one parent
]


# Q2

Write a function that, for two given individuals in our dataset, returns true if and only if they share at least one ancestor.

Sample input and output:
parentChildPairs, 3, 8 => false
parentChildPairs, 5, 8 => true
parentChildPairs, 6, 8 => true

*/

public class IntuitLCA {

    static int[][] parentChildPairs = new int[][] {
            {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7},
            {4, 5}, {4, 8}, {8, 9}
    };

    public boolean commonAncestor(int a, int b){

        HashMap<Integer, ArrayList<Integer>> res = new HashMap<Integer,ArrayList<Integer>>();
        int m = parentChildPairs.length;
        int n = parentChildPairs[0].length;


        for(int i=0;i<m;i++){
            if(res.containsKey(parentChildPairs[i][1])){
                res.get(parentChildPairs[i][1]).add(parentChildPairs[i][0]);
            }
            else{
                ArrayList<Integer> al = new ArrayList<>();
                al.add(parentChildPairs[i][0]);
                res.put(parentChildPairs[i][1],al);
            }

            if(!res.containsKey(parentChildPairs[i][0])){
                ArrayList<Integer> al = new ArrayList<>();
                res.put(parentChildPairs[i][0],al);
            }

        }

        ArrayList<Integer> valA = res.get(a);
        ArrayList<Integer> valA1 = new ArrayList<>(valA);
        ArrayList<Integer> parentsA = getParents(valA1, valA,res);
        ArrayList<Integer> valB = res.get(b);
        ArrayList<Integer> valB1 = new ArrayList<>(valB);
        ArrayList<Integer> parentsB = getParents(valB1, valB,res);

        parentsA.retainAll(parentsB);
        if(parentsA.size() == 0)
            return false;
        else
            return true;

    }

    public ArrayList<Integer> getParents(ArrayList<Integer> p, ArrayList<Integer> parents, HashMap<Integer, ArrayList<Integer>> res){
        for(Integer a : parents){
            p.addAll(res.get(a));
            getParents(p, res.get(a), res);
        }
        return p;
    }


    public ArrayList<ArrayList<Integer>> getParents(int[][] parentChildPairs){
        HashMap<Integer, ArrayList<Integer>> res = new HashMap<Integer,ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int m = parentChildPairs.length;
        int n = parentChildPairs[0].length;


        for(int i=0;i<m;i++){
            if(res.containsKey(parentChildPairs[i][1])){
                res.get(parentChildPairs[i][1]).add(parentChildPairs[i][0]);
            }
            else{
                ArrayList<Integer> al = new ArrayList<>();
                al.add(parentChildPairs[i][0]);
                res.put(parentChildPairs[i][1],al);
            }

            if(!res.containsKey(parentChildPairs[i][0])){
                ArrayList<Integer> al = new ArrayList<>();
                res.put(parentChildPairs[i][0],al);
            }

        }

        ArrayList<Integer> resHelper1 = new ArrayList<>();
        ArrayList<Integer> resHelper2 = new ArrayList<>();
        for(Map.Entry<Integer, ArrayList<Integer>> entry: res.entrySet()){
            if(entry.getValue().size() == 0){
                resHelper1.add(entry.getKey());
            }
            if(entry.getValue().size() == 1){
                resHelper2.add(entry.getKey());
            }
        }

        result.add(resHelper1);
        result.add(resHelper2);

        return result;
    }

    public static void main(String[] args) {

        IntuitLCA s = new IntuitLCA();
        System.out.println(s.getParents(parentChildPairs));

        System.out.print(s.commonAncestor(6,8));

    }
}
