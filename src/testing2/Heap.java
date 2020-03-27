package testing2;

/**
 * Created by joetomjob on 3/19/20.
 */

// Min Heap
public class Heap {
    int[] heap = new int[100];
    int sz = 0;

    public void insert(int x){
        heap[sz] = x;
        int spot = sz;
        while (spot > 0 && heap[spot] < heap[par(spot)]){
            int temp = heap[spot];
            heap[spot] = heap[par(spot)];
            heap[par(spot)] = temp;
            spot = par(spot);
        }
        sz++;
    }

    public int remove(){
        int res = heap[0];
        sz--;
        heap[0] = heap[sz];

        int loc = 0;
        int swaploc = smallest(loc);
        while (loc != swaploc) {
            int temp = heap[loc];
            heap[loc] = heap[swaploc];
            heap[swaploc] = temp;
            loc = swaploc;
            swaploc = smallest(loc);
        }
        return res;
    }

    public int smallest(int index){
        int l = (index*2)+1;
        int r = (index*2)+2;

        if(l > sz) {
            return index;
        }

        if(r > sz) {
            if(heap[index] < heap[l]) {
                return index;
            } else {
                return l;
            }
        }

        if(heap[l] < heap[r]) {
            if(heap[index] < heap[l]) {
                return index;
            } else {
                return l;
            }
        } else {
            if(heap[index] < heap[r]) {
                return index;
            } else {
                return r;
            }
        }
    }

    public int par(int x){
        return (x-1)/2;
    }

    public void printHeap(){
        for (int i = 0; i < sz; i++) {
            System.out.print(heap[i]);
            System.out.print('\t');
        }
        System.out.print('\n');
    }

    public static void main(String[] args) {
        Heap h = new Heap();
        h.insert(7);
        h.insert(4);
        h.insert(5);
        h.insert(8);
        h.printHeap();
        h.remove();
        h.printHeap();
        h.insert(3);
        h.insert(2);
        h.insert(1);
        h.insert(6);
        h.printHeap();
        h.remove();
        h.printHeap();
        h.remove();
        h.printHeap();
    }
}
