package Codility;

/**
 * Created by joetomjob on 6/25/18.
 */
public class BinaryGap {
    public static int solution(int N){
    int maxGap = 0;
    boolean foundFirst = false;
    int zeroCount = 0;

    while (N != 0){
        if((N&1) == 1){
            if(foundFirst == false){
                foundFirst = true;
            } else{
                maxGap = Math.max(zeroCount,maxGap);
            }
            zeroCount = 0;
        } else {
            zeroCount++;
        }
        N >>= 1;
    }
    return maxGap;
    }

    public static void main(String[] args) {
        System.out.println(solution(21));
    }
}
