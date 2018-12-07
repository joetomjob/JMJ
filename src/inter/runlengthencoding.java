package inter;

/**
 * Created by joetomjob on 10/29/18.
 */
public class runlengthencoding {
    public static String RunLengthEncoding(String input) {
        // Your code goes here
        String compressed = "";

        char ch=input.charAt(0);
        int count=0;
        for (int x = 0; x < input.length(); x++) {
            if (ch == input.charAt(x)){
                count = count + 1;
            } else {
                if(count != 1){
                    compressed = compressed + count;
                }
                compressed = compressed + ch;
                ch = input.charAt(x);
                count = 1;
            }
        }
        if(count != 1){
            compressed = compressed + count;
        }
        compressed = compressed + ch;
        return compressed;
    }

    public static void main(String[] args) {
        runlengthencoding r = new runlengthencoding();
        String s = r.RunLengthEncoding("aaabbcdddd");
        System.out.println(s);

    }
}
