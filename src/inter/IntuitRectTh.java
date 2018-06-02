package inter;
import java.util.*;
/**
 * Created by joetomjob on 3/9/18.
 */
public class IntuitRectTh {
    public ArrayList<ArrayList<Integer>> getRectangles(ArrayList<ArrayList<Integer>> inp){
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int m = inp.size();
        int n = inp.get(0).size();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(inp.get(i).get(j)== 0){
                    ArrayList<Integer> entry = new ArrayList<>();
                    entry.add(i); entry.add(j);
                    int cntrow = i; int cntcol = j;
                    while(cntrow+1 < m){
                        if(inp.get(cntrow+1).get(j) == 0){
                            cntrow = cntrow+1;
                        }
                        else{
                            break;
                        }
                    }
                    while(cntcol+1 < n){
                        if(inp.get(i).get(cntcol+1) == 0){
                            cntcol = cntcol+1;
                        }
                        else{
                            break;
                        }
                    }

                    for(int k = i; k<= cntrow;k++){
                        for(int l=j; l<= cntcol;l++){
                            inp.get(k).set(l,1);
                        }
                    }

                    entry.add(cntrow); entry.add(cntcol);
                    res.add(entry);
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> inp = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(1);
        a.add(1);
        a.add(1);
        a.add(1);
        a.add(1);
        a.add(1);
        inp.add(a);
        ArrayList<Integer> b = new ArrayList<>();
        b.add(1);
        b.add(1);
        b.add(1);
        b.add(1);
        b.add(1);
        b.add(1);
        b.add(1);
        inp.add(b);
        ArrayList<Integer> c = new ArrayList<>();
        c.add(1);
        c.add(1);
        c.add(1);
        c.add(0);
        c.add(0);
        c.add(0);
        c.add(1);
        inp.add(c);
        ArrayList<Integer> d = new ArrayList<>();
        d.add(1);
        d.add(0);
        d.add(1);
        d.add(0);
        d.add(0);
        d.add(0);
        d.add(1);
        inp.add(d);
        ArrayList<Integer> e = new ArrayList<>();
        e.add(1);
        e.add(0);
        e.add(1);
        e.add(1);
        e.add(1);
        e.add(1);
        e.add(1);
        inp.add(e);
        ArrayList<Integer> f = new ArrayList<>();
        f.add(1);
        f.add(0);
        f.add(1);
        f.add(0);
        f.add(0);
        f.add(1);
        f.add(1);
        inp.add(f);
        ArrayList<Integer> g = new ArrayList<>();
        g.add(1);
        g.add(0);
        g.add(1);
        g.add(0);
        g.add(0);
        g.add(1);
        g.add(1);
        inp.add(g);
        ArrayList<Integer> h = new ArrayList<>();
        h.add(1);
        h.add(0);
        h.add(1);
        h.add(1);
        h.add(1);
        h.add(1);
        h.add(1);
        inp.add(h);


        IntuitRectTh I = new IntuitRectTh();
        ArrayList<ArrayList<Integer>> r = I.getRectangles(inp);

        //ip    [[1,1,1,1,1,1,1],
        //       [1,1,1,1,1,1,1],
        //       [1,1,1,0,0,0,1],
        //       [1,0,1,0,0,0,1],
        //       [1,0,1,1,1,1,1],
        //       [1,0,1,0,0,1,1],
        //       [1,0,1,0,0,1,1],
        //       [1,0,1,1,1,1,1]]

        //o/p  [[2,3,3,5],
        //      [3,1,5,1],
        //      [5,3,6,4]]

        for (int i = 0; i < r.size(); i++) {
            for (int j = 0; j < r.get(0).size(); j++) {
                System.out.print(r.get(i).get(j));
                System.out.print("\t");
            }
            System.out.print("\n");
        }
    }
}
