package inter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by joetomjob on 3/8/18.
 */
public class IntuitLongWordsMatch {
    public HashMap<String, String> WordMatch(ArrayList<String> a){
        HashMap<String, String> res = new HashMap<>();
        ArrayList<ArrayList<String>> al= new ArrayList<>();
        for (String s: a){
            String[] sts = s.split(" ");
            ArrayList<String> sublst = new ArrayList<>();
            if(sts.length > 0) {
                for (int i = 0; i < sts.length; i++) {
                    String s2 = "";
                    if(sts[i].trim().length() > 0){
                        s2 = sts[i];
                        sublst.add(s2);
                    }
                    for (int j = i + 1; j < sts.length; j++) {
                        if(sts[i].trim().length() > 0) {
                            s2 = s2+" "+sts[j];
                            sublst.add(s2);
                        }
                    }
                }
            }
            al.add(sublst);

        }
        for(int i = 0; i< al.size(); i++){
            for(int j=i+1; j<al.size(); j++){
                res.put(""+i+j,"");
                String longset = "";
                for(int m=0; m< al.get(i).size(); m++){
                    for(int n=0; n<al.get(j).size();n++){
                        if(al.get(i).get(m).equals(al.get(j).get(n))){
                            if(al.get(i).get(m).length() > longset.length())
                                longset = al.get(i).get(m);
                        }
                    }
                }
                res.put(""+i+j,longset);
            }
        }


        return res;
    }
    public static void main(String[] args) {
        String a1 = "Hi This is Joe";
        String a2 = "is Joe good";
        String a3 = "This is X";

        ArrayList<String> a = new ArrayList<>();
        a.add(a1);
        a.add(a2);
        a.add(a3);

        IntuitLongWordsMatch i = new IntuitLongWordsMatch();
        i.WordMatch(a);

    }
}
