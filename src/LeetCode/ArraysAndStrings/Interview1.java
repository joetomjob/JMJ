package LeetCode.ArraysAndStrings;

public class Interview1 {
  // Pi+Pj + |i-j| - Pi, Pj - element, i,j - index

  // O(m*n) solution
  public int maximize(int[] a, int[] b){
    int ans = Integer.MIN_VALUE;
    for(int i = 0; i < a.length; i++){
      for(int j = i+1; j < b.length; j++){
        int val = a[i]+a[j]+Math.abs(i-j);
        if(val > ans) ans = val;
      }
    }
    return ans;
  }

  // O(m+n) solution
  // there are 2 cases
  // i > j => then |i - j| =  i - j => Pi + Pj + i - j => (Pi + i) + (Pj - j)
  // i < j => then |i - j| = -i + j => Pi + Pj - i + j => (Pi - i) + (Pj + j)
  // create 4 arrays with: Pi+i, Pi-i, Pj+j and Pj+j.
  // Then get max of Pi+i and Pj-j. Add them. -> (1)
  // Then get max of Pi-i and Pj+j. Add them. -> (2)
  // Find the max among (1) and (2).
  public int maximizeII(int[] a, int[] b){
    int[] a1 = new int[a.length];
    int[] a2 = new int[a.length];
    int[] b1 = new int[b.length];
    int[] b2 = new int[b.length];
    for(int i = 0; i < a.length; i++){
      a1[i] =  a[i]+i;
      a2[i] =  a[i]-i;
    }

    for(int i = 0; i < b.length; i++){
      b1[i] =  b[i]+i;
      b2[i] =  b[i]-i;
    }

    int a1Max = Integer.MIN_VALUE;
    int b1Max = Integer.MIN_VALUE;
    int a2Max = Integer.MIN_VALUE;
    int b2Max = Integer.MIN_VALUE;

    for(int i = 0; i < a.length; i++){
      a1Max = Math.max(a1[i], a1Max);
      a2Max = Math.max(a2[i], a2Max);
    }

    for(int i = 0; i < b.length; i++){
      b1Max = Math.max(b1[i], b1Max);
      b2Max = Math.max(b2[i], b2Max);
    }

    return Math.max(a1Max+b2Max, a2Max+b1Max);
  }


  public static void main(String[] args){
    int[] a = {9, 5,3,5};
    int[] b = {6,2};
    Interview1 i = new Interview1();
    System.out.println(i.maximize(a,b));
    System.out.println(i.maximizeII(a,b));
  }
}
