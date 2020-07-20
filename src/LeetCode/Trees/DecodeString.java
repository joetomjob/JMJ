package LeetCode.Trees;
import java.util.LinkedList;
import java.util.Stack;

public class DecodeString {
  public String decodeString(String s) {
    int n = s.length();
    StringBuilder tail = new StringBuilder();
    Stack<Integer> nums = new Stack<>();
    Stack<String> strs = new Stack<>();

    for(int i = 0; i < n; i++){
      char c = s.charAt(i);
      if(Character.isDigit(c)){
        int num = c - '0';
        while (i+1 < n && Character.isDigit(s.charAt(i+1))){
          num = num * 10 + (s.charAt(i+1) - '0');
          i++;
        }
        nums.push(num);
      } else if(c == '['){
        strs.push(tail.toString());
        tail = new StringBuilder();
      }else if(c == ']'){
        int count = nums.pop();
        StringBuilder temp = new StringBuilder(strs.pop());
        for (int j = 0; j < count; j++){
          temp.append(tail.toString());
        }
        tail = temp;
      } else {
        tail.append(c);
      }
    }
    return tail.toString();
  }
  public static void main(String[] args){
    DecodeString d = new DecodeString();
    System.out.print(d.decodeString("100[leetcode]"));
  }
}
