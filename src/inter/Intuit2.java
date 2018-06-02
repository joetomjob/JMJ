package inter;

import java.util.*;

        import java.io.*;
        import java.util.*;
        import java.util.stream.*;


// BEGIN DEFINITIONS
// DO NOT MODIFY THIS SECTION

class EmployeeStats2 {
    public int employees;
    public int employeesWithOutsideFriends;

    public EmployeeStats2(int employees, int employeesWithOutsideFriends) {
        this.employees = employees;
        this.employeesWithOutsideFriends = employeesWithOutsideFriends;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof EmployeeStats2)) {
            return false;
        }
        EmployeeStats2 other = (EmployeeStats2)o;
        return
                employees == other.employees &&
                        employeesWithOutsideFriends == other.employeesWithOutsideFriends;
    }

    @Override
    public int hashCode() {
        return employees ^ employeesWithOutsideFriends;
    }
}

class Helpers2 {

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



class EmployeeModel2{
    public String name;
    public int empId;
    public String dept;

    EmployeeModel2(String name, int empId, String dept){
        this.name = name;
        this.empId = empId;
        this.dept = dept;
    }


}

class FriendModel2{
    public int empId1;
    public int empId2;

    FriendModel2(int empId1, int empId2){
        this.empId1 = empId1;
        this.empId2 = empId2;
    }

}

class Intuit2 {

    public static Map<String, EmployeeStats2> getEmployeeStats2(List<String> employees, List<String> friendships) {
        // IMPLEMENTATION GOES HERE
        Map<String, EmployeeStats2> result = new HashMap<>();

        Map<Integer, ArrayList<Integer>> friendGraph = new HashMap<>();
        for (String x:
             friendships) {
            String[] s = x.split(",");
            if(friendGraph.containsKey(Integer.parseInt(s[0]))){
                friendGraph.get(Integer.parseInt(s[0])).add(Integer.parseInt(s[1]));
            }
            else{
                ArrayList<Integer> a = new ArrayList<>();
                a.add(Integer.parseInt(s[1]));
                friendGraph.put(Integer.parseInt(s[0]),a);
            }

            if(friendGraph.containsKey(Integer.parseInt(s[1]))){
                friendGraph.get(Integer.parseInt(s[1])).add(Integer.parseInt(s[0]));
            }
            else{
                ArrayList<Integer> a = new ArrayList<>();
                a.add(Integer.parseInt(s[0]));
                friendGraph.put(Integer.parseInt(s[1]),a);
            }
        }

        Map<Integer, EmployeeModel2> employeeMap = new HashMap<>();
        Map<String, ArrayList<Integer>> depMap = new HashMap<>();
        for(String employee: employees){
            String[] empDet = employee.split(",");
            EmployeeModel2 emp = new EmployeeModel2(empDet[1], Integer.parseInt(empDet[0]), empDet[2]);
            employeeMap.put(Integer.parseInt(empDet[0]), emp);
            if(result.containsKey(empDet[2])){
                int x = result.get(empDet[2]).employees+1;
                EmployeeStats2 es = new EmployeeStats2(x,0);
                result.put(empDet[2],es);
            }
            else{
                EmployeeStats2 es = new EmployeeStats2(1,0);
                result.put(empDet[2],es);

                ArrayList<Integer> lst = new ArrayList<>();
                lst.add(Integer.parseInt(empDet[0]));
            }

            if(depMap.containsKey(empDet[2])){
                depMap.get(empDet[2]).add(Integer.parseInt(empDet[0]));
            }
            else{
                ArrayList<Integer> ee = new ArrayList<>();
                ee.add(Integer.parseInt(empDet[0]));
                depMap.put(empDet[2], ee);
            }
        }

        for(Map.Entry<String,ArrayList<Integer>> entry : depMap.entrySet()){
            String d = entry.getKey();
            ArrayList<Integer> empl = entry.getValue();
            for (Integer i : empl) {
                ArrayList<Integer> fr = friendGraph.get(i);
                if(fr != null) {
                    for (Integer f : fr) {
                        if (!employeeMap.get(i).dept.equals(employeeMap.get(f).dept)) {
                            EmployeeStats2 e = new EmployeeStats2(result.get(d).employees, ++result.get(d).employeesWithOutsideFriends);
                            result.put(d, e);
                            break;
                        }
                    }
                }
            }
        }

        return  result;
    }


    // START TEST CASES
    //
    // You can add test cases below. Each test case should be an instance of Test
    // constructed with:
    //
    // Test(String name, List<String> employees, List<String> friendships, Map<String, EmployeeStats2> expectedOutput);
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
                    Helpers2.asMap(
                            Helpers2.asPair("Engineering", new EmployeeStats2(3, 2)),
                            Helpers2.asPair("HR", new EmployeeStats2(1, 1)),
                            Helpers2.asPair("Business", new EmployeeStats2(1, 1)),
                            Helpers2.asPair("Directors", new EmployeeStats2(1, 0))
                    )
            )
    );


    // END TEST CASES
    // DO NOT MODIFY BELOW THIS LINE

    private static class Test {

        public String name;
        public List<String> employees;
        public List<String> friendships;
        public Map<String, EmployeeStats2> expectedOutput;

        public Test(String name, List<String> employees, List<String> friendships, Map<String, EmployeeStats2> expectedOutput) {
            this.name = name;
            this.employees = employees;
            this.friendships = friendships;
            this.expectedOutput = expectedOutput;
        }
    }

    private static boolean equalOutputs(Map<String, EmployeeStats2> a, Map<String, EmployeeStats2> b) {
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
                Map<String, EmployeeStats2> actualOutput = getEmployeeStats2(test.employees, test.friendships);
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
