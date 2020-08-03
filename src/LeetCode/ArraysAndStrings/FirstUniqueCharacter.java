package LeetCode.ArraysAndStrings;

public class FirstUniqueCharacter {
  public int firstUniquChar(String s){
    if(s == null || s == "") return -1;

    int[] count = new int[256];
    char[] arr = s.toCharArray();
    for(char c : arr){
      count[c - 'a']++;
    }
    for(int i = 0; i < arr.length; i++){
      if(count[arr[i]-'a'] == 1)
        return i;
    }
    return -1;
  }
  public static void main(String[] args){
    FirstUniqueCharacter f = new FirstUniqueCharacter();
    System.out.println(f.firstUniquChar("loveleetcode"));
  }
}
