package LeetCode.sortingAndSearching;

public class SearchRange {
  public int[] searchRange(int[] nums, int target) {
    int[] res = {-1, -1};
    int index = binarySearch(nums, 0, nums.length -1 , target);
    if(index != -1) {
      int temp = index;
      while (temp >= 0 && nums[temp] == target) temp--;
      res[0]=++temp;
      temp = index;
      while (temp < nums.length && nums[temp] == target) temp++;
      res[1] = --temp;
    }
    return res;
  }

  public int binarySearch(int[] nums, int l, int r, int target) {
    while (l <= r) {
      int m = (l+r)/2;
      if(nums[m] == target) return m;
      else if(nums[m] > target) return binarySearch(nums, l, m-1, target);
      else return binarySearch(nums, m+1, r, target);
    }
    return -1;
  }

  //second approach - better approach

  public int[] searchRange2(int[] nums, int target) {
    int[] res = {-1, -1};
    int l = extremeIndex(nums, target, true);
    if(l == nums.length || nums[l] != target) {
      return res;
    }
    res[0] = l;
    res[1] = extremeIndex(nums, target, false)-1;
    return res;
  }

  public int extremeIndex(int[] nums, int target, boolean left) {
    int l = 0, r = nums.length;
    while (l < r) {
      int m = (l+r) / 2;
      if(nums[m] > target || (left && nums[m] == target)) {
        r = m;
      } else {
        l = m+1;
      }

    }
    return l;
  }

  public static void main(String[] args) {
    SearchRange s = new SearchRange();
    int[] res = s.searchRange(new int[] {1}, 1);
    for (int i = 0; i < res.length; i++) {
      System.out.print(res[i]);
      System.out.print('\t');
    }

    System.out.print('\n');
    int[] res1 = s.searchRange2(new int[] {1, 2, 5, 5, 5, 9}, 5);
    for (int i = 0; i < res1.length; i++) {
      System.out.print(res1[i]);
      System.out.print('\t');
    }
  }
}
