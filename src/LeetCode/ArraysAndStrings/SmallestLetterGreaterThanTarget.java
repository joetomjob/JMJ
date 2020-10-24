package LeetCode.ArraysAndStrings;

public class SmallestLetterGreaterThanTarget {
  public char nextGreatestLetter(char[] letters, char target) {
    char largest = letters[0];
    char smallest = letters[0];
    char res = '{';

    for(char c : letters) {
      if(c > largest) largest = c;
      if(c < smallest) smallest = c;
      if(c > target && c < res) res = c;
    }

    if(res != '{') return res;
    else if(target >= largest) return smallest;
    else return largest;
  }

  // linear scan. Since the elements are sorted, if we see some element greater than target while scanning from left
  // to right, return that element, else return the first element

  public char nextGreatestLetterII(char[] letters, char target) {

    for(char c : letters) {
      if(c > target) return c;
    }

    return letters[0];
  }

  public static void main(String[] args) {
    SmallestLetterGreaterThanTarget s = new SmallestLetterGreaterThanTarget();
    char[] letters1 = {'c', 'f', 'j'};
    char target1 = 'a';
    char target2 = 'c';
    char target3 = 'd';
    char target4 = 'g';
    char target5 = 'j';
    char target6 = 'k';

    System.out.println(s.nextGreatestLetter(letters1, target1));
    System.out.println(s.nextGreatestLetter(letters1, target2));
    System.out.println(s.nextGreatestLetter(letters1, target3));
    System.out.println(s.nextGreatestLetter(letters1, target4));
    System.out.println(s.nextGreatestLetter(letters1, target5));
//    System.out.println(s.nextGreatestLetter(letters1, target6));

  }
}
