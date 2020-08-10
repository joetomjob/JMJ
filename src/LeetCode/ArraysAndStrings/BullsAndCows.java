package LeetCode.ArraysAndStrings;

public class BullsAndCows {
  public String getHint(String secret, String guess){
    int[] map = new int[10];
    for(char c : secret.toCharArray()){
      map[c-'0']++;
    }
    int n = guess.length(), bulls = 0, cows = 0;
    for(int i = 0; i < n; i++){
      char c = guess.charAt(i);
      if(c == secret.charAt(i)) {
        bulls++;
        if(map[c-'0'] <= 0)
          cows--;
      }
      else if(map[c-'0'] > 0)
          cows++;
      map[c-'0']--;
    }
    return Integer.toString(bulls) + "A" + Integer.toString(cows) + "B";
  }
  public static void main(String[] args){
    BullsAndCows b = new BullsAndCows();
    System.out.print(b.getHint("1122", "1222"));
  }
}
