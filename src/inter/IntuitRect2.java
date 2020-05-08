package inter;

import java.util.ArrayList;

/**
 * Created by joetomjob on 3/8/18.
 */
class Vertex{
    int x;
    int y;

    Vertex(){}

    Vertex(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class RectCoordinates{
    Vertex start;
    Vertex end;

    RectCoordinates(){}
    RectCoordinates(Vertex start, Vertex end){
        this.start = start;
        this.end = end;
    }
}

public class IntuitRect2 {
    public ArrayList<RectCoordinates> allRectangles(ArrayList<ArrayList<Integer>> inp){
        ArrayList<RectCoordinates> res = new ArrayList<>();
        int m = inp.size();
        int n = inp.get(0).size();

        for(int i=0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(inp.get(i).get(j) == 1){
//                    Vertex start = new Vertex(i,j);
//                    Vertex end = new Vertex(i,j);
                    RectCoordinates r = new RectCoordinates(new Vertex(i,j), new Vertex(i,j));
                    res.add(r);

                    int cntrow = i+1;
                    int cntcol = j+1;

                    while (cntrow<m){
                        if(inp.get(cntrow).get(j) == 1){
                            res.add(new RectCoordinates(new Vertex(i,j), new Vertex(cntrow,j)));
                            cntrow++;
                        }else{
                            break;
                        }
                    }

                    while (cntcol<n){
                        if(inp.get(i).get(cntcol) == 1){
                            res.add(new RectCoordinates(new Vertex(i,j), new Vertex(i,cntcol)));
                            cntcol++;

                            if(inp.get(cntrow-1).get(cntcol) == 1 && cntrow-1 != i){
                                res.add(new RectCoordinates(new Vertex(i,j), new Vertex(cntrow-1,cntcol)));
                            }
                        }else{
                            break;
                        }
                    }




                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> inp = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(0);
        a.add(1);
        a.add(1);
        a.add(0);
        inp.add(a);
        ArrayList<Integer> b = new ArrayList<>();
        b.add(0);
        b.add(1);
        b.add(1);
        b.add(1);
        inp.add(b);
        ArrayList<Integer> c = new ArrayList<>();
        c.add(0);
        c.add(0);
        c.add(1);
        c.add(1);
        inp.add(c);

        IntuitRect2 I = new IntuitRect2();
        ArrayList<RectCoordinates> r = I.allRectangles(inp);

    }
}
