package inter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
/**
 * Created by joetomjob on 9/2/18.
 */
public class GaneshAmazon {

    List<List<Integer>> nearestXsteakHouses(int totalSteakhouses, List<List<Integer>> allocations, int numSteakhouses) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();

        Comparator<List<Integer>> comparator = new DistanceComparator();
        if(numSteakhouses > 0) {
            PriorityQueue<List<Integer>> queue =
                    new PriorityQueue<List<Integer>>(totalSteakhouses, comparator);
            for (int i = 0; i < totalSteakhouses; i++) {
                queue.add(allocations.get(i));
            }

            for (int i = 0; i < numSteakhouses; i++) {
                res.add(queue.poll());
            }
        }
        return res;

    }

    public class DistanceComparator implements Comparator<List<Integer>>
    {
        @Override
        public int compare(List<Integer> x, List<Integer> y)
        {
            Double d1 = Math.sqrt(Math.pow(x.get(0),2) + Math.pow(x.get(1),2));
            Double d2 = Math.sqrt(Math.pow(y.get(0),2) + Math.pow(y.get(1),2));

            if (d1 < d2)
            {
                return -1;
            }
            if (d1 > d2)
            {
                return 1;
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        GaneshAmazon g = new GaneshAmazon();
        List<List<Integer>> x = new ArrayList<List<Integer>>();
        List<Integer> a1 = new ArrayList<Integer>();
        List<Integer> a2 = new ArrayList<Integer>();
        List<Integer> a3 = new ArrayList<Integer>();
        List<Integer> a4 = new ArrayList<Integer>();
        List<Integer> a5 = new ArrayList<Integer>();
        List<Integer> a6 = new ArrayList<Integer>();

        a1.add(3);a1.add(6);
        a2.add(2);a2.add(4);
        a3.add(5);a3.add(3);
        a4.add(2);a4.add(7);
        a5.add(1);a5.add(8);
        a6.add(7);a6.add(9);

        x.add(a1);
        x.add(a2);
        x.add(a3);
        x.add(a4);
        x.add(a5);
        x.add(a6);


        List<List<Integer>> res = g.nearestXsteakHouses(6,x,3);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i).get(0));
            System.out.print('\t');
            System.out.print(res.get(i).get(1));
            System.out.print('\n');
        }
    }
}
