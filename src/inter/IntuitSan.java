package inter;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by joetomjob on 3/6/18.
 */


class URLCount{
    String urlS;
    int count;

    URLCount(String url, int count){
        this.urlS = url;
        this.count = count;
    }
}


public class IntuitSan {
    public Map<String, Integer> theFunction(ArrayList<URLCount> urlList){
        Map<String,Integer> res = new HashMap<>();
        for(URLCount u : urlList){
            int cnt = u.count;
            String[] spltUrl = u.urlS.split("\\.");
            String ur = "";
            for(int i = spltUrl.length-1; i>=0; i--){
                if(spltUrl[i].trim().length() > 0) {
                    if (i == spltUrl.length - 1)
                        ur = spltUrl[i];
                    else
                        ur = spltUrl[i] + "." + ur;

                    if (res.containsKey(ur))
                        res.put(ur, res.get(ur) + cnt);
                    else
                        res.put(ur, cnt);
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<URLCount> inp= new ArrayList<>();
        URLCount u1 = new URLCount ("google.com",50);
        URLCount u2 = new URLCount ("sport.google.com",10);
        URLCount u3 = new URLCount ("mobile.google.com",20);
        URLCount u4 = new URLCount ("nexus.mobile.google.com",30);
        URLCount u5 = new URLCount ("nexus5.nexus.google.com",80);
        URLCount u6 = new URLCount ("yahoo.com",10);
        URLCount u7 = new URLCount (".org",40);
        URLCount u8 = new URLCount ("example.org",70);

        inp.add(u1);
        inp.add(u2);
        inp.add(u3);
        inp.add(u4);
        inp.add(u5);
        inp.add(u6);
        inp.add(u7);
        inp.add(u8);

        Object o = 'c'-'0';
        System.out.print(o);

        String ss = "";
        ss += 'e';

        IntuitSan s = new IntuitSan();
        s.theFunction(inp);
    }
}
