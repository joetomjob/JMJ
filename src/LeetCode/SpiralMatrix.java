package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joetomjob on 2/25/18.
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        if(matrix.length == 0)
            return res;

        int rowBegin = 0, colBegin = 0, rowEnd = m-1, colEnd = n-1;
        while(rowBegin<=rowEnd && colBegin <= colEnd){
            //right
            for(int i=colBegin;i<=colEnd;i++){
                res.add(matrix[rowBegin][i]);
            }
            rowBegin++;

            //bottom
            for (int i = rowBegin; i <= rowEnd; i++) {
                res.add(matrix[i][colEnd]);
            }
            colEnd--;

            //left
            if(rowBegin <= rowEnd) {
                for (int i = colEnd; i >= colBegin; i--) {
                    res.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;

            if(colBegin<=colEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    res.add(matrix[i][colBegin]);
                }
            }
            colBegin++;

        }
        return res;
    }

    public static void main(String[] args) {
        int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};
        SpiralMatrix s = new SpiralMatrix();
        s.spiralOrder(matrix);
    }

}
