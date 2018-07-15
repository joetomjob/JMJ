package LeetCode.LeetCode_Easy;

/**
 * Created by joetomjob on 6/30/18.
 */
public class Heap {
    private int[] stuff = new int[100];
    private int sz = 0;

    private void insert(int val){
        stuff[sz] = val;
        int spot = sz;

        while (spot>0 && stuff[spot] < stuff[par(spot)]){
            int temp = stuff[spot];
            stuff[spot] = stuff[par(spot)];
            stuff[par(spot)] = temp;
            spot = par(spot);
        }
        sz++;
    }

    private int delete(){
        int ref = stuff[0];
        sz--;
        stuff[0] = stuff[sz];
        int loc = 0;
        int swaploc = smallest(loc);
        while (loc != swaploc){
            int temp = stuff[loc];
            stuff[loc] = stuff[swaploc];
            stuff[swaploc] = temp;
            loc = swaploc;
            swaploc = smallest(loc);
        }
        return ref;
    }

    private int smallest(int loc){
        int l = 2*loc +1;
        int r = 2*loc +2;

        if(l>sz){
            return loc;
        }
        if(r > sz){
            if(stuff[loc] < stuff[l])
                return loc;
            else
                return l;
        }

        if(stuff[l] < stuff[r]){
            if(stuff[loc]<stuff[l])
                return loc;
            else
                return l;
        }
        else {
            if(stuff[loc]<stuff[r])
                return loc;
            else
                return r;
        }
    }

    private int par(int spot){
        return spot/2;
    }

    private void print(){
        for (int i = 0; i < sz; i++) {
            System.out.print(stuff[i]);
            System.out.print('\t');
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Heap h = new Heap();
        h.insert(5);
        h.insert(2);
        h.insert(3);
        h.insert(9);
        h.insert(1);
        h.insert(7);
        h.insert(4);
        h.print();
        h.delete();
        h.print();
    }

}
