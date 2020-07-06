package LeetCode.sortingAndSearching;

public class SortColor {
  public void sortColors(int[] nums) {
    int s = 0, e = nums.length - 1, i=0;
    while (i <= e){
      if(nums[i] == 0) {
        swap(nums, i, s);
        s++;
      } else if(nums[i] == 2) {
        swap(nums, i, e);
        e--;
      } else {
        i++;
      }
    }
  }

  public void swap(int[] nums, int s, int e) {
    int temp = nums[s];
    nums[s] = nums[e];
    nums[e] = temp;
  }

  public static void main(String[] args) {
    int[] inp = {2,0,2,1,1,0};
    SortColor s = new SortColor();
    s.sortColors(inp);
    for (int i = 0; i < inp.length; i++) {
      System.out.print(inp[i]);
      System.out.print('\t');
    }
  }
}
