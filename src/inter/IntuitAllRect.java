package inter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
* Question
* coorditates of all rectangles and their area
* largest rectangle. rectangle is formed by 1's
* */
public class IntuitAllRect {

    public static void main(String[] args) {
        char matrix[][] = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(maximalRectangle(matrix));
    }
    public static int maximalRectangle(char[][] matrix) {
        HashMap<String, List<Integer>> lookup = new HashMap<>();
        List<Integer> result;
        if (matrix.length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] left = new int[n], right = new int[n], height = new int[n];
        for (int i = 0; i < n; ++i)
            right[i] = n;
        int maxA = 0;
        for (int i = 0; i < m; ++i) {
            int cur_left = 0, cur_right = n;
            for (int j = 0; j < n; j++) { // compute height (can do this from
                // either side)
                if (matrix[i][j] == '1')
                    height[j]++;
                else
                    height[j] = 0;
            }
            for (int j = 0; j < n; j++) { // compute left (from left to right)
                if (matrix[i][j] == '1')
                    left[j] = Math.max(left[j], cur_left);
                else {
                    left[j] = 0;
                    cur_left = j + 1;
                }
            }
            // compute right (from right to left)
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1')
                    right[j] = Math.min(right[j], cur_right);
                else {
                    right[j] = n;
                    cur_right = j;
                }
            }
            // compute the area of rectangle (can do this from either side)



            for (int j = 0; j < n; j++){
                int leftCoordsX = (i-height[j]+1);
                int leftCoordsY = left[j];
                int rightCoordsX = i;
                int rightCoordsY = right[j] - 1;
                String key = leftCoordsX + " " + leftCoordsY;
                int area = (right[j] - left[j]) * height[j];
                if(area == 0) continue;
                result = new ArrayList<>();
                result.add(leftCoordsX);
                result.add(leftCoordsY);
                result.add(rightCoordsX);
                result.add(rightCoordsY);
                result.add(area);
                if(lookup.containsKey(key)){
                    if(lookup.get(key).get(4) < area){
                        lookup.put(key, result);
                    }
                }
                else{
                    lookup.put(key, result);
                }

//                System.out.println(lookup);
//                System.out.println(result);
//	                System.out.println(i+" "+height[j]+" "+((right[j] - left[j]) * height[j]));
                //System.out.println("left "+left[j]+" right "+right[j]);
//	                System.out.println( i+"   "+(i-height[j]+1)+"  "+left[j]+" "+right[j]);
                maxA = Math.max(maxA, (right[j] - left[j]) * height[j]);
            }

        }
        return maxA;
    }
}
