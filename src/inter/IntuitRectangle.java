package inter;

import java.util.ArrayList;

/**
 * Created by joetomjob on 3/7/18.
 */
public class IntuitRectangle {
    public ArrayList<Integer> rectangle(ArrayList<ArrayList<Integer>> inp) {
        ArrayList<Integer> res = new ArrayList<>();
        int m = inp.size();
        int n = inp.get(0).size();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cntrow = i; int cntcol = j;
                if(inp.get(i).get(j) == 1){
                    res.add(i);res.add(j);
                    while (inp.get(cntrow).get(j) != 0 && cntrow<m){
                        if(cntrow == m-1){
                            break;
                        }
                        else
                            cntrow++;
                    }
                    res.add(cntrow);
                    while (inp.get(i).get(cntcol) != 0 && cntcol<n){
                        if(cntcol == n-1){
                            break;
                        }
                        else
                            cntcol++;
                    }
                    res.add(cntcol);
                    return res;
                }

            }
        }

        return res;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> inp = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(0);
        a.add(0);
        a.add(0);
        a.add(0);
        inp.add(a);
        ArrayList<Integer> b = new ArrayList<>();
        b.add(0);
        b.add(1);
        b.add(1);
        b.add(0);
        inp.add(b);
        ArrayList<Integer> c = new ArrayList<>();
        c.add(0);
        c.add(1);
        c.add(1);
        c.add(0);
        inp.add(c);

        IntuitRectangle I = new IntuitRectangle();
        ArrayList<Integer> r = I.rectangle(inp);


    }
}
