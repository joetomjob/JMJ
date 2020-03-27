package inter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by joetomjob on 8/18/19.
 */
public class amazonJoe {
    public static int minimumTime(int numOfParts, List<Integer> parts)
    {
        if(parts.size() == 0) {
            return 0;
        }
        if(parts.size() == 1) {
            return parts.get(0);
        }
        int sum = 0;
        for (int i = 0; i < parts.size(); i++) {
            int[] small = smallestElement(parts);
            sum += small[0] + small[1];
        }
        return sum;

    }

    static int[] smallestElement(List<Integer> parts) {
        int f = Integer.MAX_VALUE, s = Integer.MAX_VALUE;
        int findex = -1, sindex = -1;
        for (int i = 0; i < parts.size(); i++) {
            if(parts.get(i) < f && parts.get(i) > -1) {
                s = f;
                sindex = findex;
                f = parts.get(i);
                findex = i;
            } else if (parts.get(i) < s && parts.get(i) > -1) {
                s = parts.get(i);
                sindex = i;
            }
        }
        int[] small = new int[2];
        small[0] = f;
        parts.set(findex, f+s);
        if(s < Integer.MAX_VALUE) {
            small[1] = s;
            parts.set(sindex, -1);
        } else {
            small[0] =0;
        }
        return small;
    }

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(8);
        l.add(4);
        l.add(6);
        l.add(12);
//        for (int i = 0; i < l.size(); i++) {
//            System.out.print(l.get(i));
//            System.out.print('\t');
//        }
        int res = minimumTime(l.size(),l);
        System.out.print(res);
//        Collections.sort(l);
//        System.out.print('\n');
//        for (int i = 0; i < l.size(); i++) {
//            System.out.print(l.get(i));
//            System.out.print('\t');
//        }


    }
}
