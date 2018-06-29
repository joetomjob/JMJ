package LeetCode.LeetCode_Easy;

import java.util.HashMap;

/**
 * Created by joetomjob on 6/14/18.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> h = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if(!h.containsKey(target - nums[i])){
                h.put(nums[i],i);
            }
            else{
                result[0] = h.get(target-nums[i]);
                result[1] = i;
                return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        TwoSum t = new TwoSum();
        t.twoSum(nums, 9);
    }
}
