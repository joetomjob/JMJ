package Codility;

/**
 * Created by joetomjob on 6/25/18.
 */
public class FrogJump {
    public int solution(int X, int Y, int D){
        int distanceToJump = Y-X;
        if(distanceToJump <= 0)
            return 0;
        else if(distanceToJump%D > 0)
            return (distanceToJump/D)+1;
        else
            return distanceToJump/D;

    }
    public static void main(String[] args) {
        FrogJump f = new FrogJump();
        System.out.println(f.solution(10,85,30));
    }
}
