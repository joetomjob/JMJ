package LeetCode.ArraysAndStrings;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] res = new int[m+n];

        for(int i = m-1; i >=0; i--) {
            for(int j = n-1; j >= 0; j--) {
                int p1 = i+j;
                int p2 = i+j+1;

                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + res[p2];

                res[p1] += sum / 10;
                res[p2] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m+n; i++) {
            if(!(sb.length() == 0 && res[i] ==0)) {
                sb.append(res[i]);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
    public static void main(String[] args) {
        MultiplyStrings m = new MultiplyStrings();
        System.out.println(m.multiply("35", "22"));
    }
}
