import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by joetomjob on 10/1/18.
 */
public class googlecodejam {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("A-large.in"))){
            String notestcasesS = reader.readLine();
            int nooftestcases = Integer.parseInt(notestcasesS);
            ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

            for (int i = 0; i < nooftestcases; i++) {
                ArrayList<Integer> res1 = new ArrayList<>();
                int noofBus =  Integer.parseInt(reader.readLine());
                String stopsString = reader.readLine();
                String[]  stopsArray = stopsString.split(" ");

                ArrayList<ArrayList<Integer>> busStops = new ArrayList<ArrayList<Integer>>();
                for (int j = 0; j < stopsArray.length; j= j+2) {
                    ArrayList<Integer> eachStop = new ArrayList<>();
                    eachStop.add(Integer.parseInt(stopsArray[j]));
                    eachStop.add(Integer.parseInt(stopsArray[j+1]));
                    busStops.add(eachStop);
                }

                int noofCasesToTest = Integer.parseInt(reader.readLine());
                for (int j = 0; j < noofCasesToTest; j++) {
                    int case1 = Integer.parseInt(reader.readLine());
                    int counter = 0;
                    for (int k = 0; k < busStops.size(); k++) {
                        if(case1 >= busStops.get(k).get(0) && case1 <= busStops.get(k).get(1)){
                            counter++;
                        }
                    }
                    res1.add(counter);
                }
                reader.readLine();
                res.add(res1);
            }
            PrintWriter writer = new PrintWriter("outputFileLarge.txt", "UTF-8");


            for (int i = 0; i < res.size(); i++) {
                ArrayList<Integer> x = res.get(i);
                writer.print("Case #" + (i+1) + ":");
                for (int j = 0; j < res.get(i).size(); j++) {
                    writer.print(" ");
                    writer.print(x.get(j));
                }
                writer.println();
            }
            writer.close();

        }
        catch (Exception ex){
            System.out.print(ex);
        }
    }
}
