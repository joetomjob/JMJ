package inter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by joetomjob on 3/6/18.
 */
public class IntuitRas {

    public ArrayList<String> remainingPeople(ArrayList<String> l){
        ArrayList<String> res = new ArrayList<>();
        HashMap<String,Boolean> m = new HashMap<>();
        for(String s:l){
            String[] status = s.split(" ");

                if(status[1].toLowerCase().equals("enter"))
                    m.put(status[0],true);
                else
                    m.put(status[0],false);

        }
        for(Map.Entry<String, Boolean> entry : m.entrySet()){
            if(entry.getValue() == true){
                res.add(entry.getKey());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<String> s = new ArrayList<>();
        s.add("Joe Enter");
        s.add("Thomas enter");
        s.add("X enter");
        s.add("Thomas exit");
        s.add("Y enter");
        s.add("Y exit");

        IntuitRas i = new IntuitRas();
        System.out.println(i.remainingPeople(s));


    }
}
