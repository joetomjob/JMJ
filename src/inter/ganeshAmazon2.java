package inter;
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
import java.util.List;
        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.PriorityQueue;

// CLASS BEGINS, THIS CLASS IS REQUIRED
public class ganeshAmazon2
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    int removeObstacle(int numRows, int numColumns, List<List<Integer>> lot)
    {
        // WRITE YOUR CODE HERE
        int[] dest = new int[2];
        int[] start = {0,0};
        for(int i=0; i < numRows; i++ ){
            for(int j = 0; j < numColumns; j++){
                if(lot.get(i).get(j) == 9){
                    dest[0] = i;
                    dest[1] = j;
                    break;
                }
            }
        }

        int[][] dist = new int[lot.size()][lot.get(0).size()];
        for(int[] row: dist){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        dist[start[0]][start[1]] = 0;
        dfs(lot, start, dist);
        return dist[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : dist[dest[0]][dest[1]];

    }

    void dfs(List<List<Integer>> lot, int[] start, int[][] distance){
        int[][] dirs = {{0,1}, {0,-1}, {-1,0}, {1,0}};
        for(int[] dir: dirs){
            int x = start[0] + dir[0];
            int y = start[1] + dir[1];
            int count = 0;
            while( x>=0 && y >=0 && x < lot.size() && y < lot.get(0).size() && lot.get(x).get(y) == 0){
                x += dir[0];
                y += dir[1];
                count++;
            }
            if(distance[start[0]][start[1]] + count < distance[x - dir[0]][y-dir[1]]) {
                distance[x - dir[0]][y-dir[1]] = distance[start[0]][start[1]] + count;
                dfs(lot, new int[]{x - dir[0], y-dir[1]}, distance);
            }
        }
    }
    // METHOD SIGNATURE ENDS

    public static void main(String[] args) {
        int r =3 ,c = 3;
        int[][] lot1 = {{1,0,0},{1,0,0},{1,9,1}};

        List<List<Integer>> lot = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        List<Integer> l3 = new ArrayList<>();
        l1.add(1);l1.add(0);l1.add(0);
        l2.add(1);l2.add(0);l2.add(0);
        l3.add(1);l3.add(9);l3.add(1);
        lot.add(l1); lot.add(l2); lot.add(l3);
        ganeshAmazon2 g = new ganeshAmazon2();
        System.out.println(g.removeObstacle(r,c,lot));

    }
}



