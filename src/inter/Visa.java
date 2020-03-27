package inter;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'findSchedules' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER workHours
     *  2. INTEGER dayHours
     *  3. STRING pattern
     */

    public static List<String> findSchedules(int workHours, int dayHours, String pattern) {
        // Write your code here
        ArrayList<String> res = new ArrayList<>();
        int sum = 0;
        int rem = 0;
        for(char c:pattern.toCharArray()){
            if(c != '?')
                sum += (int)c;
            else
                rem++;
        }
        int remSum = workHours - sum;
        List<List<Integer>> l = new ArrayList<>();
        int[] cand = {0,1,2,3,4,5,6,7,8};
        //get the combination sum using the function "recursiveCounting"
        recursiveCounting(l,new ArrayList<>(),cand,remSum,0);


        return res;
    }

    private static void recursiveCounting(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
        if (remain < 0)
            return;
        else if (remain == 0)
            list.add(new ArrayList<>(tempList));
        else {
            for (int i = start; i < nums.length; i++) {
                tempList.add(nums[i]);
                recursiveCounting(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }

}

public class Visa {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int workHours = Integer.parseInt(bufferedReader.readLine().trim());

        int dayHours = Integer.parseInt(bufferedReader.readLine().trim());

        String pattern = bufferedReader.readLine();

        List<String> result = Result.findSchedules(workHours, dayHours, pattern);

//        bufferedWriter.write(
//                result.stream()
//                        .collect(joining("\n"))
//                        + "\n"
//        );
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
