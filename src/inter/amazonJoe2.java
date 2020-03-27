package inter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joetomjob on 8/18/19.
 */

class resClass{
    int sum;
    List<Integer> index;
}
public class amazonJoe2 {
    static List<List<Integer>> optimalUtilization(int maxTravelDist,
                                           List<List<Integer>> forwardRouteList,
                                           List<List<Integer>> returnRouteList)
    {

        if(forwardRouteList.size() == 0 || returnRouteList.size() == 0) {
            new ArrayList<List<Integer>>();
        }

        List<resClass> completeList = new ArrayList<>();
        for (int i = 0; i < forwardRouteList.size(); i++) {
            for (int j = 0; j < returnRouteList.size(); j++) {
                List<Integer> r = new ArrayList<>();
                r.add(i+1);
                r.add(j+1);
                resClass res = new resClass();
                res.sum = forwardRouteList.get(i).get(1) + returnRouteList.get(j).get(1);
                res.index = r;
                completeList.add(res);
            }
        }

        List<resClass> res = new ArrayList<resClass>();
        List<List<Integer>> returnRes = new ArrayList<List<Integer>>();

        resClass smallestRes = new resClass();
        smallestRes = completeList.get(0);
        for (int i = 0; i < completeList.size(); i++) {
            if(completeList.get(i).sum <=  maxTravelDist && completeList.get(i).sum > smallestRes.sum) {
                smallestRes = completeList.get(i);
            }
        }
        res.add(smallestRes);
        if(smallestRes.sum <= maxTravelDist) {
            for (int i = 0; i < completeList.size(); i++) {
                if (completeList.get(i).sum == smallestRes.sum && (completeList.get(i).index.get(0) != smallestRes.index.get(0) && completeList.get(i).index.get(1) != smallestRes.index.get(1))) {
                    res.add(completeList.get(i));
                }
            }
        }

        for (int i = 0; i < res.size(); i++) {
            if(res.get(i).sum <= maxTravelDist) {
                returnRes.add(res.get(i).index);
            }
        }
        return returnRes;
    }

    public static void main(String[] args) {
        int m = 10000;
        List<List<Integer>> l1 = new ArrayList<List<Integer>>();
        List<Integer> a = new ArrayList<>();
        a.add(1); a.add(3000);
        List<Integer> b = new ArrayList<>();
        b.add(2); b.add(5000);
        List<Integer> c = new ArrayList<>();
        c.add(3); c.add(7000);
        List<Integer> d = new ArrayList<>();
        d.add(4); d.add(10000);
        l1.add(a); l1.add(b); l1.add(c); l1.add(d);


        List<List<Integer>> l2 = new ArrayList<List<Integer>>();
        List<Integer> e = new ArrayList<>();
        e.add(1); e.add(2000);
        List<Integer> f = new ArrayList<>();
        f.add(2); f.add(3000);
        List<Integer> g = new ArrayList<>();
        g.add(3); g.add(4000);
        List<Integer> h = new ArrayList<>();
        h.add(4); h.add(5000);
        l2.add(e); l2.add(f); l2.add(g); l2.add(h);

        List<List<Integer>> res = optimalUtilization(m, l1, l2);

        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i).get(0));
            System.out.print('\t');
            System.out.print(res.get(i).get(1));
            System.out.print('\n');
        }
    }
}
