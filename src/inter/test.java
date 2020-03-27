package inter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by joetomjob on 9/21/19.
 */

class URLCountTest{
    String urlS;
    int count;

    URLCountTest(String url, int count){
        this.urlS = url;
        this.count = count;
    }
}

public class test {

    static int[][] parentChildPairs = new int[][] {
            {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7},
            {4, 5}, {4, 8}, {8, 9}
    };


    public static ArrayList<String> testFn(ArrayList<String> s, String st) {
        String[] a = st.split(",");
        int start = Integer.parseInt(a[0]);
        int end = Integer.parseInt(a[1]);

        ArrayList<String> res = new ArrayList<>();
        for (String str:s) {
            String[] b = str.split(",");
            int strt = Integer.parseInt(b[0]);
            int ed = Integer.parseInt(b[1]);
            if((start > strt && start < ed) || (end > strt && end < ed) || (start <= strt && end >= ed) || (start >= strt && end <= ed)) {
                res.add(str);
            }

        }
        return res;
    }


    public static ArrayList<ArrayList<Integer>> getParentsTest(int[][] parentChildPairs) {
        HashMap<Integer, ArrayList<Integer>> res = new HashMap<Integer, ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < parentChildPairs.length; i++) {
            if(res.containsKey(parentChildPairs[i][1])) {
                res.get(parentChildPairs[i][1]).add(parentChildPairs[i][0]);
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(parentChildPairs[i][0]);
                res.put(parentChildPairs[i][1], temp);
            }
            if(!res.containsKey(parentChildPairs[i][0])) {
                res.put(parentChildPairs[i][0], new ArrayList<Integer>());
            }
        }

        ArrayList<Integer> zeroParent = new ArrayList<Integer>();
        ArrayList<Integer> oneParent = new ArrayList<Integer>();
        for(Map.Entry<Integer, ArrayList<Integer>> entry: res.entrySet()) {
            if(entry.getValue().size() == 0) {
                zeroParent.add(entry.getKey());
            } else if(entry.getValue().size() == 1) {
                oneParent.add(entry.getKey());
            }
        }

        result.add(zeroParent);
        result.add(oneParent);

        return result;
    }

    public static boolean commonAncestortest(int a, int b) {
        HashMap<Integer, ArrayList<Integer>> res = new HashMap<Integer, ArrayList<Integer>>();

        for (int i = 0; i < parentChildPairs.length; i++) {
            if(res.containsKey(parentChildPairs[i][1])) {
                res.get(parentChildPairs[i][1]).add(parentChildPairs[i][0]);
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(parentChildPairs[i][0]);
                res.put(parentChildPairs[i][1], temp);
            }
            if(!res.containsKey(parentChildPairs[i][0])) {
                res.put(parentChildPairs[i][0], new ArrayList<Integer>());
            }
        }

        ArrayList<Integer> zeroParent = new ArrayList<Integer>();
        ArrayList<Integer> oneParent = new ArrayList<Integer>();
        for(Map.Entry<Integer, ArrayList<Integer>> entry: res.entrySet()) {
            if(entry.getValue().size() == 0) {
                zeroParent.add(entry.getKey());
            } else if(entry.getValue().size() == 1) {
                oneParent.add(entry.getKey());
            }
        }

        ArrayList<Integer> val1 = res.get(a);
        ArrayList<Integer> val1Copy = new ArrayList<>(val1);
        ArrayList<Integer> val2 = res.get(b);
        ArrayList<Integer> val2Copy = new ArrayList<>(val2);

        ArrayList<Integer> p1 = getParent(val1, val1Copy, res);
        ArrayList<Integer> p2 = getParent(val2, val2Copy, res);

        p1.retainAll(p2);

        if(p1.size() > 0){
            return true;
        } else {
            return false;
        }

    }

    public static ArrayList<Integer> getParent(ArrayList<Integer> val, ArrayList<Integer> valparents, HashMap<Integer, ArrayList<Integer>> res) {
        for(Integer a: valparents){
            val.addAll(res.get(a));
            getParent(val, res.get(a), res);
        }
        return val;
    }


    public static HashMap<String, String> WordMatch(ArrayList<String> a){
        ArrayList<ArrayList<String>> al = new ArrayList<ArrayList<String>>();
        for(String ip: a) {
            ArrayList<String> tmpList = new ArrayList<>();
            String[] tmpAr = ip.split(" ");
            if(tmpAr.length > 0) {
                for (int i = 0; i < tmpAr.length; i++) {
                    if(tmpAr[i].trim().length() > 0){
                        String tempStr = "";
                        tempStr = tmpAr[i];
                        tmpList.add(tempStr);

                        for (int j = i+1; j < tmpAr.length; j++) {
                            if(tmpAr[j].trim().length() > 0) {
                                tempStr += " " + tmpAr[j];
                                tmpList.add(tempStr);
                            }
                        }
                    }
                }
            }
            al.add(tmpList);
        }

        HashMap<String, String> result = new HashMap<String, String>();
        for (int i = 0; i < al.size(); i++) {
            for (int j = i+1; j < al.size(); j++) {
                result.put(""+i+j, "");
                String longest = "";

                for (int k = 0; k < al.get(i).size(); k++) {
                    for (int l = 0; l < al.get(j).size(); l++) {
                        if(al.get(i).get(k).equals(al.get(j).get(l))) {
                            if(al.get(i).get(k).length() > longest.length()) {
                                longest = al.get(i).get(k);
                            }
                        }
                    }

                }
                result.put(""+i+j, longest);
            }
        }

        return result;

    }


    public static ArrayList<String> remainingPeople(ArrayList<String> l){
        ArrayList<String> result = new ArrayList<String>();
        HashMap<String, Boolean> h = new HashMap<String, Boolean>();

        for(String s: l) {
            String[] temp = s.split(" ");
            if(temp[1].toLowerCase().equals("enter")){
                h.put(temp[0], true);
            } else {
                h.put(temp[0], false);
            }
        }

        for(Map.Entry<String, Boolean> entry : h.entrySet()){
            if(entry.getValue()) {
                result.add(entry.getKey());
            }
        }
        return result;
    }


    public static ArrayList<String> peopleEnteredinOneHour(ArrayList<String> l){
        ArrayList<String> result = new ArrayList<String>();
        HashMap<String, ArrayList<Float>> h = new HashMap<String, ArrayList<Float>>();

        for(String s: l) {
            String[] temp = s.split(" ");
            String[] tmpTime = temp[1].split(":");
            int hr = Integer.parseInt(tmpTime[0]);
            int mnt = Integer.parseInt(tmpTime[1]);
            float mn = mnt/60;
            float tm = hr + mn;

            if(h.containsKey(temp[0])) {
                h.get(temp[0]).add(tm);
            } else {
                ArrayList<Float> f = new ArrayList<>();
                f.add(tm);
                h.put(temp[0], f);
            }
        }

        for(Map.Entry<String, ArrayList<Float>> entry: h.entrySet()) {
            Collections.sort(entry.getValue());
        }

        for(Map.Entry<String, ArrayList<Float>> entry: h.entrySet()) {
            int sz = entry.getValue().size();
            if(sz > 2) {
                for (int i = 2; i < sz; i++) {
                    if(entry.getValue().get(i) - entry.getValue().get(i-2) < 1) {
                        result.add(entry.getKey());
                        break;
                    }
                }
            }
        }


        return result;
    }

    public static Map<String, Integer> getURLCount(ArrayList<URLCountTest> urlList){
        Map<String, Integer> result = new HashMap<>();
        for(URLCountTest u : urlList) {
            String[] strings = u.urlS.split("\\.");
            String temp = "";
            for(int i = strings.length - 1; i >= 0; i--) {
                if (strings[i].length() > 0) {
                    if (temp == "") {
                        temp = strings[i];
                    } else {
                        temp = strings[i] + "." + temp;
                    }

                    if (result.containsKey(temp)) {
                        int val = result.get(temp);
                        result.put(temp, val + u.count);
                    } else {
                        result.put(temp, u.count);
                    }
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
//        ArrayList<String> s = new ArrayList<>();
//        s.add("2,7");
//        s.add("9,12");
//        s.add("3,9");
//        s.add("12,19");
//
//        testFn(s,"7,10");
//
//        /*-----------------------------------------------------*/
//        System.out.println(getParentsTest(parentChildPairs));
//        System.out.print(commonAncestortest(6,8));
//
//        /*-----------------------------------------------------*/
//
//        String a1 = "Hi This is Joe";
//        String a2 = "is Joe good";
//        String a3 = "This is X";
//
//        ArrayList<String> a = new ArrayList<>();
//        a.add(a1);
//        a.add(a2);
//        a.add(a3);
//
//        WordMatch(a);
//        /*-----------------------------------------------------*/
//
//        ArrayList<String> s1 = new ArrayList<>();
//        s1.add("Joe Enter");
//        s1.add("Thomas enter");
//        s1.add("X enter");
//        s1.add("Thomas exit");
//        s1.add("Y enter");
//        s1.add("Y exit");
//
//        System.out.println(remainingPeople(s1));
//
//        /*-----------------------------------------------------*/
//        ArrayList<String> s2 = new ArrayList<>();
//        s2.add("Joe 10:00");
//        s2.add("Thomas 11:00");
//        s2.add("Joe 10:15");
//        s2.add("Thomas 12:00");
//        s2.add("Joe 10:45");
//        s2.add("Thomas 1:00");
//
//        peopleEnteredinOneHour(s2);


        /*-----------------------------------------------------*/
        ArrayList<URLCountTest> inp= new ArrayList<>();
        URLCountTest u1 = new URLCountTest ("google.com",50);
        URLCountTest u2 = new URLCountTest ("sport.google.com",10);
        URLCountTest u3 = new URLCountTest ("mobile.google.com",20);
        URLCountTest u4 = new URLCountTest ("nexus.mobile.google.com",30);
        URLCountTest u5 = new URLCountTest ("nexus5.nexus.google.com",80);
        URLCountTest u6 = new URLCountTest ("yahoo.com",10);
        URLCountTest u7 = new URLCountTest (".org",40);
        URLCountTest u8 = new URLCountTest ("example.org",70);

        inp.add(u1);
        inp.add(u2);
        inp.add(u3);
        inp.add(u4);
        inp.add(u5);
        inp.add(u6);
        inp.add(u7);
        inp.add(u8);


        Map<String, Integer> h =  getURLCount(inp);
        for(Map.Entry<String, Integer> e: h.entrySet()) {
            System.out.print(e.getKey());
            System.out.print(": ");
            System.out.print(e.getValue());
            System.out.println();
        }
    }
}
