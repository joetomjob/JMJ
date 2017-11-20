package ctci;

import java.io.BufferedReader;

        import java.io.InputStreamReader;

        import java.util.ArrayList;

        import java.io.IOException;


class NonDecreasing {
7
        ​
        8
        /**
         9
         * Take a rectangular grid of numbers and find the length
         10
         * of the longest sub-sequence.
         11
         * @return the length as an integer.
        12
         */
        13
    public static int longestSequence(int[][] grid) {
        14
        // TODO: implement this function
        15
        int[][] result = new int[grid.length][grid[0].length];
        16
        int seqLen = 0;
        17
        for(int i = 0;i<grid.length;i++){
            18
            for(int j=0;j<grid[0].length;j++){
                19
                if(i>0 && Math.abs(grid[i-1][j]-grid[i][j])>3){
                    20
                    result[i][j] = Math.max(result[i][j],result[i-1][j]+1);
                    21
                    if(seqLen<result[i][j]){
                        22
                        seqLen = result[i][j];
                        23
                    }
                    24
                }
                25
                if(j>0 && Math.abs(grid[i][j-1]-grid[i][j])>3){
                    26
                    result[i][j] = Math.max(result[i][j],result[i][j-1]+1);
                    27
                    if(seqLen<result[i][j]){
                        28
                        seqLen = result[i][j];
                        29
                    }
                    30
                }
                31
                if(i<grid.length-1 && Math.abs(grid[i][j]-grid[i+1][j])>3){
                    32
                    result[i][j] = Math.max(result[i][j],result[i+1][j]+1);
                    33
                    if(seqLen<result[i][j]){
                        34
                        seqLen = result[i][j];
                        35
                    }
                    36
                }
                37
                if(j<grid[0].length-1 && Math.abs(grid[i][j]-grid[i][j+1])>3){
                    38
                    result[i][j] = Math.max(result[i][j],result[i][j+1]+1);
                    39
                    if(seqLen<result[i][j]){
                        40
                        seqLen = result[i][j];
                        41
                    }
                    42
                }
                43
                if(i>0 && j>0 && Math.abs(grid[i-1][j-1]-grid[i][j])>3){
                    44
                    result[i][j] = Math.max(result[i][j],result[i-1][j-1]+1);
                    45
                    if(seqLen<result[i][j]){
                        46
                        seqLen = result[i][j];
                        47
                    }
                    48
                }
                49
                if(i>0 && j< grid[0].length-1 && Math.abs(grid[i][j]-grid[i-1][j+1])>3){
                    50
                    result[i][j] = Math.max(result[i][j],result[i-1][j+1]+1);
                    51
                    if(seqLen<result[i][j]){
                        52
                        seqLen = result[i][j];
                        53
                    }
                    54
                }
                55
                if(i<grid.length-1 && j>0 && Math.abs(grid[i][j]-grid[i+1][j-1])>3){
                    56
                    result[i][j] = Math.max(result[i][j],result[i+1][j-1]+1);
                    57
                    if(seqLen<result[i][j]){
                        58
                        seqLen = result[i][j];
                        59
                    }
                    60
                }
                61
                if(i<grid.length-1 && j< grid[0].length-1 && Math.abs(grid[i][j]-grid[i+1][j+1])>3){
                    62
                    result[i][j] = Math.max(result[i][j],result[i+1][j+1]+1);
                    63
                    if(seqLen<result[i][j]){
                        64
                        seqLen = result[i][j];
                        65
                    }
                    66
                }
                67
            }
            68
        }
        69

        70
        return seqLen;
        71
    }
72
        ​
        73
    public static void main(String[] args) throws IOException {
        74
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        75
​
        76
        int numRows = 0;
        77
        int numCols = 0;
        78
        String[] firstLine = reader.readLine().split("\\s+");
        79
        numRows = Integer.parseInt(firstLine[0]);
        80
        numCols = Integer.parseInt(firstLine[1]);
        81
​
        82
        int[][] grid = new int[numRows][numCols];
        83
​
        84
        for (int row = 0; row < numRows; row++) {
            85
            String[] inputRow = reader.readLine().split("\\s+");
            86
​
            87
            for (int col = 0; col < numCols; col++) {
                88
                grid[row][col] = Integer.parseInt(inputRow[col]);
                89
            }
            90
        }
        91
        int length = longestSequence(grid);
        92
        System.out.println(length);
        93
    }
94
}
95
        ​