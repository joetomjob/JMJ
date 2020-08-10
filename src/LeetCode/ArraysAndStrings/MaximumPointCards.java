package LeetCode.ArraysAndStrings;

public class MaximumPointCards {
  public int maxScore(int[] cardPoints, int k){
    if(cardPoints == null || cardPoints.length == 0) return 0;

    int tot = 0, min = 0;
    for(int i = 0; i < cardPoints.length; i++){
      tot += cardPoints[i];
    }

    for(int i = 0; i < cardPoints.length - k; i++){
      min += cardPoints[i];
    }
    int temp = min;
    for(int i = cardPoints.length-k; i < cardPoints.length;i++){
      temp += cardPoints[i] - cardPoints[i - (cardPoints.length - k)];
      min = Math.min(min, temp);
    }
    return tot - min;
  }

  public static void main(String[] args){
    MaximumPointCards m = new MaximumPointCards();
    int[] cardPoints = {1,2,3,4,5,6,1};
    System.out.print(m.maxScore(cardPoints, 3));
  }
}
