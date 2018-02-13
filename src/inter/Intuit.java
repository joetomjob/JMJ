import java.io.*;
import java.util.*;
import java.util.stream.*;


// BEGIN DEFINITIONS
// DO NOT MODIFY THIS SECTION

class EmployeeStats {
    public int employees;
    public int employeesWithOutsideFriends;

    public EmployeeStats(int employees, int employeesWithOutsideFriends) {
        this.employees = employees;
        this.employeesWithOutsideFriends = employeesWithOutsideFriends;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof EmployeeStats)) {
            return false;
        }
        EmployeeStats other = (EmployeeStats)o;
        return
                employees == other.employees &&
                        employeesWithOutsideFriends == other.employeesWithOutsideFriends;
    }

    @Override
    public int hashCode() {
        return employees ^ employeesWithOutsideFriends;
    }
}

class Helpers {

    static class Pair <T1, T2> {
        private T1 first;
        private T2 second;

        public Pair(T1 first, T2 second) {
            this.first = first;
            this.second = second;
        }

        public T1 getFirst() { return first; }
        public T2 getSecond() { return second; }
    }

    @SafeVarargs
    public static <K, V> Map<K, V> asMap(Pair<K, V>... args) {
        Map<K, V> result = new HashMap<>();
        for (Pair<K, V> entry : args) {
            result.put(entry.getFirst(), entry.getSecond());
        }
        return result;
    }

    public static <T1, T2> Pair<T1, T2> asPair(T1 first, T2 second) {
        return new Pair<>(first, second);
    }

}

// END DEFINITIONS



class EmployeeModel{
    public String name;
    public int empId;
    public String dept;

    EmployeeModel(String name, int empId, String dept){
        this.name = name;
        this.empId = empId;
        this.dept = dept;
    }


}

class FriendModel{
    public int empId1;
    public int empId2;

    FriendModel(int empId1, int empId2){
        this.empId1 = empId1;
        this.empId2 = empId2;
    }

}

 class Intuit {

    public static Map<String, EmployeeStats> getEmployeeStats(List<String> employees, List<String> friendships) {
        // IMPLEMENTATION GOES HERE

        Map<String, EmployeeStats> result = new HashMap<>();

        Map<String, List<EmployeeModel>> adjacencyList = new HashMap<>();
        Set<String> departments = new HashSet<>();

        Map<Integer, EmployeeModel> empList = new HashMap<>();
        for(String s1 : employees){
            String [] employee = s1.split(" ");
            for(String s: employee){
                String arr[] = s.split(",");
                departments.add(arr[2]);
                if(!empList.containsKey(Integer.parseInt(arr[0]))){
                    empList.put(Integer.parseInt(arr[0]), new EmployeeModel(arr[1], Integer.parseInt(arr[0]), arr[2]));
                }
            }
        }

        // System.out.println(departments);

        Map<Integer, ArrayList<Integer>> friendList = new HashMap<>();

        for(String s2 : friendships){
            String [] friends = s2.split(" ");
            for(String s: friends){
                String arr[] = s.split(",");
                if(!friendList.containsKey(Integer.parseInt(arr[0]))){
                    ArrayList<Integer> tempArr = new ArrayList<>();
                    tempArr.add(Integer.parseInt(arr[1]));
                    friendList.put(Integer.parseInt(arr[0]), tempArr);
                    if(!friendList.containsKey(Integer.parseInt(arr[1]))){
                        ArrayList<Integer> tempArr1 = new ArrayList<>();
                        tempArr1.add(Integer.parseInt(arr[0]));
                        friendList.put(Integer.parseInt(arr[1]), tempArr1);
                    }
                    else{
                        ArrayList<Integer> tempArr2 = friendList.get(Integer.parseInt(arr[1]));
                        tempArr2.add(Integer.parseInt(arr[0]));
                        friendList.put(Integer.parseInt(arr[1]),tempArr2);
                    }
                }
                else{
                    ArrayList<Integer> tempArr2 = friendList.get(Integer.parseInt(arr[0]));
                    tempArr2.add(Integer.parseInt(arr[1]));
                    friendList.put(Integer.parseInt(arr[0]),tempArr2);

                    if(!friendList.containsKey(Integer.parseInt(arr[1]))){
                        ArrayList<Integer> tempArr1 = new ArrayList<>();
                        tempArr1.add(Integer.parseInt(arr[0]));
                        friendList.put(Integer.parseInt(arr[1]), tempArr1);
                    }
                    else{
                        ArrayList<Integer> tempArr3 = friendList.get(Integer.parseInt(arr[1]));
                        tempArr3.add(Integer.parseInt(arr[0]));
                        friendList.put(Integer.parseInt(arr[1]),tempArr3);
                    }
                }

            }
        }

        // System.out.println(empList);
        System.out.println(friendList);


//     for(EmployeeModel e : empList){
//       System.out.println(e.name + " " + e.empId + " " + e.dept);
//     }

//     for(FriendModel f : friendList){
//       System.out.println(f.empId1 + " " + f.empId2);
//     }

        Map<Integer, ArrayList<Integer>> resHelper = new HashMap<>();



        Map<String, Set<Integer>> resultHelper = new HashMap<>();

        for(String dept : departments){
            if(!resultHelper.containsKey(dept)){
                resultHelper.put(dept, new HashSet<Integer>());
            }
        }


        //iterating throguh the employees List
        for(Map.Entry<Integer, ArrayList<Integer>> entry : friendList.entrySet()){
            String deptName = empList.get(entry.getKey()).dept;
            int val = entry.getKey();
            for(int i : entry.getValue()){
                if(!empList.get(i).dept.equalsIgnoreCase(deptName)){
                    resultHelper.get(deptName).add(val);
                    break;
                }
            }

        }

        System.out.println(resultHelper);


        Map<String, Integer> resultHelper2 = new HashMap<>();
        for(String dept : departments){
            if(!resultHelper2.containsKey(dept)){
                resultHelper2.put(dept, 0);
            }
        }

        for(Map.Entry<Integer, EmployeeModel> entry2 : empList.entrySet()){
            if(empList.containsKey(entry2.getKey())){
                if(resultHelper2.containsKey(entry2.getValue().dept)){
                    int val = resultHelper2.get(entry2.getValue().dept);
                    resultHelper2.put(entry2.getValue().dept, ++val);
                }
            }
        }

        for(String dept : departments){
            if(!result.containsKey(dept)){
                EmployeeStats es = new EmployeeStats(0,0);
                es.employees = resultHelper2.get(dept);
                es.employeesWithOutsideFriends = resultHelper.get(dept).size();
                result.put(dept, es);
            }
        }
        // for(Map.Entry<String, EmployeeStats> entry : result.entrySet()){
        //   System.out.println(entry.getKey() + " " + entry.getValue().employees + " " + entry.getValue().employeesWithOutsideFriends);
        // }

        return result;
    }


    // START TEST CASES
    //
    // You can add test cases below. Each test case should be an instance of Test
    // constructed with:
    //
    // Test(String name, List<String> employees, List<String> friendships, Map<String, EmployeeStats> expectedOutput);
    //


    private static final List<Test> tests = Arrays.asList(
            new Test(
                    // name
                    "sample input",
                    // employees
                    Arrays.asList(
                            "1,Richard,Engineering",
                            "2,Erlich,HR",
                            "3,Monica,Business",
                            "4,Dinesh,Engineering",
                            "6,Carla,Engineering",
                            "9,Laurie,Directors"
                    ),
                    // friendships
                    Arrays.asList(
                            "1,2",
                            "1,3",
                            "1,6",
                            "2,4"
                    ),
                    // expected output
                    Helpers.asMap(
                            Helpers.asPair("Engineering", new EmployeeStats(3, 2)),
                            Helpers.asPair("HR", new EmployeeStats(1, 1)),
                            Helpers.asPair("Business", new EmployeeStats(1, 1)),
                            Helpers.asPair("Directors", new EmployeeStats(1, 0))
                    )
            )
    );


    // END TEST CASES
    // DO NOT MODIFY BELOW THIS LINE

    private static class Test {

        public String name;
        public List<String> employees;
        public List<String> friendships;
        public Map<String, EmployeeStats> expectedOutput;

        public Test(String name, List<String> employees, List<String> friendships, Map<String, EmployeeStats> expectedOutput) {
            this.name = name;
            this.employees = employees;
            this.friendships = friendships;
            this.expectedOutput = expectedOutput;
        }
    }

    private static boolean equalOutputs(Map<String, EmployeeStats> a, Map<String, EmployeeStats> b) {
        if (a == null || b == null) {
            return false;
        }
        return a.equals(b);
    }

    public static void main(String[] args) {
        int passed = 0;
        for (Test test : tests) {
            try {
                System.out.printf("==> Testing %s...\n", test.name);
                Map<String, EmployeeStats> actualOutput = getEmployeeStats(test.employees, test.friendships);
                if (equalOutputs(actualOutput, test.expectedOutput)) {
                    System.out.println("PASS");
                    passed++;
                } else {
                    System.out.println("FAIL");
                }
            } catch (Exception e) {
                System.out.println("FAIL");
                System.out.println(e);
            }
        }
        System.out.printf("==> Passed %d of %d tests\n", passed, tests.size());
    }
}
