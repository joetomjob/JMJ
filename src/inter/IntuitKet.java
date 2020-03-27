package inter;

import java.util.ArrayList;

/**
 * Created by joetomjob on 3/6/18.
 * given a pair. find the which of the given pairs intersect with that pair
 */


public class IntuitKet {
    public ArrayList<String> intersection(ArrayList<String> st, String inv){
        ArrayList<String> res = new ArrayList<>();
        String[] intl = inv.split(",");
        int start = Integer.parseInt(intl[0]);
        int end = Integer.parseInt(intl[1]);
        for(String s:st){
            String[] interval = s.split(",");
            int strt = Integer.parseInt(interval[0]);
            int ed = Integer.parseInt(interval[1]);
            if((start>strt && start < ed) || (end<ed && end>strt) || (start < strt && end > ed) || (start>strt&&end<ed)){
                res.add(s);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        ArrayList<String> s = new ArrayList<>();
        s.add("2,7");
        s.add("9,12");
        s.add("3,9");
        s.add("12,19");

        IntuitKet i = new IntuitKet();
        i.intersection(s,"7,10");


    }
}
