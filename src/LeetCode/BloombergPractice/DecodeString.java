package LeetCode.BloombergPractice;

import java.util.Stack;

public class DecodeString {
  public String decodeString(String s) {
    int n = s.length();
    Stack<Integer>  nums = new Stack<>();
    Stack<String> strings = new Stack<>();
    StringBuilder sb = new StringBuilder();
    int num = 0;

    for(int i = 0; i < n; i++){
      if(Character.isDigit(s.charAt(i))){
        num = (num * 10) + (s.charAt(i) - '0');
      } else if(s.charAt(i) == '['){
        nums.push(num);
        num = 0;
        strings.push(sb.toString());
        sb = new StringBuilder();
      } else if(s.charAt(i) == ']'){
        int count = nums.pop();
        StringBuilder sbb = new StringBuilder(strings.pop());
        for (int j = 0; j < count; j++) {
          sbb.append(sb.toString());
        }
        sb = sbb;
      } else{
        sb.append(s.charAt(i));
      }
    }
    return sb.toString();
  }
  public static void main(String[] args){
    String s = "3[a2[c]]";
  }
}
