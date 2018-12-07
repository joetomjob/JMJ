package inter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by joetomjob on 10/6/18.
 */
public class ganeshAmazon3 {
    public static List<List<Integer>> optimalUtilization(int maxTravelDist, List<List<Integer>> forwardRouteList, List<List<Integer>> returnRouteList){

        int ID = 0;
        int DISTANCE = 1;

        int left  =0;
        int right = returnRouteList.size()-1;
        int maxPosDistance = Integer.MIN_VALUE;

        List<List<Integer>> returnList = new ArrayList<>();

        Collections.sort(forwardRouteList, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if( o1.get(DISTANCE) <= o2.get(DISTANCE))
                        return 0;
                else
                    return 1;

            }
        });


        while(left < forwardRouteList.size() && right >= 0) {

            int curDistance = forwardRouteList.get(left).get(DISTANCE)
                    + returnRouteList.get(right).get(DISTANCE);

            if(curDistance >=  maxPosDistance && curDistance <= maxTravelDist){

                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(forwardRouteList.get(left).get(ID));
                    temp.add(returnRouteList.get(right).get(ID));
                    if(curDistance!= maxPosDistance)
                        returnList.clear();
                    returnList.add(temp);
                    maxPosDistance = curDistance;

                   left++;

            }
                else if(curDistance < maxPosDistance){
                left++;
            }
            else{
                    right--;
            }

        }

        System.out.println(forwardRouteList.toString());
        System.out.println(returnRouteList.toString());
        System.out.println(maxTravelDist);
        System.out.println(returnList.toString());
        return returnList;



    }

    public static void main(String[] args) {
        List<List<Integer>> forwardRouteList = new ArrayList<List<Integer>>();
        List<Integer> a = new ArrayList<>();
        a.add(1); a.add(2000);
        List<Integer> b = new ArrayList<>();
        b.add(2); b.add(4000);
        List<Integer> c = new ArrayList<>();
        c.add(3); c.add(6000);
        forwardRouteList.add(a); forwardRouteList.add(b); forwardRouteList.add(c);

        List<List<Integer>> returnRouteList = new ArrayList<List<Integer>>();
        List<Integer> d = new ArrayList<>();
        d.add(1); d.add(2000);
        returnRouteList.add(d);

        int firstmaxTravelDist = 7000;


        List<List<Integer>> forwardRouteList2 = new ArrayList<List<Integer>>();
        List<Integer> e = new ArrayList<>();
        e.add(1); e.add(3000);
        List<Integer> f = new ArrayList<>();
        f.add(2); f.add(5000);
        List<Integer> g = new ArrayList<>();
        g.add(3); g.add(7000);
        List<Integer> h = new ArrayList<>();
        h.add(4); h.add(10000);
        forwardRouteList2.add(e); forwardRouteList2.add(f); forwardRouteList2.add(g); forwardRouteList2.add(h);

        List<List<Integer>> returnRouteList2 = new ArrayList<List<Integer>>();
        List<Integer> i = new ArrayList<>();
        i.add(1); i.add(2000);
        List<Integer> j = new ArrayList<>();
        j.add(2); j.add(3000);
        List<Integer> k = new ArrayList<>();
        k.add(3); k.add(4000);
        List<Integer> l = new ArrayList<>();
        l.add(4); l.add(5000);
        returnRouteList2.add(i);returnRouteList2.add(j);returnRouteList2.add(k);returnRouteList2.add(l);

        int secondmaxTravelDist = 10000;



        optimalUtilization(firstmaxTravelDist, forwardRouteList, returnRouteList);
        optimalUtilization(secondmaxTravelDist, forwardRouteList2,returnRouteList2);

    }
}
