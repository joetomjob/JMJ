package Codility;

/**
 * Created by joetomjob on 6/25/18.
 */
public class PermMissingElem {
    public int solution(int[] A){
        long len = A.length +1;
        long sum = (len * (len+1)) /2;
        for (int i: A) {
            sum = sum-i;
        }
        return (int)sum;
    }
    public static void main(String[] args) {
        int[] s = {1,2,4,5};
        PermMissingElem p = new PermMissingElem();
        p.solution(s);
    }
}
