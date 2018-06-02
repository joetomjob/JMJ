package inter;

import java.util.*;

/**
 * Created by joetomjob on 3/8/18.
 */


public class IntuitRas2 {

    public ArrayList<String> peopleEnteredinOneHour(ArrayList<String> l) {
        Map<String, ArrayList<Float>> list = new HashMap<>();
        ArrayList<String> res = new ArrayList<>();
        for (String s : l) {
            String[] split = s.split(" ");
            String[] t = split[1].split(":");
            float min = Float.parseFloat(t[1]) / 60;
            float time = Float.parseFloat(t[0]) + min;

            if (list.containsKey(split[0])) {
                list.get(split[0]).add(time);
            } else {
                ArrayList<Float> tm = new ArrayList<>();
                tm.add(time);
                list.put(split[0], tm);
            }
        }

        for (Map.Entry<String, ArrayList<Float>> e : list.entrySet()) {
            Collections.sort(e.getValue());
        }

        for (Map.Entry<String, ArrayList<Float>> e : list.entrySet()) {
            int sz = e.getValue().size();
            ArrayList<Float> val = e.getValue();
            if (sz > 2) {
                for (int i = 0; i+2 < sz; i++) {
                    if(val.get(i+2)-val.get(i) <= 1.0){
                        res.add(e.getKey());
                        break;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<String> s = new ArrayList<>();
        s.add("Joe 10:00");
        s.add("Thomas 11:00");
        s.add("Joe 10:15");
        s.add("Thomas 12:00");
        s.add("Joe 10:45");
        s.add("Thomas 1:00");

        IntuitRas2 i = new IntuitRas2();
        i.peopleEnteredinOneHour(s);


    }
}
