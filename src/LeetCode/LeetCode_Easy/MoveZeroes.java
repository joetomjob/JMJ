package LeetCode.LeetCode_Easy;

/**
 * Created by joetomjob on 6/14/18.
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                nums[cnt] = nums[i];
                cnt++;
            }
        }
        while (cnt<nums.length){
            nums[cnt] = 0;
            cnt++;
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            System.out.print('\t');
        }

    }
    public static void main(String[] args) {
        int[] nums = {9,0,0,0,1,4,0,9};
        MoveZeroes m = new MoveZeroes();
        m.moveZeroes(nums);

    }
}
