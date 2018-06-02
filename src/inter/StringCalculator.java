package inter;

import java.util.*;

import java.util.HashMap;

/**
 * Created by joetomjob on 3/7/18.
 */
public class StringCalculator {

    public String infixToPostfix(String string) {
        String res = "";
        HashMap<Character, Integer> h = new HashMap<>();
        h.put('(', 0);
        h.put('-', 1);
        h.put('+', 2);
        h.put('*', 3);
        h.put('/', 4);

        int n = string.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            Character c = string.charAt(i);
            if (c == '(') {
                stack.push('(');
            } else if (Character.isDigit(c)) {
                res += c;
            } else if (c == ')') {
                while (stack.peek() != '(') {
                    res += stack.pop();
                }
                stack.pop();
            } else {
                if (stack.size() > 0) {
                    while (h.get(stack.peek()) > h.get(c)) {
                        res += stack.pop();
                    }
                }
                stack.push(c);
            }
        }

        while (stack.size()!=0){
            res += stack.pop();
        }

        return res;
    }

    public int postfixCalc(String string){
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i< string.length(); i++){
            char c = string.charAt(i);
            if(Character.isDigit(c)){
                stack.push((int)c - (int)'0');
            }
            else{
                int b = stack.pop();
                int a = stack.pop();

                switch (c){
                    case '+':
                        res = (a+b);
                        break;
                    case '-':
                        res = (a-b);
                        break;
                    case '*':
                        res = (a*b);
                        break;
                    case '/':
                        res = (a/b);
                        break;
                    default:
                        res = res;
                        break;
                }
                stack.push(res);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String s = "((8+9)*6-2)*2";
        StringCalculator SC = new StringCalculator();
        String postFix = SC.infixToPostfix(s);
        int res =  SC.postfixCalc(postFix);
        System.out.println(res);



    }
}
