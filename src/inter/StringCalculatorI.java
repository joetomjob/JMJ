package inter;
import java.util.*;

/**
 * Created by joetomjob on 3/7/18.
 */
public class StringCalculatorI {
    public int calculate(String s){
        int res = 0;
        int sign = 1;
        int number = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i< s.length(); i++){
            Character c = s.charAt(i);
            if(Character.isDigit(c)){
                number = 10*number+(c-'0');
            }
            else if(c == '+'){
                res += sign*number;
                sign = 1;
                number = 0;
            }
            else if(c == '-'){
                res += sign*number;
                sign = -1;
                number = 0;
            }
            else if(c == '('){
                stack.push(number);
                stack.push(sign);
                sign = 1;
                res = 0;
            }
            else if(c == ')'){
                res += sign*number;
                number = 0;
                res *= stack.pop();
                res += stack.pop();
            }
        }

        if (number != 0){
            res += sign*number;
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "((8+9)+6-2)+2";
        StringCalculatorI SC = new StringCalculatorI();
        int res = SC.calculate(s);
        System.out.println(res);
    }
}
